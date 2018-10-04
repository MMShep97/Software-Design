import java.util.UUID;

/**
 * This class is the home for getting requests, using its super classes methods <code>Request</code>.
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */
public class GetRequest extends Request{
    private String randURL;
    private static int count;

    public GetRequest(UUID randomUUID, String randomURL) {
        super(randomUUID);
        this.randURL = randomURL;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + a random URL
     * @return  String of every piece of data listed
     */
    @Override
    public String toString() {
        return super.toString() + " | URL: " + randURL;
    }

    /**
     * Version of <code>Request</code> class method that increases it's count and it's subclasses to return a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return count
     */
    public static int count() {
        count++;
        return count + GetFileRequest.count() + GetVideoRequest.count();
    }
}
