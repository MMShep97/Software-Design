import java.util.UUID;

/**
 * /**
 * This class is the base of all requests and every subclass stacks upon each other starting from here
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */

public class Request extends DataGenerator {

    private UUID randUUID;
    private static int count = 0;

    public Request(UUID randomUUID) {
        this.randUUID = randomUUID;
    }

    /**
     * Prints out random UUID
     * @return  String of every piece of data listed
     */
    public String toString() {
        return "UUID: " + randUUID;
    }

    /**
     * <code>Request</code> class method that increases it's count and it's subclasses to return a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return  count
     */
    public static int count() {
        count++;
        return count + PostRequest.count() + GetRequest.count();
    }
}


