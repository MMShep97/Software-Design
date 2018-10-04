import java.util.UUID;

/**
 * This class is a more specified version of <code>PostPaymentRequest</code>, additionally requiring an encryption scheme
 * to be involved as part of the payment request.
 * @author Marc Shepherd
 * @version 1.0, 10/3/2018
 * @since SDK 1.8
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest {
    private String randEncryptionScheme;
    private static int count;

    /**
     *
     * @param randomUUID
     * @param randomIP
     * @param randomPayment
     * @param randomEncryptionScheme
     */
    public PostEncryptedPaymentRequest(UUID randomUUID, String randomIP, Payment randomPayment, String randomEncryptionScheme) {
        super(randomUUID, randomIP, randomPayment);
        this.randEncryptionScheme = randomEncryptionScheme;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + a random encryption scheme
     */
    @Override
    public String toString() {
        return super.toString() + " | This payment was encrypted with " + randEncryptionScheme;
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
