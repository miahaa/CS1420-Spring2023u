package checkpoint3;

import java.awt.*;

public class Satellite extends GameObject implements Clickable
{
    private Control control;
    private GameState state;
    private Point location;
    private boolean isMoving;
    private double time;

    public Satellite(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        isMoving = true;
        time = 0.0;
    }

    @Override
    public void update(double timeElapsed)
    {
        if (isMoving)
            location = state.getMouseLoc();

        else
        {
            if (time <= 0)
            {
                time = 1.0;
                Targetable t = state.findNearest(location);
                if (t != null && location.distance(t.getLocation()) < 50) {
                    state.addGameObject(new PhotonTorpedo(control, state, location, t.getLocation()));
                }
            }
            else
            {
                time -= timeElapsed;
            }
        }
    }

    @Override
    public void draw(Graphics g)
    {
        if (location != null)
            g.drawImage(control.getImage("probe.png"), location.x, location.y, null);
    }

    @Override
    public boolean consumeClick()
    {
        if (isMoving)
        {
            Point mouseLoc = state.getMouseLoc();
            if (mouseLoc.x < 0 || mouseLoc.y < 0 || mouseLoc.x > 600 || mouseLoc.y > 600)
                hasExpired = true;
            isMoving = false;
            return true;
        }

        return false;
    }
}
