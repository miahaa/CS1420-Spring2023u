package checkpoint2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Satellite extends GameObject implements Animatable
{
    private Control control;
    private GameState state;
    private int x, y;
    private boolean isMoving;

    public Satellite(Control control, GameState state, boolean isMoving)
    {
        super();
        this.control = control;
        this.state = state;
        this.isMoving = isMoving;
    }

    @Override
    public void update(double timeElapsed)
    {
        if (isMoving)
        {
            Point loc = state.getMouseLocation();
            x = loc.x;
            y = loc.y;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(control.getImage("probe.png"), x, y, null);
    }

    @Override
    public boolean consumeMouseClick() {
        if (isMoving){
            isMoving = false;
            return true;
        }
        return false;
    }
}
