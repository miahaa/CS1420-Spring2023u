package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Comet extends GameObject implements Targetable
{
    private Control control;
    private GameState state;
    private double pathPercentage;

    public Comet(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }

    @Override
    public void update(double timeElapsed)
    {
        pathPercentage += (1.00/6.0) * timeElapsed;
        if (pathPercentage >= 1.00)
        {
            // Remove
            hasExpired = true;
            state.adjustCityCount();
        }
    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage comet = control.getImage("comet.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(comet, loc.x - comet.getWidth()/2, loc.y - comet.getHeight()/2, null);
    }


    public Point getFutureLocation(double additionalTime)
    {
        return control.getPath().convertToCoordinates(pathPercentage+(1.00/6.0) * additionalTime);
    }
}
