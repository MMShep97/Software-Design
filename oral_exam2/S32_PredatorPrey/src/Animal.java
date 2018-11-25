public class Animal implements Predator, Prey{

    private Coefficient coefficient;
    private double numSpecies;

    public Animal(double numSpecies) {
        this.numSpecies = numSpecies;
        System.out.println(numSpecies + "are in this model");
    }

    public void test() {
        System.out.println("ANIMAL");
    }

    public double getNumSpecies() {
        return numSpecies;
    }

    @Override
    public double directPreyGrowthWith2Predators() {
        return 0;
    }
}
