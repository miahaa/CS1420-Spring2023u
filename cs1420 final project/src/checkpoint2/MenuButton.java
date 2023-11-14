package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButton extends GameObject implements Animatable
{
    private Control control;
    private GameState state;

    public MenuButton(Control control, GameState state)
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
        g.setColor(Color.BLUE);
        g.drawRect(625,160, 65, 50);
        g.fillRect(625,160, 65, 50);
        BufferedImage probe = control.getImage("probe.png");
        g.drawImage(probe, 630, 160, null);
    }

    @Override
    public boolean consumeMouseClick()
    {
        if (state.getMouseLocation().getX() >= 625.0 && state.getMouseLocation().getX() <= 675.0
        && state.getMouseLocation().getY() >= 160.0 && state.getMouseLocation().getY() <= 210.0)
        {
            state.addGameObject(new Satellite(control, state, true));
            return true;
        }
        return false;
    }
}
