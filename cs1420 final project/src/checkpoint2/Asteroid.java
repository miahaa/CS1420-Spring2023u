package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Asteroid extends GameObject implements Animatable
{
    // Uncommented -- add contracts/comments to understand what's going
    // on.  (Style requirements checked on each checkpoint.)

    private Control control;
    private GameState state;
    private double pathPercentage;

    public Asteroid (Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }

    @Override
    public void update(double timeElapsed)
    {
        pathPercentage += 0.001;
        if (pathPercentage >= 1.00)
        {
            state.addGameObject(new Asteroid(control, state));
            hasExpired = true;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage asteroid = control.getImage("asteroid.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(asteroid, loc.x - asteroid.getWidth()/2, loc.y - asteroid.getHeight()/2, null);
    }
}
