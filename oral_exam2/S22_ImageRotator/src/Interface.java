import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * This class acts as the gui interface as well as rotating the image. Panels have encapsulating features in all of them.
 * An image is read in and event handlers are created to listen for buttons being pressed as well as
 */

public class Interface extends JPanel {
    private BufferedImage image = null;
    private JPanel dynamicPanel;
    private JPanel staticPanel;
    private JSlider dynamicSlider;
    private JSlider staticSlider;
    private JButton enterButton;
    private JRadioButton toggleButton;
    private int speed_of_rotation;
    private int rotate_degrees;
    private boolean clicked = false;
    private Timer timer;

    /**
     * The entire gui is featured in the constructor and all methods created in this class are invoked.
     */
    public Interface() {
        dynamicPanel = new JPanel();
        staticPanel = new JPanel();
        setLayout(new FlowLayout());
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(Color.WHITE);

        image = loadImage("C:\\Users\\Marc.MARC-PC\\IdeaProjects\\mmshepherd_swd\\oral_exam2\\S22_ImageRotator\\spiral.png");

        staticPanel.add(new JLabel("Rotate Image (0 - 360 degrees)"));

        staticSlider = setSliderConfiguration("360", "0", 360);
        staticSlider.setMinimum(0);
        staticSlider.setMaximum(360);
        staticPanel.add(staticSlider);

        enterButton = new JButton("Enter");
        enterButton.addActionListener(new Handler());
        staticPanel.add(enterButton);

        dynamicPanel.add( new JLabel("Change Speed (FPS)"));

        dynamicSlider = setSliderConfiguration("FAST", "SLOW", 30);
        dynamicSlider.setMaximum(30);
        dynamicSlider.setMinimum(0);
        dynamicPanel.add(dynamicSlider);

        toggleButton = new JRadioButton("Toggle (ON/OFF)");
        dynamicPanel.add(toggleButton);
        toggleButton.addActionListener(new Handler());

        timer = new Timer(0, event -> {
            speed_of_rotation = dynamicSlider.getValue();
            timer.setDelay(speed_of_rotation);
            rotate_degrees++;
            repaint();
        });

        add(staticPanel);
        add(dynamicPanel);
    }


    /**
     * Implicitly called when a change in the image is detected/when repaint is called. This implementation uses an affine transformation instance
     * to first scale the image (if they're large they get annoying) and then rotates the image based on the degrees the user wants to rotate it by. It is
     * then updated with the graphics 2d instance which draws the image taking in the image itself and the transformation instance.
     * @param g -- graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        AffineTransform transform = AffineTransform.getTranslateInstance(200, 200);
        transform.scale(.5, .5);
        transform.rotate(Math.toRadians(rotate_degrees), image.getWidth() / 2, image.getHeight() / 2);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, transform, null);
    }

        public JSlider setSliderConfiguration(String smallestText, String largestText, int LARGEST_VALUE) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, LARGEST_VALUE, LARGEST_VALUE / 2);
        slider.setSize(100, 100);
        //slider.addChangeListener(this);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        Hashtable labelTable = new Hashtable();
        labelTable.put( new Integer( 0 ), new JLabel(smallestText) );
        labelTable.put( new Integer(LARGEST_VALUE), new JLabel(largestText) );
        slider.setLabelTable( labelTable );
        slider.setPaintLabels(true);

        return slider;
    }


    /**
     * Loads image into BufferedImage private class variable
     * @param filename
     * @return
     */
    public BufferedImage loadImage(String filename) {
            BufferedImage image = null;

            try {
                image = ImageIO.read(new File(filename));
            } catch (IOException ex) {}
            return image;
        }

    /**
     * Handler implements actionlistener which holds one method <code>actionPerformed(ActionEvent e)</code> which acts as an event handler
     * that reacts every time the enter button is hit by updating the desired degrees of rotation by getting the slider's current value.
     * The event handler also checks if the toggle button has been hit. If it is checked, the timer starts and continues until the toggle button
     * is checked off.
     */
    private class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == enterButton) {
                rotate_degrees = staticSlider.getValue();
                repaint();
            }

            if(e.getSource() == toggleButton){
                if (clicked) clicked = false;
                else clicked = true;
                if(clicked) timer.start();
                else timer.stop();
            }
        }
    }


}
