package checkpoint3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PhotonTorpedo extends GameObject
{
    private Control control;
    private GameState state;
    private Point source;
    private Point target;
    private Path path;
    private double percentage;
    private double existingTime;
    public PhotonTorpedo(Control control, GameState state, Point source, Point target)
    {
        this.control = control;
        this.state = state;
        this.source = source;
        this.target = target;
        path = new Path();
        path.add(source.x, source.y);
        path.add(target.x, target.y);
        percentage = 0.0;
        existingTime = 0.3;
    }

    @Override
    public void update(double timeElapsed)
    {
        percentage += 0.05;
        existingTime -= timeElapsed;
        if (existingTime > 0)
        {
            Point loc = path.convertToCoordinates(percentage);
            Targetable t = state.findNearest(loc);
            if (t != null && t.getLocation().distance(loc) < 50)
            {
                GameObject j = (GameObject) t;
                j.hasExpired = true;
                hasExpired = true;
            }
        }

        else
        {
            hasExpired = true;
        }

    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage photon = control.getImage("heart.png");
        Point loc = path.convertToCoordinates(percentage);
        g.drawImage(photon, loc.x, loc.y, null);
    }
}
