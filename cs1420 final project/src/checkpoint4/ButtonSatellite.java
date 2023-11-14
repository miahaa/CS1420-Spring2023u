package checkpoint4;

import java.awt.*;

public class ButtonSatellite extends GameObject implements Clickable
{
    private Control control;
    private GameState state;

    public ButtonSatellite(Control control, GameState state)
    {
        super();
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
         g.setColor(Color.BLACK);
         g.fillRoundRect(615, 400, 75, 75, 10, 10);
         g.setColor(Color.GRAY);
         g.fillRoundRect(617, 402, 71, 71, 10, 10);

         g.drawImage(control.getImage("probe.png"), 625, 410, null);
         g.setColor(Color.YELLOW);
         g.setFont(new Font("Arial", Font.BOLD, 24));
         g.drawString("60", 640, 500);
    }

    @Override
    public boolean consumeClick()
    {
        Point mouseLoc = state.getMouseLoc();
        if (mouseLoc.x >= 615 && mouseLoc.x <= 615+75 &&
            mouseLoc.y >= 400 && mouseLoc.y <= 400+75)
        {
            if (state.getMoney() >= 60)
                state.addGameObject(new Satellite(control, state));
            return true;
        }

        return false;
    }
}
