import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Simulate {

    private final int ITERATIONS = 20;

    private Animal human;
    private Animal orca;
    private Animal seal;
    private Animal squid;


    public void simulatePredatorPrey(List<Double> coefficients) {

    double alpha = coefficients.get(0);
    double beta = coefficients.get(1);
    double delta = coefficients.get(2);
    double gamma = coefficients.get(3);

    //Coefficient coefficient = new Coefficient(coefficients.get(0), coefficients.get(1), coefficients.get(2), coefficients.get(3));
    human = new Human(40);
    orca = new Orca(1000);
    seal = new Seal(100);
    squid = new Squid(120);

    double numHumans = human.getNumSpecies();
    double numOrcas = orca.getNumSpecies();
    double numSeals = seal.getNumSpecies();
    double numSquids = squid.getNumSpecies();
    double numPredators;
    double numPrey;

    for (int i = 0; i < ITERATIONS; i++) {
        try {
            numPredators = Math.ceil(Predator.directPredatorGrowthWith1Prey(delta, gamma, numOrcas, numHumans));
            numPrey = Math.ceil(Prey.directPreyGrowthWith1Predator(alpha, beta, numOrcas, numHumans));
            System.out.println("Number of predators: " + numPredators);
            System.out.println("Number of prey: " + numPrey);
            numHumans = numPredators;
            numOrcas = numPrey;
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch(InterruptedException ex) {}
    }

}





}
