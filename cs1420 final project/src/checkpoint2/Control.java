package checkpoint2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Control implements Runnable, ActionListener, MouseListener, MouseMotionListener
{
    // field
    private View view;
    private GameState state;
    private Timer timer;
    private Path path;
    private TreeMap<String, BufferedImage> map;
    private boolean mousePressed;

    public void run ()
    {
        map = new TreeMap<>();
        path = loadPath("space_path_1.txt");
        state = new GameState();
        view = new View(this, state);
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
        mousePressed = false;

        state.startFrame();
        state.addGameObject(new Background(this, state));
        state.addGameObject(new Asteroid(this, state));
        state.addGameObject(new Comet(this, state));
        state.addGameObject(new MenuArea(this, state));
        state.addGameObject(new MenuButton(this, state));
        state.finishFrame();

        timer = new Timer(16,this);
        timer.start();
    }

    // Loads an image

    // Load the background image.

    private BufferedImage loadImage (String filename)
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

    // get an image

    public BufferedImage getImage(String filename)
    {
        if (!map.containsKey(filename))
            map.put(filename, loadImage(filename));
        return map.get(filename);
    }

    // Load a path

    private Path loadPath (String filename)
    {
        try
        {
            Scanner in = new Scanner(new File(filename));
            Path p = new Path(in);
            in.close();
            return p;
        }
        catch (IOException e)
        {
            System.out.println("Could not load the path.");

            return null;
        }
    }

    // Get the path

    public Path getPath ()
    {
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Main update loop

        state.startFrame();

        for (GameObject a : state.getCurrentObjects())
            a.update(0);
        if (mousePressed)
            for (GameObject a : state.getCurrentObjects())
            {
                if (a.consumeMouseClick())
                    break;
            }

        mousePressed = false;
        state.finishFrame();

        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        state.setMouseLocation(e.getX(), e.getY());
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        state.setMouseLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        state.setMouseLocation(e.getX(), e.getY());
    }
}
