package checkpoint1;

import javax.swing.*;
import java.awt.*;

public class Background implements Animatable
{
    private Control control;
    private GameState state;
    public Background(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
    }

    @Override
    public void update(double elapsedTime) {}

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(control.loadImage("background.png"), 0, 0, null);
    }
}
