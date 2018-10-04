/**
 * This class takes in a user specified arabic number and converts that arabic number into the equivalent roman numerals.
 * It has one function <code>convert</code> and uses the private field <code>arabicNum</code> to convert.
 * @author Marc Shepherd
 * @version 1.0, 9/30/2018
 * @since SDK 1.8
 */
public class ArabicToRoman {
    /**
     * Converts from arabic number into equivalent roman numerals using numerous conditional statements.
     * @return equivalent roman value
     */
    public String convert(int arabicNum) {
        String romanVal = "";

        //Continues until arabic number has no more roman numerals to add
        while (arabicNum > 0) {
            //Add M to roman string, subtract 1000 from arabic
            if (arabicNum >= 1000) {
                romanVal += "M";
                arabicNum -= 1000;
            }
            //Add CM to roman string, subtract 900 from arabic
            if (arabicNum >= 900 && arabicNum < 1000) {
                romanVal += "CM";
                arabicNum -= 900;
            }
            //Add D to roman string, subtract 500 from arabic
            if (arabicNum >= 500 && arabicNum < 1000) {
                romanVal += "D";
                arabicNum -= 500;
            }
            //Add CD to roman string, subtract 400 from arabic
            if (arabicNum >= 400 && arabicNum < 500) {
                romanVal += "CD";
                arabicNum -= 400;
            }
            //Add C to roman string, subtract 100 from arabic
            if (arabicNum >= 100 && arabicNum < 500) {
                romanVal += "C";
                arabicNum -= 100;
            }
            //Add XC to roman string, subtract 90 from arabic
            if (arabicNum >= 90 && arabicNum < 100) {
                romanVal += "XC";
                arabicNum -= 90;
            }
            //Add L to roman string, subtract 50 from arabic
            if (arabicNum >=50 && arabicNum < 100) {
                romanVal += "L";
                arabicNum -= 50;
            }
            //Add XL to roman string, subtract 40 from arabic
            if (arabicNum >= 40 && arabicNum < 50) {
                romanVal += "XL";
                arabicNum -= 40;
            }
            //Add X to roman string, subtract 10 from arabic
            if (arabicNum >=10 && arabicNum < 50) {
                romanVal += "X";
                arabicNum -= 10;
            }
            //Add IX to roman string, subtract 9 from arabic
            if (arabicNum == 9) {
                romanVal += "IX";
                arabicNum -= 9;
            }
            //Add V to roman string, subtract 5 from arabic
            if (arabicNum >=5 && arabicNum < 10) {
                romanVal += "V";
                arabicNum -= 5;
            }
            //Add IV to roman string, subtract 4 from arabic
            if (arabicNum == 4) {
                romanVal += "IV";
                arabicNum -= 4;
            }
            //Add I to roman string, sutract 1 from arabic
            if (arabicNum >= 1 && arabicNum < 5) {
                romanVal += "I";
                arabicNum -= 1;
            }
        }
        return romanVal;
    }
}


