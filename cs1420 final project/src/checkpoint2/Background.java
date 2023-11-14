package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject implements Animatable
{
    // field
    private Control control;
    private GameState state;

    // constructor
    public Background(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    @Override
    public void update(double timeElapsed) {}

    @Override
    public void draw(Graphics g)
    {
        BufferedImage background = control.getImage("background.png");
        g.drawImage(background, 0, 0, null);
    }
}
