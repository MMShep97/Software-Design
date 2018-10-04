import java.util.UUID;

/**
 * This class is the home for getting video requests, using its super classes methods <code>GetRequest</code>.
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */
public class GetVideoRequest extends GetRequest {
    private Video randVideo;
    private static int count;

    /**
     * The video request takes in two values, a random UUID, and a random video object, which is used in the toString
     * method to access the Video's instance variables
     * @param randomUUID
     * @param randomVideo
     */
    public GetVideoRequest(UUID randomUUID, Video randomVideo) {
        super(randomUUID, randomVideo.getRandomURL());
        this.randVideo = randomVideo;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + a random video title
     * and random name
     **/
    @Override
    public String toString() {
        return super.toString()
                + " | Video Title: " + randVideo.getRandVideoTitle()
                + " | Name: " + randVideo.getRandName();
    }

    /**
     * Version of <code>Request</code> class method that increases it's count and it's subclasses to return a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return count
     */
    public static int count() {
        count++;
        return count;
    }
}
