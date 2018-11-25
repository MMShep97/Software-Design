import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Reads from csv file
 * Receives orders containing the following information:
 * Address
 * Name
 * Item
 * Category
 * Sends information to either shipping center 1 or 2 through an instance of OrderInformation
 * For each order received, it decides which Shipping Center to send it to based on the following logic:
 *
 * Orders that go to shipping center 1:
 *      Los angeles
 *      San Fransisco
 *      Seattle
 *      Denver
 * Orders that go to shipping center 2:
 *      Everything else
 * Also, when this node reaches the end of orders in the .csv file, it must send some sort of indication to all
 * the Shipping Center nodes through the shared buffer that the end has been reached and then terminate.
 */

public class AmazonWebServer implements Runnable {

    //Class variables, descriptions in constructor
    private Buffer AWStoShippingCenter1Buffer;
    private Buffer AWStoShippingCenter2Buffer;
    private OrderCounter orderCounter;
    private String filename;

    /**
     * @param outputBuffer1 -- outputs to shipping center 1
     * @param outputBuffer2 -- outputs to shipping center 2
     * @param orderCounter -- Used to continue processing until no more available
     */
    public AmazonWebServer(Buffer outputBuffer1, Buffer outputBuffer2, OrderCounter orderCounter, String filename) {
        AWStoShippingCenter1Buffer = outputBuffer1;
        AWStoShippingCenter2Buffer = outputBuffer2;
        this.orderCounter = orderCounter;
        this.filename = filename;
    }

    /**
     * Runnable method that gets implicitly called when a new thread is started, does everything as mentioned in the class javadoc section above.
     */
    @Override
    public synchronized void run() {
        String line, address = null, city = null, name = null, item = null, category = null;
        String[] info;

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            LineNumberReader lnr = new LineNumberReader(fr);
            int linenumber = 0;

            while (lnr.readLine() != null){
                linenumber++;
            }
            int fileLength = linenumber - 1;
            orderCounter.setTotal(fileLength); //Sets total entries in specified file
            lnr.close();

            assert br != null;
            br.readLine(); //get rid of header information
            while ((line = br.readLine()) != null) {
                info = line.split(",");

                //Assigning information to store inside of 'OrderInformation' instance
                address = info[0].toLowerCase();
                city = info[1].toLowerCase();
                name = info[4].toLowerCase();
                item = info[5].toLowerCase();
                category = info[6].toLowerCase();

                if (city.equals("los angeles") || city.equals("san francisco") || city.equals("seattle") || city.equals("denver")) {
                    AWStoShippingCenter1Buffer.blockingPut(new OrderInformation(address, city, name, item, category));
                } else {
                    AWStoShippingCenter2Buffer.blockingPut(new OrderInformation(address, city, name, item, category));
                }
            }

        } catch (IOException e) {System.err.println("IO EXCEPTION IN AWS");}

        //Prints when it is done sending all entries out
        System.out.println("- FROM AWS: END OF CSV FILE REACHED -");
    }

    public synchronized void setFileName(String filename) {
        this.filename = filename;
    }
}
