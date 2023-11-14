package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuArea extends GameObject implements Animatable
{
    private final Control control;
    private final GameState state;

    public MenuArea(Control control, GameState state)
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
        g.setColor(Color.WHITE);
        g.fillRect(600, 0, 200, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", Font.BOLD, 24));
        g.drawString("MENU", 665, 50);

        g.setFont(new Font("Serif", Font.PLAIN, 17));
        g.drawString("Money: " + state.getMoney(), 620, 90);
        g.drawString("Cities: " + state.getCities(), 620, 120);
    }
}
