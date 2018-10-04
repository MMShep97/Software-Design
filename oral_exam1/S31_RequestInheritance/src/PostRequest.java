import java.util.UUID;

public class PostRequest extends Request {
    private String randIP;
    private static int count;

    public PostRequest(UUID randomUUID, String randomIP) {
        super(randomUUID);
        this.randIP = randomIP;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + it's own IP address
     * @return  String of every piece of data listed
     */
    @Override
    public String toString() {
        return super.toString() + " | " + "Post request to server with IP address " + randIP;
    }

    /**
     * Version of <code>Request</code> class method that increases it's count and it's subclasses to return a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return count
     */
    public static int count() {
        count++;
        return count + PostPaymentRequest.count() + PostFormRequest.count();
    }
}
