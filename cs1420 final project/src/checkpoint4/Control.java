package checkpoint4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Control implements Runnable, ActionListener, MouseListener, MouseMotionListener
{
    private View view;
    private GameState state;
    private Timer timer;
    private Path path;
    private TreeMap<String,BufferedImage> imageCache;
    public boolean mousePressed;

    public void run ()
    {
        imageCache = new TreeMap<String,BufferedImage>();
        mousePressed = false;

        path = loadPath("space_path_1.txt");

        state = new GameState();
        view = new View(this, state);
        view.addMouseListener(this);
        view.addMouseMotionListener(this);

        state.startFrame();

        MenuArea menuArea = new MenuArea(this, state);

        state.addGameObject(new Background(this, state));
        state.addGameObject(menuArea);
        state.addGameObject(new GeneratorAsteroid(this, state));
        state.addGameObject(new GeneratorComet(this, state));
        Sound music = new Sound(this, state, 2);
        music.setFile(2);
        music.play();
        music.loop();

        menuArea.setUpMenuArea();

        state.finishFrame();

        timer = new Timer(16,this);
        timer.start();
    }


    // Loads an image
    // Load the background image.

    private BufferedImage loadImage (String filename)
    {
        System.out.println("Loading " + filename);
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

    public BufferedImage getImage (String filename)
    {
        if (! imageCache.containsKey(filename))
        {
            BufferedImage b = loadImage(filename);
            imageCache.put(filename, b);
        }

        return imageCache.get(filename);
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
        if (!state.getWin())
        {
            if (state.getCityCount() > 0)
            {
                for (Animatable a : state.getCurrentObjects())
                    a.update(state.getElapsedTime());
            }
            else
            {
                state.addGameObject(new GameOver(this, state));
            }
        }

        else
        {
            state.addGameObject(new YouWin(this, state));
        }


        if (mousePressed)
            for (int pos = state.getCurrentObjects().size() - 1;
                 pos >= 0; pos--)
            {
                Animatable a = state.getCurrentObjects().get(pos);

                if (a instanceof Clickable)
                {
                    Clickable c = (Clickable) a;
                    if (c.consumeClick())
                        break;
                }
            }

        mousePressed = false;

        state.finishFrame();

        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
    }
}
