/**
 * This class acts as the payment section, where the dataGenerator gets it's payment info from
 * @author Marc Shepherd
 * @version 1.1, 10/3/2018
 * @since SDK 1.8
 */
public class Payment {
    private String randName, randName2;
    private int randInt;

    /**
     * Payment takes in 3 arguments and initializes the private variables to them, i.e. random name 1 and 2, as well as
     * a random integer
     * @param randomName
     * @param randomInt
     * @param randomName2
     */
    public Payment(String randomName, int randomInt, String randomName2) {
        this.randName = randomName;
        this.randName2 = randomName2;
        this.randInt = randomInt;
    }

    public String getRandName() {
        return randName;
    }

    public String getRandName2() {
        return randName2;
    }

    public int getRandInt() {
        return randInt;
    }
}
