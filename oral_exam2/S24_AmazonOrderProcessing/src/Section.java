import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * The Shipping Center Sections will do the following:
 * Receive order
 * Append the Shipping Center Section number to the order for tracking purposes
 * Pause for 0-5 seconds.  This period must be decided randomly
 * Put order on the Shipping Dock's buffer
 */
public class Section implements Runnable {

    private Buffer shippingCenter; //input buffer
    private Buffer shippingDock; //output buffer
    private OrderCounter orderCounter; //Used to continue processing until no more available
    private String sectionNum; //used to append which section currently in

    /**
     * @param inputBuffer -- from shipping center
     * @param outputBuffer -- to shipping dock
     * @param orderCounter -- Used to continue processing until no more available
     * @param sectionNum //used to append which section currently in
     */
    Section(Buffer inputBuffer, Buffer outputBuffer, OrderCounter orderCounter, String sectionNum) {
        this.shippingCenter = inputBuffer;
        this.shippingDock = outputBuffer;
        this.orderCounter = orderCounter;
        this.sectionNum = sectionNum;
    }

    /**
     * Runnable method that gets implicitly called when a new thread is started, does everything as mentioned in the class javadoc section above.
     */
    @Override
    public synchronized void run() {
        while (orderCounter.getNumCompleted() < orderCounter.getTotal()) {
            try {
                OrderInformation orderInfo = shippingCenter.blockingGet(); //Receive order
                orderInfo.setShippingSection(sectionNum);
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 5000));
                shippingDock.blockingPut(orderInfo); //put order on shipping dock's buffer
            } catch (Exception ex) {
                System.err.println("INTERRUPTED EXCEPTION IN SHIPPING CENTER SECTION");
            }
        }
    }
}
