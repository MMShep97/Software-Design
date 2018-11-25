public interface Prey {

    //Return number of prey
    static double directPreyGrowthWith1Predator(double alpha, double beta, double preyCount, double predatorCount) {
        return ( (alpha * preyCount) - (beta * preyCount * predatorCount) );
    }
    double directPreyGrowthWith2Predators();

    //PREY GROWTH RATE: a * prey     -      b  *  prey  *  predators
    //PREDATOR GROWTH RATE: d * prey * predators               -     gamma * predators
}