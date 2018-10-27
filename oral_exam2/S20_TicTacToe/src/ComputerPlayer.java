import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/7/2018
 * @since SDK 1.8
 *
 * ComputerPlayer acts as one branch of the possible player types in the TIC TAC TOE game, and is a sub-class of Player, inheriting
 * its methods/construction. ComputerPlayer overrides Player's makeMove() method and implements it to its own desire.
 */

public class ComputerPlayer extends Player {

    /** --DUMB COMPUTER--
     * Alters board symbols based on computer's selection --> chooses next available position from smallest indice up
     * @param array -- signifies the current board status
     * @param playerSymbol -- if 'X', or 'O' based on which player's move it is currently
     * @throws InterruptedException -- used to simulate computer player 'thinking' and ease of gameplay pace
     */
    @Override
    public void makeMove(String[][] array, String playerSymbol) throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(1500); //For simulated computer move time

        OUTER_LOOP:
        for (int i = 0; i < array.length; ++i) {
            for(int j = 0; j < array[i].length; ++j) {
                if (array[i][j].equals("_")) {
                    array[i][j] = playerSymbol;
                    break OUTER_LOOP; //Breaks outer loop and ends if this runs once
                }
            }
        }
    }
}
