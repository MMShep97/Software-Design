import java.io.*;
import java.util.*;

/**
 * The Shipping Center must decide which part of the warehouse the item is in and send a command to the appropriate
 * forklift to go get it and deliver it to the shipping dock. The Shipping Center organizes items based on the
 * first letter of their category.  It will also append the Shipping Center number to the order for tracking purposes.
 * The processing is as follows:
 *      Orders with categories beginning with A-P go to Section 1
 *      Orders with categories beginning with Q-Z go to Section 2
 */
public class ShippingCenter implements Runnable {

    //Class variables
    private Buffer AWStoShippingCenterBuffer; //Input buffer
    private Buffer shippingCentertoSection1; //Output buffer to section 1
    private Buffer shippingCentertoSection2; //Output buffer to section 2
    private OrderCounter orderCounter; //used for while loop processing
    private String shippingCenterNum; //Used to append to order information

    /**
     *
     * @param inputBuffer -- Getting input (orderInfo) from AWS
     * @param outputBuffer1 -- Output to section 1
     * @param outputBuffer2 -- Output to section 2
     * @param orderCounter -- Used to continue processing until no more available
     * @param shippingCenterNum -- Determines which shipping center is being used and is appended to order information
     */
    public ShippingCenter(Buffer inputBuffer, Buffer outputBuffer1, Buffer outputBuffer2, OrderCounter orderCounter, String shippingCenterNum) {
        AWStoShippingCenterBuffer = inputBuffer;
        shippingCentertoSection1 = outputBuffer1;
        shippingCentertoSection2 = outputBuffer2;
        this.orderCounter = orderCounter;
        this.shippingCenterNum = shippingCenterNum;
    }

    /**
     * Runnable method that gets implicitly called when a new thread is started, does everything as mentioned in the class javadoc section above.
     */
    @Override
    public synchronized void run() {
        while (orderCounter.getNumCompleted() < orderCounter.getTotal()) {
            OrderInformation orderInfo = this.AWStoShippingCenterBuffer.blockingGet();
            orderInfo.setShippingCenterNum(shippingCenterNum);
            if (orderInfo.category.charAt(0) <= 'p') {
                shippingCentertoSection1.blockingPut(orderInfo);
            } else {
                shippingCentertoSection2.blockingPut(orderInfo);
            }
        }
    }
}
