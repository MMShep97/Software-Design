import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Responsible for keeping a shared link between two nodes, used to pass information between the two. One node's output buffer
 * is generally the next node's input buffer, as the parent node will generally <code>blockingPut()</code> the order information
 * into the buffer, and will wait to process another order until the child node can <code>blockingGet()</code>. This is possible because
 * of the <code>ArrayBlockingQueue</code> which has a capacity of 1 to deal with one order at a time.
 */
public class Buffer {

    private OrderInformation orderInfo; //order information instance
    private boolean occupied = false; //Queue begins as non-occupied
    private BlockingQueue<OrderInformation> queue = new ArrayBlockingQueue<>(1); //Queue with size of 1 to process entry orders

    /**
     * Puts order information into <code>ArrayBlockingQueue</code> if there is not something in it. Blocks by <code>wait()</code> method
     * until content is <code>blockingGet()</code> from queue i.e. if the queue is full
     * @param orderInfo -- instance that is put into queue
     */
    public synchronized void blockingPut(OrderInformation orderInfo){
        try {
            while (occupied) {
                wait();
            }
            queue.put(orderInfo);
            occupied = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets order information out of <code>ArrayBlockingQueue</code> if there is something in it. Blocks by <code>wait()</code> method
     * until content is <code>blockingPut()</code> into the queue
     * @return <code>OrderInformation</code> instance that is gotten from queue
     */
    public synchronized OrderInformation blockingGet(){
        try {
            while (!occupied) {
                wait();
            }
            // take method to get from blockingqueue
            orderInfo = queue.take();
            occupied = false;
            notifyAll(); //or maybe notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return orderInfo;
    }

    /**
     * Gets occupied for use in <code>ShippingDock</code>
     * @return boolean variable <code>occupied</code>
     */
    public synchronized boolean getOccupied() {
        return occupied;
    }
}