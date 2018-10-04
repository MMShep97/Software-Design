import java.util.UUID;

public class PostFormRequest extends PostRequest {
    private Form randForm;
    private static int count;

    public PostFormRequest(UUID randomUUID, String randomIP, Form randomForm) {
        super(randomUUID, randomIP);
        this.randForm = randomForm;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + a name, favorite color,
     * and favorite encryption scheme
     */
    @Override
    public String toString() {
        return super.toString()
                + "\n-Form-"
                + "\nName: " + randForm.getNameFromMap()
                + "\nFavorite Color: " + randForm.getColorFromMap()
                + "\nFavorite Encryption Scheme: " + randForm.getEncryptionSchemeFromMap();
    }

    /**
     * Version of <code>Request</code> class method that increases it's count and it's subclasses to return a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return count
     */
    public static int count() {
        count++;
        return count + PostEncryptedFormRequest.count();
    }
}
