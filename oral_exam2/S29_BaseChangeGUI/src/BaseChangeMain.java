import java.util.*;
import java.io.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 10/25/2018
 * @since SDK 1.8
 * General purpose of this is going to be having three inputs and one output using GUI.
 This is change of base problem ig.(hex to binary)

 input: number, current base, desired base
 output: converted number

 ### Easy
 Convert between hex and binary
 hex <-> binary
 Convert between decimal and octal
 decimal <-> octal

 ### Medium
 Convert between any two bases up to base 32
 Watch your input validation carefully on this problem.
 */

public class BaseChangeMain {
    public static void main(String [] args) throws IOException {

        //Calls BaseChangeGUI and creates an instance of that class to display GUI
        BaseChangeGUI gui = new BaseChangeGUI();
        gui.display();
    }
}
