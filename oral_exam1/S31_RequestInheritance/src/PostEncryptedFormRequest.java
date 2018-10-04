import java.util.UUID;

/**
 * This class is the home for requesting files, using its super classes methods <code>GetRequest</code>.
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */
public class PostEncryptedFormRequest extends PostFormRequest {
    private String randEncryptionScheme;
    private static int count;

    /**
     * Takes in a random UUID, a random IP, a random form, and a random encryption scheme.
     * @param randomUUID
     * @param randomIP
     * @param randomForm
     * @param randomEncryptionScheme
     */
    public PostEncryptedFormRequest(UUID randomUUID, String randomIP, Form randomForm, String randomEncryptionScheme) {
        super(randomUUID, randomIP, randomForm);
        this.randEncryptionScheme = randomEncryptionScheme;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + a random encryption scheme
     */
    @Override
    public String toString() {
        return super.toString() + " | This form was encrypted with " + randEncryptionScheme;
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
