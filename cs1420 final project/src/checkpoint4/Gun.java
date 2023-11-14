package checkpoint4;

import java.awt.*;

public class Gun extends GameObject implements Clickable
{
    private Control control;
    private GameState state;
    private Point location;
    private boolean isMoving;
    private double cooldownTime;  // seconds

    public Gun(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        isMoving = true;
    }

    @Override
    public void update(double timeElapsed)
    {
        cooldownTime -= timeElapsed;

        if (isMoving)
            location = state.getMouseLoc();
        else
        {
            // Target an entity
            double futureTime = 0.75;
            Targetable t = state.getNearestTargetable(location, futureTime);

            if (t != null)
            {
                Point targetLoc = t.getFutureLocation(futureTime);
                double dist = targetLoc.distance(location);

                if (dist < 110 && cooldownTime <= 0) {
                    // Fire a shot from here to the target
                    cooldownTime = 2.0;
                    state.addGameObject(new Bomb(state, control, location, targetLoc));
                }
            }
        }
    }

    @Override
    public void draw(Graphics g)
    {
        if (location != null)
            drawCenteredImage(g, control.getImage("canon.png"), location.x, location.y, 1);
    }

    @Override
    public boolean consumeClick()
    {
        if (isMoving)
        {
            Point mouseLoc = state.getMouseLoc();
            if (mouseLoc.x < 0 || mouseLoc.y < 0 || mouseLoc.x > 600 || mouseLoc.y > 600)
                hasExpired = true;
            else if (mouseLoc.x >= 445 && mouseLoc.x <= 530 && mouseLoc.y >= 315 && mouseLoc.y <= 400)
                hasExpired = true;
            else if (mouseLoc.x >= 360 && mouseLoc.x <= 490 && mouseLoc.y >= 90 && mouseLoc.y <= 220)
                hasExpired = true;
            else if (mouseLoc.x >= 80 && mouseLoc.x <= 260 && mouseLoc.y >= 190 && mouseLoc.y <= 370)
                hasExpired = true;
            else if (mouseLoc.x >= 460 && mouseLoc.x <= 582 && mouseLoc.y >= 428 && mouseLoc.y <= 580)
                hasExpired = true;
            else
            {
                for (GameObject g : state.getCurrentObjects())
                {
                    if (g instanceof Satellite)
                    {
                        Point loc = ((Satellite) g).getLocation();
                        if (loc.distance(location) < 40)
                            hasExpired = true;
                    }
                    else if (g instanceof Gun && !((Gun) g).getLocation().equals(location))
                    {
                        Point loc = ((Gun) g).getLocation();
                        if (loc.distance(location) < 40)
                            hasExpired = true;
                    }
                }
            }
            if (!hasExpired)
                state.adjustMoney(-200);
            System.out.println("x: " + mouseLoc.x + ", y: " + mouseLoc.y);
            isMoving = false;
            return true;
        }

        return false;
    }
    public Point getLocation(){return location;}

}
