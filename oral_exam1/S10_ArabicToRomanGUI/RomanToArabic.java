import java.util.*;
import java.io.*;

/**
 * This class takes in a user specified roman numeral(s) and
 * This class takes in user specified roman numeral(s) and converts those roman numerals into the equivalent arabic number.
 * It has one function <code>convert</code> and uses the private field <code>romanVal</code> to convert.
 * @author Marc Shepherd
 * @version 1.0, 9/30/2018
 * @since SDK 1.8
 */
public class RomanToArabic {

    public String convert(String romanVal) {
        int arabicNum = 0;

        //Terminate loop if no more numerals to be converted
        while (!romanVal.isEmpty()) {

                //Checks string length as substring with length() - 2
                //will result in null pointer and terminate in some cases.
                //Also check 2-numeral long equality first to assure correctness
                if ((romanVal.length() >= 2) && (
                    romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("IV") ||
                    romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("IX") ||
                    romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("XL") ||
                    romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("XC") ||
                    romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("CD") ||
                    romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("CM")))
                {
                        //Add 4 to arabic, delete last 2 characters (IV) in string
                        if (romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("IV")) {
                            romanVal = romanVal.substring(0, romanVal.length() - 2);
                            arabicNum += 4;
                        }
                        //Add 9 to arabic, delete last 2 characters (IX) in string
                        if (romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("IX")) {
                            romanVal = romanVal.substring(0, romanVal.length() - 2);
                            arabicNum += 9;
                        }
                        //Add 40 to arabic, delete last 2 characters (XL) in string
                        if (romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("XL")) {
                            romanVal = romanVal.substring(0, romanVal.length() - 2);
                            arabicNum += 40;
                        }
                        //Add 90 to arabic, delete last 2 characters (XC) in string
                        if (romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("XC")) {
                            romanVal = romanVal.substring(0, romanVal.length() - 2);
                            arabicNum += 90;
                        }
                        //Add 400 to arabic, delete last 2 characters (CD) in string
                        if (romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("CD")) {
                            romanVal = romanVal.substring(0, romanVal.length() - 2);
                            arabicNum += 400;
                        }
                        //Add 900 to arabic, delete last 2 characters (CM) in string
                        if (romanVal.substring(romanVal.length() - 2, romanVal.length()).equals("CM")) {
                            romanVal = romanVal.substring(0, romanVal.length() - 2);
                            arabicNum += 900;
                        }
                }

            //Otherwise do one of these...

            //Add 1 to arabic, delete last character (I) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("I")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 1;
            }
            //Add 5 to arabic, delete last character (V) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("V")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 5;
            }
            //Add 10 to arabic, delete last character (X) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("X")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 10;
            }
            //Add 50 to arabic, delete last character (L) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("L")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 50;
            }
            //Add 100 to arabic, delete last character (C) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("C")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 100;
            }
            //Add 500 to arabic, delete last character (D) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("D")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 500;
            }
            //Add 1000 to arabic, delete last character (M) in string
            else if (romanVal.substring(romanVal.length() - 1).equals("M")) {
                romanVal = romanVal.substring(0, romanVal.length() - 1);
                arabicNum += 1000;
            }
        }
        return Integer.toString(arabicNum);
    }
}