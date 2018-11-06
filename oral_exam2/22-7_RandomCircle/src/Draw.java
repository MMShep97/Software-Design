import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 11/5/2018
 * @since SDK 1.8
 * This class acts as the gui, the part that displays it and configures everything. A textArea, circle object, and container is used.
 */

public class Draw extends JFrame {

    /**
     * Constructs the gui. In it, creates a circle object which allows for circle calculations, as well as the drawing of the circle component.
     * A JTextArea holds all of the circle calculations and the circle object & textArea components are added to a container.
     */
    public Draw()
    {
        Circle circle = new Circle();

        // text area for circle info
        JTextArea textArea = new JTextArea(0, 1);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setEditable(false);

        //draws circle
        circle.repaint();

        textArea.setText( "Area: " + circle.getArea() +
                        "\nRadius: " + circle.getRadius() +
                        "\nDiameter: " + circle.getDiameter() +
                        "\nCircumference is: " + circle.getCircumference() );

        //Basically the frame, holds all the components
        Container container = getContentPane();
        container.add(circle, BorderLayout.CENTER );
        container.add(textArea, BorderLayout.SOUTH);

        //Last configurations
        setSize( 220, 220 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}

