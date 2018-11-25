/**
 * The Shipping Dock nodes will fill up the buffers to the trucks as there is room available. They will start with truck 1.
 * If the buffer for Truck 1 is full, then try truck 2.  If they are all full, then wait until one buffer becomes available.
 */
public class ShippingDock implements Runnable {

    private Buffer section; //Which shipping center section is input coming from
    private Buffer truck1, truck2; //truck 1 or truck 2? 2 output buffers
    private OrderCounter orderCounter; //Used to continue processing until no more available

    /**
     * @param inputBuffer -- Gets input from shipping center sections
     * @param outputBuffer1 -- Outputs to truck 1
     * @param outputBuffer2 -- Outputs to truck 2
     * @param orderCounter -- Used to continue processing until no more available
     */
    public ShippingDock(Buffer inputBuffer, Buffer outputBuffer1, Buffer outputBuffer2, OrderCounter orderCounter) {
        this.section = inputBuffer;
        this.truck1 = outputBuffer1;
        this.truck2 = outputBuffer2;
        this.orderCounter = orderCounter;
    }

    /**
     * Runnable method that gets implicitly called when a new thread is started, does everything as mentioned in the class javadoc section above.
     */
    @Override
    public synchronized void run() {
        while (orderCounter.getNumCompleted() < orderCounter.getTotal()) {
            OrderInformation orderInfo = section.blockingGet();
            this.addToTruckWhenAvailable(orderInfo);
        }
    }

    /**
     * Attempts to put order information into truck 1 first, then truck 2 if truck 1 is full. If both are full, waits for one to become empty
     * @param orderInfo -- Order information being processed
     */
    private synchronized void addToTruckWhenAvailable(OrderInformation orderInfo) {
        boolean added = false;

        while (!added) {
            if (!truck1.getOccupied()) {
                truck1.blockingPut(orderInfo);
                added = true;
            } else if (!truck2.getOccupied()) {
                truck2.blockingPut(orderInfo);
                added = true;
            }
        }
    }
}
