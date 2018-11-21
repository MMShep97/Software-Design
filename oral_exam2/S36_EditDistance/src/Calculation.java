import java.util.*;
import java.io.*;

/**
 * Container class for singular calculation method that calculates the edit distance from one string to another
 */
public class Calculation {

    /**
     *  The edit distance between two strings is the number of operations required to convert one string into the other.
     * There are three operations than can be preformed on one string to convert it.
     * 1. Adding a character
     * 2. Removing a character
     * 3. Replacing a character
     * @param string1 -- string 1 needs converting
     * @param string2 -- string 2 is reference
     * @return -- edit distance (int)
     */
    public static int calculateEditDistance(String string1, String string2) {
        int len1 = string1.length();
        int len2 = string2.length();
        int distance = 0;
        int stepCount = 1;

        StringBuilder str1 = new StringBuilder(string1);
        StringBuilder str2 = new StringBuilder(string2);

        //3 conditions, if str1 is <, if str1 is =, if str1 > str2...


            //Replace all non-equal characters in string1 to string2 until string1 or string1's length is exceeded
            for (int i = 0; (i < len1) && (i < len2); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    str1.setCharAt(i, str2.charAt(i));
                    System.out.println("Step " + stepCount + ": " + str1);
                    distance++;
                    stepCount++;
                }
            }

        //EX. str1: B A N A N A arr[5], length 6
        //    str2: M I L K C H O C O L A T E arr[12], length 13
        //Add characters until caught up & equal to str2
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                str1.append(str2.charAt(i));
                System.out.println("Step " + stepCount + ": " + str1);
                distance++;
                stepCount++;
            }
        }

        //EX. str1: M I L K C H O C O L A T E arr[12], length 13
        //    str2: B A N A N A arr[5], length 6
        //Subtract characters until equivalent to str2
        else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                str1.deleteCharAt(str1.length() - 1);
                System.out.println("Step " + stepCount + ": " + str1);
                distance++;
                stepCount++;
            }
        }
        return distance;
    }
}
