import java.util.*;
import java.io.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/7/2018
 * @since SDK 1.8
 *
 * HumanPlayer acts as one branch of the possible player types in the TIC TAC TOE game, and is a sub-class of Player, inheriting
 * its methods/construction. HumanPlayer overrides Player's makeMove() method and implements it to its own desire.
 */

public class HumanPlayer extends Player{

    /**
     * prompts user for row selection on the board
     * @return  row -- subtracts one to use for indice
     * @throws IOException incase of illegal input
     */
    private static int chooseRow() throws IOException {
        System.out.println("Please select the row you would like");
        boolean flag = true;

        while (flag) {
            try {
                return Integer.parseInt(Player.getBufferedReader().readLine()) - 1; //Subtract one for indice (length - 1)
            }
            catch (NumberFormatException ex) {
                System.err.println("Error - illegal action performed - try again");
            }
        }
        return 0;
    }

    /**
     * prompts user for column selection on the board
     * @return  column -- subtracts one to use for indice
     * @throws IOException incase of illegal input attempt
     */
    private static int chooseColumn() throws IOException {
        System.out.println("Please select the column you would like");
        boolean flag = true;

        while (flag) {
            try {
                return Integer.parseInt(Player.getBufferedReader().readLine()) - 1; //Subtract one for the indice (length - 1)
            }
            catch (NumberFormatException ex) {
                System.err.println("Error - illegal action performed - try again");
            }
        }
        return 0;
    }


    /**
     * Alters board symbols based on human player's row and column selection
     * -- provides a small amount of error checking
     * @param array -- signifies the current board status
     * @param playerSymbol -- if 'X', or 'O' based on which player's move it is currently
     * @throws IOException -- incase of illegal input attempt
     */
    @Override
    public void makeMove(String[][] array, String playerSymbol) throws IOException {

        WHILE_LOOP:
        while (true) {

            int row = chooseRow();
            int column = chooseColumn();

            //If out of bounds, try again
            if ((row < 0 || row > 2) || (column < 0 || column > 2)) {
                System.err.println("The selection you made was out of bounds, please try another.");
                continue;
        }

            //If selection is empty, makeMove and exit
            if (array[row][column].equals("_")) {
                array[row][column] = playerSymbol;
                break WHILE_LOOP;
            }
            //Otherwise loop again
            else {
                System.err.println("The selection you made was already taken, please try another.");
            }
        }
    }
}
