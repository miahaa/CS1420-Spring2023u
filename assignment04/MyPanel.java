/**
 * This class use JPanel and JFrame to draw a picture of a house with stars above, and grass around it.
 *
 * @author Khoa Minh Ngo
 * @version Feb 3, 2023
 */

package assignment04;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.util.Random;

public class MyPanel extends JPanel implements Runnable
{
    /**
     * Application entry point
     *
     * @param args unused
     */
    public static void main(String[] args)
    {
        MyPanel mp = new MyPanel();
        SwingUtilities.invokeLater(mp);
    }

    /**
     * Replaces 'main' as our application main method.
     * Builds and displays a JFrame.
     */
    public void run()
    {
        // Make a frame object.
        JFrame frame = new JFrame("This is my frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(this);

        // Pack and display the frame.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method will be automatically called to draw my picture.
     *
     * @param g a Graphics object provided by the GUI for drawing
     */
    public void paint (Graphics g)
    {
        // Set background color to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Draw a house
        Color c = new Color (100, 200, 255);
        g.setColor(c);
        g.drawPolygon(makeIsoscelesTriangle(300, 430));
        g.fillPolygon(makeIsoscelesTriangle(300, 430));
        Color d = new Color (100, 170, 200);
        g.setColor(d);
        g.drawRect(300, 430, 200, 200);
        g.fillRect(300, 430, 200, 200);

        // Draw a door
        g.setColor(Color.WHITE);
        g.drawRect(375, 560, 50, 70);
        g.fillRect(375, 560, 50, 70);

        // Draw two windows
        drawWindows(g, 330, 460);
        drawWindows(g, 430, 460);

        // Draw random stars
        Random r = new Random();
        for (int i = 0; i < 3_000; i++)
            drawRandomStar(g, r);

        // Draw random grass
        for (int i = 0; i < 270; i++)
            drawGrass(g);
    }

    /**
     * This method will draw a window in a specific location.
     * @param g a Graphics object provided by the GUI for drawing
     * @param x x coordinate of the upper-left corner of the window
     * @param y y coordinate of the upper-left corner of the window
     */
    public void drawWindows(Graphics g, int x, int y)
    {
        g.setColor(Color.gray);
        g.drawRect(x, y, 40, 40);
        g.drawLine(x + 20, y, x + 20, y + 40);
        g.drawLine(x, y + 20, x + 40, y + 20);
    }

    /**
     * This method make an isosceles triangle at a specific location
     * @param x x coordinate of the lower-left corner of the triangle
     * @param y y coordinate of the lower-left corner of the triangle
     * @return an isosceles triangle
     */
    public Polygon makeIsoscelesTriangle(int x, int y)
    {
        Polygon triangle = new Polygon();
        triangle.addPoint(x, y);
        triangle.addPoint(x + 100, (int) (y - 75 * Math.sqrt(3.0)));
        triangle.addPoint(x + 200, y);
        return triangle;
    }

    /**
     * Draws a star randomly in a 800x800 range.
     *
     * @param g any valid Graphics object
     */
    public void drawRandomStar (Graphics g, Random rand)
    {
        int x = rand.nextInt(800);
        int y = rand.nextInt(250);
        int size = rand.nextInt(3)+1;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }

    /**
     * Draws grass randomly at the bottom of the frame.
     *
     * @param g any valid Graphics object
     */
    public void drawGrass(Graphics g)
    {
        int x = (int) (Math.random() * 800);
        int y = (int) (Math.random() * 10) + 630;
        g.setColor(Color.GREEN);
        g.drawLine(x, y, x - 5, y - 5);
        g.drawLine(x, y, x, y - 5);
        g.drawLine(x, y, x + 5, y - 5);
    }

    /**
     * Overrides the same-named function in the JPanel
     * so that we can specify our own size (when the
     * GUI system asks for this panel's size).
     */
    public Dimension getMinimumSize ()
    {
        return new Dimension (800, 800);
    }

    /**
     * Overrides the same-named function in the JPanel
     * so that we can specify our own size (when the
     * GUI system asks for this panel's size).
     */
    public Dimension getMaximumSize ()
    {
        return new Dimension (800, 800);
    }

    /**
     * Overrides the same-named function in the JPanel
     * so that we can specify our own size (when the
     * GUI system asks for this panel's size).
     */
    public Dimension getPreferredSize ()
    {
        return new Dimension (800, 800);
    }
}
