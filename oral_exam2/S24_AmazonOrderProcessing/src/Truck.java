import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * The trucks perform the following sequence:
 * Read from their input buffer until they have received 4 deliveries or receive notification that there are no more deliveries.  On each delivery, they must append the truck number for tracking purposes.
 * For each of the four deliveries (or less if the "no more deliveries" notification was received), do the following:
 * Sleep for 0-10 seconds.  This period must be decided randomly.
 * Print out the information on the shipping order to the screen
 * The truck also must also print out a message to the screen after it has received the -no more deliveries- notification and delivered its last order indicating that it is done delivering.  This message should specify the truck’s number and the number of its associated shipping center.
 * The Shipping order information printed to the screen must include the following information:
 *      Delivery address
 *      Name on order
 *      Item ordered
 *      Item category
 *      Shipping Center the order went through
 *      Shipping Center Section the order went through
 *      Delivery Truck the order was delivered on
 */
public class Truck implements Runnable {

    private String truckNum; //used to append to order information
    private Buffer ShippingDock; //input buffer
    private OrderCounter orderCounter; //used to continue processing until no more available
    private int deliveriesMade = 0; //used to stop truck from delivering more than 4 orders

    /**
     * @param inputBuffer -- Used to get input from shipping dock
     * @param orderCounter -- Used to continue processing until no more available
     * @param truckNum -- used to append to order information
     */
    Truck(Buffer inputBuffer, OrderCounter orderCounter, String truckNum) {
        this.ShippingDock = inputBuffer;
        this.truckNum = truckNum;
        this.orderCounter = orderCounter;
    }
    /**
     * Runnable method that gets implicitly called when a new thread is started, does everything as mentioned in the class javadoc section above.
     */
    @Override
    public synchronized void run() {

        OrderInformation orderInfo = null;

        while ( ( orderCounter.getNumCompleted() < orderCounter.getTotal())) {
            try {
                orderInfo = ShippingDock.blockingGet();
                orderInfo.setTruckNum(truckNum);
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 10000));
                orderInfo.printOrderInformation();
                orderCounter.incrementNumCompleted();
            } catch (Exception ex) {
                System.err.println("INTERRUPTED EXCEPTION IN TRUCK");
            }
        }
//        this.checkDeliveriesComplete(orderInfo);
//        if (!(orderCounter.getNumCompleted() < orderCounter.getTotal())) {
//            System.out.println("- No more deliveries -");
//        }
    }

//    private synchronized void incrementDeliveriesMade() {
//        this.deliveriesMade++;
//    }

//    private synchronized void checkDeliveriesComplete(OrderInformation orderInfo) {
//        if (this.deliveriesMade  >= 4) {
//            orderInfo.printTruckNotification();
//        }
//    }
}
