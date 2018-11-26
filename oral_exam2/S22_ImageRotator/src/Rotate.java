

import javax.swing.*;
import java.io.IOException;

/**
 * This class is comprised of the main method that creates a containing frame to add the gui panel into. Standard frame
 * methods are invoked for configuration.
 */

public class Rotate extends JFrame {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        Interface guiPanel = new Interface();
        frame.add(guiPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
