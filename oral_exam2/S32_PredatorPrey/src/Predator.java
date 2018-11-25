public interface Predator {

    static double directPredatorGrowthWith1Prey(double delta, double gamma, double preyCount, double predatorCount) {
        return ((delta * preyCount * predatorCount) - (gamma * predatorCount));
    }
}