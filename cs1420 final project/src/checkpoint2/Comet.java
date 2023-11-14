package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Comet extends GameObject implements Animatable
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
        pathPercentage += 0.0015;
        if (pathPercentage >= 1.00)
        {
            hasExpired = true;
            state.addGameObject(new Comet(control, state));
        }
    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage comet = control.getImage("comet.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(comet, loc.x - comet.getWidth()/2, loc.y - comet.getHeight()/2, null);
    }
}
