import java.util.*;
import java.io.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/7/2018
 * @since SDK 1.8
 *
 * Board acts as, you guessed it, the 'board' of the game. The Board class handles the players involved, and is the main
 * component for playing and making sure valid board moves are made. The moves are made with two player instances and
 * the game is checked for completion, whether it be draw or victory, after each move
 */

public class Board {

    /**
     * player1, player2 -- Instances of player are initialized and downcasted in the constructor to their specified sub-class
     * boardArray -- acts as the board, moves alter the board and is updated each turn and printed at the end of each turn
     */
    private Player player1, player2;
    private String[][] boardArray = {
            {"_", "_", "_"},
            {"_", "_", "_"},
            {"_", "_", "_"},
    };

    /**
     * Board constructor takes in two arguments that are used to downcast the initialized Player object into the specified subclass
     * @param playerType1 -- the type of player, player1 cast either to HumanPlayer or ComputerPlayer
     * @param playerType2 -- the type of player, player2 cast either to HumanPlayer or ComputerPlayer
     */
    Board(Player playerType1, Player playerType2) {
        this.player1 = playerType1;
        this.player2 = playerType2;
    }

    /**
     * The overarching method is responsible for running the entire game, where players makeMove() and logical checking is done.
     * Checks for draws or a player winning is also made.
     * @throws IOException //Logical exception handling, needed as methods used within this method throw may them
     * @throws InterruptedException //Exception handling, needed as methods (computer player) used within this method may throw them
     */
    public void playTTToe() throws IOException, InterruptedException {

        //false returned within on victory/draw
        while (true) {

            //Check for end-game
            if (isEndGame(boardArray)) {
                printTicTacToeBoard(boardArray);
                break;
            }

            //if not end-game, print --> check sub-class type --> player 1 make move
            printTicTacToeBoard(boardArray);
            System.out.println(isHuman(player1) ? "Human Player (1st): " : "Computer Player (1st): ");
            player1.makeMove(boardArray, "X");

            /*********GAP between P1 & P2*********/

            //Check for end-game
            if (isEndGame(boardArray)) {
                printTicTacToeBoard(boardArray);
                break;
            }

            //If not end-game, print --> check sub-class type --> player 2 make move
            printTicTacToeBoard(boardArray);
            System.out.println(isHuman(player2) ? "Human Player (2nd) " : "Computer Player (2nd): ");
            player2.makeMove(boardArray, "O");
        }
    }

    /**
     * Checks for end-game --> checks each indice in the board & returns true only if victory/draw detected
     * -- used within playTTToe() method
     * @param board -- board array brought in to check
     * @return -- false if not end-game, true if end-game
     */
    private boolean isEndGame(String[][] board) {
        if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if ((board[0][0]).equals("O") && (board[0][1]).equals("O") && (board[0][2]).equals("O")){
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        /**************Vertical*****************/

        if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if ((board[0][0]).equals("O") && (board[1][0]).equals("O") && (board[2][0]).equals("O")){
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) {
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        /**********Diagonal***********/

        if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
            System.out.println("Good game! Player 1 wins!");
            return true;
        }

        if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
            System.out.println("Good game! Player 2 wins!");
            return true;
        }

        /***Check for a tie-game***/
        if (isDraw()) {
            System.out.println("Oh? Good game! The game is a draw!");
            return true;
        }
        return false;
    }

    /**
     * Private helper function for isEndGame() function to reduce clutter
     * @return  false if still going / not won, true otherwise
     */
    private boolean isDraw() {
        //If navigating through array results in finding "_", there is still space for another move
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                if (boardArray[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Helper function for part of game to check if human or computer
     * @param player    takes in player instance to check sub
     * @return          true if human, false if computer (or anything else)
     */
    private boolean isHuman(Player player) {
        if (player instanceof HumanPlayer) return true;
        return false;
    }

    /**
     * Prints ticTacToe board out the console
     * @param array -- board
     */
    private void printTicTacToeBoard(String[][] array) {
        System.out.println("-----------------------");
        for (int i = 0; i < array.length; ++i) {
            System.out.print("|");
            for (int j = 0; j < array[i].length; ++j) {
                System.out.print("   " + array[i][j] + "   ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-----------------------");
    }
}
