import java.io.*;
import java.util.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/7/2018
 * @since SDK 1.8
 *
 * For this assignment, you must make a game of 3x3 Tic-Tac-Toe.  Please see the following article for the rules of this game:  https://en.wikipedia.org/wiki/Tic-tac-toe (Links to an external site.)Links to an external site.

Your game must allow two players to play Tic-Tac-Toe against each other. Your program must support the following combinations of players:

One human player and one computer player
Two human players
Two computer players
Your computer player can be as smart or “dumb” as you desire. After each move, the current board state must be displayed and the program must check for a winner.  If there is a winner or all places in the board are full, the program must display a status and end.

Code Structure Requirements

The game must consist of the following classes:

Board: Holds the current board configuration and ensures only valid moves are made.
Player: Parent class for both the ComputerPlayer and HumanPlayer classes
ComputerPlayer: Class representing a computer player. Inherits from the Player class.
HumanPlayer: Class representing a human player. Inherits from the Player class.
You MUST use inheritance and polymorphism to structure your program. Your user interface MUST NOT contain any player-specific code except at the point where you instantiate your ComputerPlayer/HumanPlayer objects. ComputerPlayer and HumanPlayer CANNOT print to the screen except in HumanPlayer’s makeMove method which is allowed to prompt user for input and take in that input.
    -Taken from icon class page {https://uiowa.instructure.com/courses/82238/pages/s20-tictactoe?module_item_id=2173853}

 Class acts as the main class, supplying the object creation and interface to which the user will interact with
 */

public class TicTacToeMain {
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = null;
        Player player2 = null;
        boolean playAgain = true;
        String playAgainChoice;
        int menuChoice = -1;

        while (playAgain) {
            playAgainChoice = ""; //Resets choice so while loop occurs

            System.out.println("Welcome to -TIC TAC TOE-\n" +
                    "1: one human player, one computer player\n" +
                    "2: two human players\n" +
                    "3: two computer players");

            while (true) {
                //Exception handling for user input
                try {
                    menuChoice = Integer.parseInt(input.readLine());
                    if (menuChoice > 0 && menuChoice < 4) break;
                    else System.err.println("Try a valid number!");
                } catch (NumberFormatException ex) {
                    System.err.println("Incorrect, try again with a numeric value.");
                }
            }

            //Initializing players
            switch (menuChoice) {
                //1 human, 1 computer
                case 1:
                    player1 = new HumanPlayer();
                    player2 = new ComputerPlayer();
                    break;

                //2 human
                case 2:
                    player1 = new HumanPlayer();
                    player2 = new HumanPlayer();
                    break;

                //2 computer
                case 3:
                    player1 = new ComputerPlayer();
                    player2 = new ComputerPlayer();
                    break;
            }

            //Board creation & play method
            Board newBoard = new Board(player1, player2);
            newBoard.playTTToe();

            //Play again if yes, end program if no
            while (!playAgainChoice.equals("Y") && !playAgainChoice.equals("y") && !playAgainChoice.equals("N") && !playAgainChoice.equals("n")) {
                System.out.println("Play again? (Y/N)");
                playAgainChoice = input.readLine();
                if (playAgainChoice.equals("N") || playAgainChoice.equals("n")) playAgain = false;
            }
        }
        System.out.println("Thank you for playing!");
    }
}

