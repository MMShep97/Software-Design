public class Human extends Animal implements Predator{

    public Human(double numHumans) {
        super(numHumans);
    }

    @Override
    public void test() {
        System.out.println("HUMAN");
    }
}
