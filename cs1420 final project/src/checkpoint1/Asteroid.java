package checkpoint1;

import java.awt.*;

public class Asteroid implements Animatable
{
    private Control control;
    private GameState state;
    private double percentage;  // The position along the path
    public Asteroid(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        percentage = 0;
    }

    @Override
    public void update(double elapsedTime)
    {
        percentage += 0.001;  // Slightly different values should be used here for different object types
    }

    @Override
    public void draw(Graphics g)
    {
        Point loc = control.getPath().convertToCoordinates(percentage);
        g.drawImage(control.loadImage("asteroid.png"), loc.x, loc.y, null);
    }
}
