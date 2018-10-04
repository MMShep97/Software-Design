import java.util.UUID;

/**
 * This class is the home for requesting files, using its super classes methods <code>GetRequest</code>.
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */
public class GetFileRequest extends GetRequest {
    private File randFile;
    private static int count;

    /**
     * Constructs object fields, specifically a random UUID and random file
     * @param randomUUID
     * @param randomFile
     */
    public GetFileRequest(UUID randomUUID, File randomFile) {
        super(randomUUID, randomFile.getRandFilePath());
        this.randFile = randomFile;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + it's own file path and type
     * @return  String of every piece of data listed
     */
    @Override
    public String toString() {
        return super.toString()
                + " | File Path: " + randFile.getRandFilePath()
                + " | File Type: " + randFile.getRandFileType();
    }

    /**
     * Overriden version of <code>Request</code> class that increases it's count and returns a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return
     */

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
