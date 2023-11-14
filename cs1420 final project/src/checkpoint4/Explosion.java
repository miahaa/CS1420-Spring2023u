package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends GameObject
{
    private Control control;
    private GameState state;
    private double time;
    private Point pos;

    public Explosion(Control control, GameState state, Point p)
    {
        this.control = control;
        this.state = state;
        this.time = 0.5;
        this.pos = p;
    }

    @Override
    public void update(double timeElapsed)
    {
        time -= timeElapsed;
        if (time <= 0)
        {
            hasExpired = true;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage comet = control.getImage("explosion.png");
        //Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(comet, pos.x - comet.getWidth()/2, pos.y - comet.getHeight()/2, null);
    }


}
