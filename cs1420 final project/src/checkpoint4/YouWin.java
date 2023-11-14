package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class YouWin extends GameObject
{
    private Control control;
    private GameState state;

    public YouWin(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
    }

    @Override
    public void update(double timeElapsed)
    {

    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage image = control.getImage("youwin1.png");
        g.drawImage(image, 0, 200, null);
    }
}
