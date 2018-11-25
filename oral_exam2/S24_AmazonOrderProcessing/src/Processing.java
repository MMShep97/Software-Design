import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Time;
import java.util.concurrent.*;

/**
 * Holds all buffers -- threads are created and managed by executor service.
 * Main method creates a <code>Processing</code> instance and invokes the <code>process()</code> method.
 */
public class Processing {
    //Shared buffers
    private Buffer AWStoShippingCenter1Buffer = new Buffer(); //AWS --> Shipping Centers
    private Buffer AWStoShippingCenter2Buffer = new Buffer();
    private Buffer shippingCenter1toSection1 = new Buffer(); //Shipping Centers --> Sections
    private Buffer shippingCenter1toSection2 = new Buffer();
    private Buffer shippingCenter2toSection1 = new Buffer();
    private Buffer shippingCenter2toSection2 = new Buffer();
    private Buffer section1ToShippingDock1 = new Buffer(); //Sections --> Shipping Docks
    private Buffer section2ToShippingDock1 = new Buffer();
    private Buffer section1ToShippingDock2 = new Buffer();
    private Buffer section2ToShippingDock2 = new Buffer();
    private Buffer shippingDock1toTruck1 = new Buffer(); //Shipping Docks --> Trucks
    private Buffer shippingDock1toTruck2 = new Buffer();
    private Buffer shippingDock2toTruck1 = new Buffer();
    private Buffer shippingDock2toTruck2 = new Buffer();

    /**
     * Creates an executor service to run/manage all threads. The executor service takes in a runnable command, in this case takes
     * in a new instances from different classes and brings in their respective input/output buffers. An <code>OrderCounter</code>
     * instance is also created and appended to the arguments for each class instance to keep track of the number of entries/orders
     * fulfilled thus far. This allows the threads to continue processing until all entries have been completed.*/
    public void process() {

        ExecutorService executorService = Executors.newCachedThreadPool();
        OrderCounter orderCounter = new OrderCounter();
        executorService.execute(new AmazonWebServer(AWStoShippingCenter1Buffer, AWStoShippingCenter2Buffer, orderCounter, this.getUserInput()));
        executorService.execute(new ShippingCenter(AWStoShippingCenter1Buffer, shippingCenter1toSection1, shippingCenter1toSection2, orderCounter, "1")); //SC1
        executorService.execute(new ShippingCenter(AWStoShippingCenter2Buffer, shippingCenter2toSection1, shippingCenter2toSection2, orderCounter, "2")); //SC2
        executorService.execute(new Section(shippingCenter1toSection1, section1ToShippingDock1, orderCounter, "1")); //SC1 section 1
        executorService.execute(new Section(shippingCenter1toSection2, section2ToShippingDock1, orderCounter, "2")); //SC1 section 2
        executorService.execute(new Section(shippingCenter2toSection1, section1ToShippingDock2, orderCounter, "1")); //SC2 section 1
        executorService.execute(new Section(shippingCenter2toSection2, section2ToShippingDock2, orderCounter, "2")); //SC2 section 2
        executorService.execute(new ShippingDock(section1ToShippingDock1, shippingDock1toTruck1, shippingDock1toTruck2, orderCounter)); //SD1
        executorService.execute(new ShippingDock(section2ToShippingDock1, shippingDock1toTruck1, shippingDock1toTruck2, orderCounter)); //SD2
        executorService.execute(new ShippingDock(section1ToShippingDock2, shippingDock2toTruck1, shippingDock2toTruck2, orderCounter));
        executorService.execute(new ShippingDock(section2ToShippingDock2, shippingDock2toTruck1, shippingDock2toTruck2, orderCounter));
        executorService.execute(new Truck(shippingDock1toTruck1, orderCounter, "1")); //SD1 truck 1
        executorService.execute(new Truck(shippingDock2toTruck1, orderCounter, "1")); //SD1 truck 2
        executorService.execute(new Truck(shippingDock1toTruck2, orderCounter, "2")); //SD2 truck 1
        executorService.execute(new Truck(shippingDock2toTruck2, orderCounter, "2")); //SD2 truck 2
        executorService.shutdown();

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException ex) {}
        while (orderCounter.getNumCompleted() < orderCounter.getTotal()) {}
        System.out.println("- No more deliveries -");
        System.exit(1);
    }

    public static void main (String [] args) {
        Processing processor = new Processing();
        processor.process();
    }

    /**
     * Polls user for input of file to store in AWS object in process method above
     * @return filename
     */
    public synchronized String getUserInput() {
        String filename = null;
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the full path of your desired file (ex. C:\\Users\\Marc.MARC-PC\\IdeaProjects\\mmshepherd_swd\\oral_exam2\\S24_AmazonOrderProcessing\\orders.csv ");
        try {
            filename = userInput.readLine();
        } catch (IOException ex) {}
        return filename;
    }
}

