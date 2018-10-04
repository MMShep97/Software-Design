import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The <code>Swing</code> class acts as the GUI and has a nested private class to handle the textBox inputs to convert
 * the [arabic, roman] to [roman, arabic].
 * @author Marc Shepherd
 * @version 1.0, 10/3/2018
 * @since SDK 1.8
 */
public class Swing {

    private String roman;
    private int arabic;
    private JTextField field1, field2, field3, field4;
    private ArabicToRoman arabicToRoman = new ArabicToRoman();
    private RomanToArabic romanToArabic = new RomanToArabic();

    /**
     * Constructs fields for each new object - Creates 4 new JTextFields, a handler to go with them, and adds the handlers
     * to the input TextFields when enter is hit to respond to the action and convert to [roman, arabic].
     */
    public Swing() {
        field1 = new JTextField("");
        field2 = new JTextField("");
        field3 = new JTextField("");
        field4 = new JTextField("");
        TextHandler handler = new TextHandler();
        field1.addActionListener(handler);
        field3.addActionListener(handler);
    }

    /**
     * Acts as the GUI creation
     */
    public void display() {
        //Arabic to roman interface
        JPanel panel1 = new JPanel(new GridLayout(0, 1));
        panel1.add(new JLabel("Arabic to Roman (Enter value - e.g. 1, 2, 3...)"));
        panel1.add(field1);
        panel1.add(new JLabel("Roman Output (e.g. I, IV, X...)"));
        panel1.add(field2);

        //Contains OK and CANCEL options
        int result1 = JOptionPane.showConfirmDialog(null, panel1, "Arabic to Roman",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result1 == JOptionPane.OK_OPTION) {
            System.out.println("Transitioning into [Roman to Arabic Conversion]");
        } else {
            System.out.println("Cancelled");
            System.exit(0);
        }

        //Roman to arabic interface
        JPanel panel2 = new JPanel(new GridLayout(0, 1));
        panel2.add(new JLabel("Roman to Arabic (e.g. I, IV, X...)"));
        panel2.add(field3);
        panel2.add(new JLabel("Arabic Output (Enter value - e.g. 1, 2, 3...)"));
        panel2.add(field4);

        //Contains OK and CANCEL options
        int result2 = JOptionPane.showConfirmDialog(null, panel2, "Roman to Arabic",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result2 == JOptionPane.OK_CANCEL_OPTION) {
            System.out.println("Cancelled");
            System.exit(0);
        }
    }

    /**
     * The class private nested <code>TextHandler</code> acts as the helper for handling the inputs and outputs
     * entered by the user. <code>ActionListener</code> is implemented and actionPerformed is created to handle
     * events when 1. the arabic to roman is input, and 2. the roman to arabic is input. The actionPerformed checks
     * everytime the box is entered and acts accordingly
     * @author Marc Shepherd
     * @version 1.0 10/3/2018
     * @since SDK 1.8
     */
    private class TextHandler implements ActionListener {
        /**
         * <code>actionPerformed</code> runs everytime an enter occurs and checks if the actionEvent pertains to field1 or field2
         * @param actionEvent  is the handler for input events
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == field1) {
                field2.setText(arabicToRoman.convert(Integer.parseInt(field1.getText()))); //Sets the text in output
            }
            if (actionEvent.getSource() == field3) {
                field4.setText(romanToArabic.convert(field3.getText())); //Sets the text in output
            }
        }
    }
}
