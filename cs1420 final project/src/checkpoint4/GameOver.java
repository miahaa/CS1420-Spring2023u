package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameOver extends GameObject
{
    private BufferedImage image;
    private Control control;
    private GameState state;

    public GameOver(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        this.image = control.getImage("gameover2.png");
    }

    @Override
    public void update(double timeElapsed) {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 200, 200, null);

    }
}
