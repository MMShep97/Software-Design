import java.util.UUID;

public class PostPaymentRequest extends PostRequest {
    private Payment randPayment;
    private static int count;

    public PostPaymentRequest(UUID randomUUID, String randomIP, Payment randomPayment) {
        super(randomUUID, randomIP);
        this.randPayment = randomPayment;
    }

    /**
     * Overriden version of <code>toString</code> method, printing out the super classes data + it's own random payment sender,
     * random payment amount, and random receiver
     * @return  String of every piece of data listed
     */
    @Override
    public String toString() {
        return super.toString()
                    + "\n--Payment Data--\nPayment Sender: " + randPayment.getRandName()
                    + "\nPayment Amount: " + randPayment.getRandInt()
                    + "\nPayment Receiver: " + randPayment.getRandName2();

    }


    /**
     * Version of <code>Request</code> class method that increases it's count and it's subclasses to return a static count field
     * as its return type (static to keep track of all requests in this class over the entire period)
     * @return count
     */
    public static int count() {
        count++;
        return count + PostEncryptedPaymentRequest.count();
    }
}
