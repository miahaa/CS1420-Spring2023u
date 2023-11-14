package assignment04;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

/**
 * This class implements this cool idea: Draw a house in snow weather
 *
 * @author  Thu Ha (inspired by Peter Jensen's code examples)
 * @version 4 Feb, 2023
 */


public class DrawHouse extends Container implements Runnable
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new DrawHouse());
    }

    // The 'run' method is executed whenever an object
    // is 'run' by a thread
    public void run ()
    {
        // Build a JFrame (a top-level window) and
        // ask that it exit/terminate the application when closed.
        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        // Display the frame.
        frame.pack(); // Recalculates size
        frame.setVisible(true);
    }
    public void paint (Graphics g)
    {
        // Make a seeded random number generator.
        Random r = new Random(400);
        // Fill the background to pink.
        Color c = new Color(129, 170, 236);
        g.setColor(c);
        g.fillRect(0, 0, 800, 800);
        // Draw wall
        drawWall(g,100 , 200);
        // Draw door
        drawDoor(g, 170, 480);
        // Draw windows
        drawWindows(g, 120, 300);
        // Draw roof
        drawRoof(g, 80, 200);
        // Draw sun
        drawSun(g, 600, 50);
        // Draw snow
        for (int i = 0; i < 1_000; i++)
            drawSnow(g, r);
        // Draw grass
        drawGrass(g, 400, 550);

    }
    /**
     * Draws a wall at a specific location on the panel.
     *
     * @param g any valid Graphics object
     * @param x the x coordinate of the upper-left corner of the wall
     * @param y the y coordinate of the upper-left corner of the wall
     */
    public void drawWall (Graphics g, int x, int y)
    {
        Color d = new Color(103, 10, 50);
        g.setColor(d);
        g.fillRect(x, y, 200, 380);
    }
    /**
     * Draws a door at a specific location on the panel that inside the color of the wall
     *
     * @param g any valid Graphics object
     * @param x the x coordinate of the upper-left corner of the door
     * @param y the y coordinate of the upper-left corner of the door
     */
    public void drawDoor (Graphics g, int x, int y)
    {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 50, 100);
    }
    /**
     * Draws two windows at a specific location on the panel using for loop
     *
     * @param g any valid Graphics object
     * @param x the x coordinate of the upper-left corner of the first window
     * @param y the y coordinate of the upper-left corner of the first window
     */
    public void drawWindows (Graphics g, int x, int y)
    {
        int count = 0;
        while (count < 1)
        {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 50, 50);
            g.fillRect(x+110, y, 50, 50);
            count ++;
        }

    }
    /**
     * Draws a triangle on top to create a roof
     *
     * @param g any valid Graphics object
     * @param x the x coordinate of the upper-left corner of the triangle
     * @param y the y coordinate of the upper-left corner of the triangle
     */
    public void drawRoof (Graphics g, int x, int y)
    {
        g.setColor(Color.BLUE);
        g.fillPolygon(makeTriangle(80, 200));
    }
    // Build the triangle from 3 points
    public Polygon makeTriangle(int x, int y)
    {
        Polygon p = new Polygon();
        p.addPoint(x, y);
        p.addPoint(200, 100);
        p.addPoint(320, y);
        return p;
    }
    /**
     * Draws a sun at a specific location on the panel.
     *
     * @param g any valid Graphics object
     * @param x the x coordinate of the upper-left corner of the sun
     * @param y the y coordinate of the upper-left corner of the sun
     */
    public void drawSun (Graphics g, int x, int y)
    {
        g.setColor(Color.orange);
        g.fillRoundRect(x, y, 120, 120, 120, 120);
    }
    /**
     * Draws snow randomly in an 800x800 range.
     *
     * @param g any valid Graphics object
     */
    public void drawSnow (Graphics g, Random rand)
    {
        int x = rand.nextInt(800);
        int y = rand.nextInt(800);
        int size = rand.nextInt(3)+1;
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }
    /**
     * Draws grass at a specific location on the panel from multiple lines.
     *
     * @param g any valid Graphics object
     * @param x the x coordinate of the upper-left corner of the grass
     * @param y the y coordinate of the upper-left corner of the grass
     */
    public void drawGrass (Graphics g, int x, int y)
    {
        int x2 = 420;
        int y2 = 580;
        for(int grassCount = 0; grassCount < 13; grassCount++)
        {
            for (int i = 0; i < 3; i++)
            {
                g.setColor(Color.GREEN);
                g.drawLine(x += 10, y, x2 , y2);
            }
            x2 += 30;
        }
    }

// Set the size to 800*800 pixels
    public Dimension getMinimumSize ()
    {
        return new Dimension (800, 800);
    }
    public Dimension getMaximumSize ()
    {
        return new Dimension (800, 800);
    }
    public Dimension getPreferredSize ()
    {
        return new Dimension (800, 800);
    }


}
