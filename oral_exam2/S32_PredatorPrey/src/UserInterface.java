import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    public static void main(String [] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Double> coefficients = new ArrayList<>();

        System.out.println("- In this simulation, a predator-prey relationship will be modeled -\n" +
                "- Specifically, from the top of the food chain to the lowest of the bunch, we have - \n" +
                "- Human --> Orca --> Seal --> Squid -");
        System.out.println("\nPlease enter [alpha beta delta gamma} exactly as shown, all on the same line.\n" +
                            "--------------------------------\n" +
                            "Prey\n" +
                            "--------------------------------\n" +
                            "Alpha = Growth coefficient\n" +
                            "Beta = Predation coefficient\n" +
                            "--------------------------------\n" +
                            "Predators\n" +
                            "--------------------------------\n" +
                            "Delta = Growth coefficient\n" +
                            "Gamma = Death coefficient\n");

        while (args.length != 4) {
            try {
                args = input.readLine().split(" ");
            } catch (IOException ex) {
            }
            if (args.length != 4) {
                System.err.println("Try again with the valid format");
            }
        }
        for (int i = 0; i < args.length; i++) {
            coefficients.add(new Double(args[i]));
        }

        Simulate simulator = new Simulate();
        simulator.simulatePredatorPrey(coefficients);
    }
}
