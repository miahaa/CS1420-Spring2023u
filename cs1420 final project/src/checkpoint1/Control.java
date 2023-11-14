package checkpoint1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.Timer;

public class Control extends JFrame implements Runnable, ActionListener
{
    private GameState state;
    private View view;
    private Path path;
    public Control()
    {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run()
    {
        try
        {
            Scanner pathScanner = new Scanner(new File("space_path_1.txt"));
            path = new Path(pathScanner);
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        state = new GameState();
        view  = new View(this, state);  // Notice that we will send the view a few object references.
        state.startFrame();  // Prepares the creation of the 'next' frame
        state.addGameObject(new Background(this, state));  // Add one background object to our list
        state.addGameObject(new Asteroid(this, state));  // Add one asteroid object to our list
        state.addGameObject(new Comet(this, state)); // Add one comet object to our list
        state.finishFrame();    // Mark the next frame as ready

        repaint();           // Draw it.
        Timer t = new Timer(16, this);  // Triggers every 16 milliseconds, reports actions to 'this' object.
        t.start();
    }

    public Path getPath()
    {
        return path;
    }

    public BufferedImage loadImage (String filename)
    {
        try
        {
            return javax.imageio.ImageIO.read(new File(filename));
        }
        catch (IOException e)
        {
            System.out.println("Could not read " + filename);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        state.startFrame();
        for (Animatable a : state.getCurrentObjects())
            a.update(0);
        state.finishFrame();
        view.repaint();
    }
}
