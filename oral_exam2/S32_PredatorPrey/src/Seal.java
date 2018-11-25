public class Seal extends Animal implements Predator, Prey{

    public Seal(double numSeals) {
        super(numSeals);
    }

    public void test() {
        super.test();
        System.out.println("SEAL");
    }
}
