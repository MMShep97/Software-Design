import java.util.*;
import java.io.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/25/2018
 * @since SDK 1.8
 *
 * BaseChange is a helper class that contains a single static method, used in the BaseChangeGUI class to convert
 * a given number with a current base into a new, desired base
 */

public class BaseChange {

    /**
     * Converts <code>fromBase</code> <code>toBase</code>
     * @param num -- given input to change base
     * @param fromBase -- num's starting base
     * @param toBase -- desired base to change to
     * @return -- converted num in string format to put into gui
     */
    public static String changeBase(String num, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(num, fromBase), toBase);
    }
}
