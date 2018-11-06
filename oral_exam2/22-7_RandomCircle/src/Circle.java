import javax.swing.*;
import java.awt.*;

/**
 * @author Marc Shepherd
 * @version 1.0, 11/5/2018
 * @since SDK 1.8
 * Allows for displaying of circle and calculations involving the specified radius
 */
class Circle extends JPanel {
    private final int radius; //Radius of circle

    Circle()
    {
        //creates random radius for circle creation
        radius = (int) ( 1 + Math.random() * 50 );
    }

    /**
     * with repaint, allows for creation of circle
     * @param g -- graphics object
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent(g);
        //Width & Height are equal to the diameter
        g.fillOval( 0, 0, 2 * radius, 2 * radius );
    }

    /**
     * get the radius of the circle
     * @return -- radius
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * get the diameter of the circle
     * @return -- diameter
     */
    public double getDiameter()
    {
        return  2 * radius;
    }

    /**
     * get the circumference of the circle
     * @return -- circumference
     */
    public double getCircumference()
    {
        double circumference = 2 * Math.PI * radius ;
        return Double.parseDouble(String.valueOf(circumference).substring(0,7));
    }

    /**
     * get the area of the circle
     * @return -- area
     */
    public double getArea()
    {
        double area = Math.PI * radius * radius ;
        return Double.parseDouble(String.valueOf(area).substring(0,7));
    }
}