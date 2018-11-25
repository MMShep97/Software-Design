/**
 * Contains order information from file, used to store and ultimately output the stored information in <code>Truck</code> class.
 * New instances are created in the <code>AmazonWebServer</code> class while being put into the shared buffer. Gotten and put throughout
 * each process, from AWS TO Shipping Center TO Shipping Dock TO Section TO Truck...
 */
public class OrderInformation {
    //Class variables
    public String address, city, name, item, category, shippingCenterNum, shippingSection, truckNum;

    /**
     * @param address -- delivery address
     * @param city -- city coming from
     * @param name -- deliver to, name
     * @param item -- item being delivered
     * @param category -- category of item being delivered
     */
    public OrderInformation(String address, String city, String name, String item, String category) {
        this.address = address;
        this.city = city;
        this.name = name;
        this.item = item;
        this.category = category;
    }

    /**
     * Prints order information to be output by <code>Truck</code> class
     */
    public synchronized void printOrderInformation() {
        System.out.println(
                "Address: " + address + " | " +
                "Name: " + name + " | " +
                "Item: " + item + " | " +
                "Category: " + category + " | " +
                "Shipping Center: " + shippingCenterNum + " | " +
                "Shipping Section: " + shippingSection + " | " +
                "Delivery Truck: " + truckNum
        );
    }

    public synchronized void printTruckNotification() {
        System.out.println("Truck number " + truckNum + " from shipping center " + shippingCenterNum + " has no more deliveries.");
    }

    //Setters for shipping center, shipping section, and truck numbers to be appended within their respective classes
    public synchronized void setShippingCenterNum(String num) { this.shippingCenterNum = num; }
    public synchronized void setShippingSection(String section) { this.shippingSection = section; }
    public synchronized void setTruckNum(String num) { this.truckNum = num; }
}