package checkpoint4;

import java.awt.*;

public class Bomb extends GameObject
{
    GameState state;
    Control control;
    Point startLoc, endLoc;
    Path myPath;
    double percentage;

    public Bomb(GameState state, Control control, Point location, Point targetLoc)
    {
        this.state = state;
        this.control = control;
        this.startLoc = location;
        this.endLoc = targetLoc;
        myPath = new Path();
        myPath.add(startLoc.x, startLoc.y);
        myPath.add(endLoc.x, endLoc.y);
        percentage = 0;
    }

    @Override
    public void update(double timeElapsed)
    {
        percentage += (1.00 / 0.75) * timeElapsed;

        Point pos = myPath.convertToCoordinates(percentage);
        Targetable t = state.getNearestTargetable(pos, 0);
        if (t != null) {
            Point tLoc = t.getFutureLocation(0);
            if (tLoc.distance(pos) < 20)
            {
                int count = 0;
                ((GameObject)t).hasExpired = true;
                for (GameObject g : state.getCurrentObjects())
                {
                    if (g instanceof Targetable)
                    {
                        Point loc = ((Targetable) g).getFutureLocation(0);
                        if (loc.distance(pos) < 70)
                        {
                            g.hasExpired = true;
                            count++;
                        }
                    }
                }
                this.hasExpired = true;
                state.addGameObject(new Explosion(control, state, tLoc));
                state.addGameObject(new Sound(control, state, 0));
                state.adjustMoney(count * 5);
            }
        }

        if (percentage >= 1.0)
            hasExpired = true;
    }

    @Override
    public void draw(Graphics g)
    {
        Point pos = myPath.convertToCoordinates(percentage);
        drawCenteredImage(g, control.getImage("bomb.png"), pos.x, pos.y, 1);
    }
}
