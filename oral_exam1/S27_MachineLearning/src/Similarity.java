/**
 * This class implements functions to calculate mathematical formulas that are closely related with machine learning applications.
 * @author Marc Shepherd
 * @version 1.0, 10/3/2018
 * @since SDK 1.8
 */
public class Similarity {

    /**
     * Calculates the cosine similarity of 2 equal-length arrays using the formula:
     * Dot product of two arrays over the magnitudes of each multiplied together
     * @param cosArray1
     * @param cosArray2
     * @return
     */
    public static double calculateCosineSimilarity(double [] cosArray1,  double [] cosArray2) {

        //variables
        double numerator = 0;
        double denominator1 = 0;
        double denominator2 = 0;

            //run if equal length
            if (cosArray1.length == cosArray2.length) {
                for (int i = 0; i < cosArray1.length; i++) {
                    numerator += cosArray1[i] * cosArray2[i];  //Adding the dotted values
                    denominator1 += Math.pow(cosArray1[i], 2); //Adding the squared terms of 1
                    denominator2 += Math.pow(cosArray2[i], 2); //Adding the squared terms of 2
                }
                denominator1 = Math.sqrt(denominator1); //Take square root of squared sum 1
                denominator2 = Math.sqrt(denominator2); //Take square root of squared sum 2

                return (numerator) / ( (denominator1) * (denominator2) ) ;
            }
        System.err.println("Unequal array lengths.\n" +
                           "Returning a default value...");
        return 0;
    }

    /**
     * Calculates the euclidean distance of 2 equal-length arrays using the formulas
     * sqrt((pi - qi)^2 + ... + (p(i+1) + q(i+1))^2)
     * @param eucArray1
     * @param eucArray2
     * @return      euclidean distance
     */
    public static double calculateEuclideanDistance(double [] eucArray1, double [] eucArray2) {
        double differenceSquared = 0.0;
        double eucDistance;

        //run if equal length
        if (eucArray1.length == eucArray2.length) {
            for (int i = 0; i < eucArray1.length; i++) {
                differenceSquared += Math.pow((eucArray1[i] - eucArray2[i]), 2); //Square the difference of each indice
            }
            eucDistance = Math.sqrt(differenceSquared); //Square root of squared values sum
            return eucDistance;
        }
        //else uneven array lengths
        System.err.println("Unequal array lengths.\n" +
                           "Returning a default value of ");
        return 0;
    }

    /**
     * Calculates hamming distance, which counts the number of bits that are not similar to each other
     * @param binary1
     * @param binary2
     * @return  hamming distance, and int
     */
    public static int calculateHamming(String binary1, String binary2) {
        int hamDistance = 0;

        //run if equal length
        if (binary1.length() == binary2.length()) {
            for (int i = 0; i < binary1.length(); i++) {
                if (binary1.charAt(i) != binary2.charAt(i)) {
                    hamDistance++;
                }
            }
            return hamDistance;
        }
        //else uneven array lengths
        System.err.println("Unequal array lengths.\n" +
                "Returning a default value of ");
        return 0;
    }
}
