import java.util.*;
import java.io.*;

/**
 * The problem
 The edit distance between two strings is the number of operations required to convert one string into the other.
 There are three operations than can be preformed on one string to convert it.
 1. Adding a character
 2. Removing a character
 3. Replacing a character

 Each of these operations adds to the edit distance

 Hard
 Create an efficient (iterative, not recursive) algorithm to compute the edit distance between two strings.
 Be prepared to explain all aspects of your solution (code and conceptual) in your oral exam.

 Examples
 str1: 'ab'
 str2: 'abz'
 edit distance: 1 --> add 'z' to str1

 str1: 'abc'
 str2: 'ab'
 edit distance: 1 --> remove c from str1

 str1: 'abc'
 str2: 'abd'
 edit distance: 1 --> replace 'c' in str1 with a 'd'
 */

public class EditDistanceMain {

    public static void main(String [] args) throws IOException {

        //Variables
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String strings = "";
        String[] argsV = {};
        int argsSize = 0;

        //Interaction and explanation
        System.out.println("-- Welcome to the edit distance calculation program! --\n" +
                            "-- Please enter your desired strings in the format: [string1] [string2] --\n" +
                            "-- The edit distance will be calculated in terms of the " +
                            "number of steps converting from string 1 to string 2 --");

        //Repeat until user has correct input format
        while (argsSize != 2) {
            strings = input.readLine();
            argsV = strings.split(" ");
            argsSize = argsV.length;

            //Arguments should be split, only two strings should be set
            if (argsV.length != 2) {
                System.err.println("Please enter your desired strings in a valid format");
            }
        }

        //Calculation of edit distance
        int editDistance = Calculation.calculateEditDistance(argsV[0], argsV[1]);
        System.out.println("Edit Distance: " + editDistance);
    }
}
