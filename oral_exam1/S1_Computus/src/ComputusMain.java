//import org.junit.Test;
//import org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <div>
 * This assignment is part of the homework grid listed in Introduction to Software Design, taught by Professor Casavant.
 * Computus is the calculation of the date of Easter in the Christian calender.
 *
 * <h4>Easy</h4>
 * <p>
 *  This program is tasked with calculating the month and day of Easter given a specified
 * year in the Gregorian calender. The calculation is implemented with the Meeus/Jones/Butcher
 * Gregorian algorithm. User input is taken and the date of easter on that given input year is displayed.
 * </p>
 * <p>
 * In addition to the easy task, the medium problem has the program calculate the dates of Easter over an entire
 * cycle and display the number of times Easter occurs on each of the Calender days. The same user input is used
 * and utilizes the functions in <code>Date</code> to calculate the count over an entire cycle.
 * </p>
 * </div>
 * @author Marc Shepherd
 * @version 1.0, 9/29/2018
 * @since SDK 1.8
 */

public class ComputusMain
{
    public static void main(String [] args) throws IOException, NumberFormatException {
        //Variables
        int givenYear;
        Date easter;

        //User input
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("This program will calculate the date of Easter based on the " +
                "Gregorian calender. \nPlease enter your desired year: ");
        try {
            givenYear = Integer.parseInt(input.readLine());
            //Checks for positive input value and has user retry if not
            while (givenYear < 0) {
                System.out.print("Please enter a positive date: ");
                givenYear = Integer.parseInt(input.readLine());
            }
            //Part A (single date calculation)
            easter = new Date(givenYear);
            easter.calculateGregorianDate();
            easter.printGregorianDate();

            //Part B (counts of dates over entire cycle)
            System.out.print("The count of every Easter on each year in a given cycle will be listed below" +
                    " with their respective {month,day} listed: \n" +
                    "Processing...");
            easter.calculateCycleCount();
            easter.printCycleCount();
        }

        //Catches a non-integer input
        catch (NumberFormatException ex) {
            System.err.println("Invalid input...");
        }
    }
}
