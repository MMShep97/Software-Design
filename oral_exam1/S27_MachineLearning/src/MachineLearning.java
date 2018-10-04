import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This assignment is part of the homework grid listed in Introduction to Software Design, taught by Professor Casavant.
 * This program takes two equal-length arrays to calculate cosine similarity or euclidean distance, based on the user's
 * preference, and two strings representing binary values to calculate the hamming distance.
 * @author Marc Shepherd
 * @version 1.0, 10/3/2018
 * @since SDK 1.8
 */

public class MachineLearning {

    public static void main(String [] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double [] array1 = {1, 2, 3};
        double [] array2 = {2, 6, 3};
        String binary1 = "0110101";
        String binary2 = "1110010";
        boolean flag = true;
        int choice = -1;

        System.out.println("What would you like calculated?\n"
                         + "1 - Cosine Similarity\n"
                         + "2 - Euclidean Distance\n"
                         + "3 - Hamming Distance\n"
                         + "4 - Exit");

        while (flag) {
            System.out.println("New value? ");

            try {
                choice = Integer.parseInt(input.readLine());
            }
            catch (NumberFormatException ex) {
                System.err.println("You entered a non-integer value.");
            }

            switch (choice) {
                //Cosine Similarity
                case 1:
                    double cos = Similarity.calculateCosineSimilarity(array1, array2);
                    System.out.println("Cosine Similarity: " + cos);
                    break;
                //Euclidean Distance
                case 2:
                    double euc = Similarity.calculateEuclideanDistance(array1, array2);
                    System.out.println("Euclidean Distance: " + euc);
                    break;
                //Hamming Distance
                case 3:
                    int ham = Similarity.calculateHamming(binary1, binary2);
                    System.out.println("Hamming Distance: " + ham);
                    break;
                //Exit
                case 4:
                    System.out.println("Exiting program.");
                    flag = false;
                    break;
                //Invalid option
                default:
                    System.out.println("Invalid option, try again...");
                    break;
            }
        }
    }


}
