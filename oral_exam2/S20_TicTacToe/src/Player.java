import java.util.*;
import java.io.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/7/2018
 * @since SDK 1.8
 * Inheritance -- player is the parent class of the human player and computer player. It is an abstract class and therefore
 * allows for the sub-classes to create their own method of makeMove (as you can see it is empty). getBufferedReader method is
 * simply used for ease of access for future sub-classes if they need easy input request from the user
 */
public abstract class Player {

    /**
     * input -- of BufferedReader class, acts as input for user to interact with in player class
     */
    private static BufferedReader input;

    Player() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract void makeMove(String[][] array, String playerSymbol) throws IOException, InterruptedException;

    //easy access for input request
    public static BufferedReader getBufferedReader() {
        return input;
    }
}


