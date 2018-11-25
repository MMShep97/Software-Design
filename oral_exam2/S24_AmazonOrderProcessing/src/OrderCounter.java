/**
 * Responsible for keeping track of entries completed and sent out by the trucks.
 * Every thread holds a shared instance of this class and checks <code>while orderInfo.getNumCompleted() less than orderInfo.getTotal</code>.
 * Trucks <code>incrementNumCompleted</code> when they finish with one
 */
public class OrderCounter {

    //Class variables
    private int total; //total lines, or entries, in file
    private int numCompleted; //number of entries completed thus far

    /**
     * Sets total entries in file
     * @param total
     */
    public synchronized void setTotal(int total) {
        this.total = total;
    }
    /**
     * Gets total entries in file
     * @return entries in file
     */
    public synchronized int getTotal() {
        return total;
    }
    /**
     * Gets entries completed
     * @return
     */
    public synchronized int getNumCompleted() {
        return numCompleted;
    }
    /**
     * Increments number of entries completed by 1, updated in <code>Truck</code> class in <code>run()</code> method
     */
    public synchronized void incrementNumCompleted() {
        numCompleted++;
    }
}
