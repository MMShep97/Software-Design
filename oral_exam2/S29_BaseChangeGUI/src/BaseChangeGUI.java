import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * @author Marc Shepherd
 * @version 1.0, 10/25/2018
 * @since SDK 1.8
 *
 * The main workhorse of this program, handles all of the interface and adds TextHandler, a private class below,
 * to the jtextfields to be used for input and the base calculation
 */
public class BaseChangeGUI extends JFrame{

    /**
     * num, currentBase, desiredBase -- variables set from entering/clicking button, used with basechange method
     * JTextField's, JButton's -- Necessary for creation of GUI and input through the GUI
     */
    private JTextField field1, field2, field3, field4;
    private JButton button1, button2, button3;
    private int num;
    private int currentBase, desiredBase;

    /**
     * TextHandler -- creates a new object and is added to all of the buttons and JTextFields for input
     */
    BaseChangeGUI() {
        num = -1;
        currentBase = -1;
        desiredBase = -1;

        TextHandler handler = new TextHandler();
        field1 = new JTextField("");
        field2 = new JTextField("");
        field3 = new JTextField("");
        field4 = new JTextField("");
        field1.addActionListener(handler);
        field2.addActionListener(handler);
        field3.addActionListener(handler);

        button1 = new JButton("Enter");
        button2 = new JButton("Enter");
        button3 = new JButton("Enter");
        button1.addActionListener(handler);
        button2.addActionListener(handler);
        button3.addActionListener(handler);
    }

    public void display() {

        //Frame/panel creation
        JFrame frame = new JFrame();
        JPanel jpanel = new JPanel(new GridLayout(0, 1));

        //Panel additions
        jpanel.add(new JLabel("Number"));
        jpanel.add(field1);
        jpanel.add(button1);
        jpanel.add(new JLabel("Current Base"));
        jpanel.add(field2);
        jpanel.add(button2);
        jpanel.add(new JLabel("Desired Base"));
        jpanel.add(field3);
        jpanel.add(button3);
        jpanel.add(new JLabel("Output"));
        jpanel.add(field4);

        //Field4 customization
        Color color = Color.GRAY;
        field4.setEditable(false);
        field4.setBackground(color);
        field4.setFont(field4.getFont().deriveFont(Font.BOLD, 14f));


        //Frame customization/jpanel add
        frame.add(jpanel);
        frame.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * @author Marc Shepherd
     * @version 1.0, 10/25/2018
     * @since SDK 1.8
     *
     * TextHandler handles all actions performed, whether that be hitting enter, or pressing the given button,
     * and sets the respective variables, allowing for calculation of base conversion. If all conditions are met,
     * the converted number will output to field4
     */
    private class TextHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            try {
                //If entering/pushing button for number to be converted, set num
                if (actionEvent.getSource() == field1 || actionEvent.getSource() == button1) {
                    num = Integer.parseInt(field1.getText()); //Convert to int for error checking
                    System.out.println(Integer.toString(num)); //Convert back to string for conversion calculation
                }

                //If entering/pushing button for current base, set current base
                if (actionEvent.getSource() == field2 || actionEvent.getSource() == button2) {
                    currentBase = Integer.parseInt(field2.getText());
                    System.out.println(currentBase);
                }

                //If entering/pushing button for desired base, set desired base
                if (actionEvent.getSource() == field3 || actionEvent.getSource() == button3) {
                    desiredBase = Integer.parseInt(field3.getText());
                    System.out.println(desiredBase);
                }
            }
            catch (NumberFormatException ex) {
                //Catch non-numbers for field1 & field2 & field3
            }

            //If user clicks or hits enter on any field/button && all fields are non-empty, convert
            if ((actionEvent.getSource() == field1 ||
                    actionEvent.getSource() == field2 ||
                    actionEvent.getSource() == field3 ||
                    actionEvent.getSource() == button1 ||
                    actionEvent.getSource() == button2 ||
                    actionEvent.getSource() == button3)     && (!field1.getText().equals("") &&
                                                                !field2.getText().equals("") &&
                                                                !field3.getText().equals(""))
                                                            &&

                    (num != -1 && currentBase != -1 && desiredBase != -1)
                )
                //Convert back to string for conversion method
                field4.setText(BaseChange.changeBase(Integer.toString(num), currentBase, desiredBase));
        }
    }
}