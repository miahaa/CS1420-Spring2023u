package checkpoint4;

import java.awt.*;

public class ButtonGun extends GameObject implements Clickable
{
    private Control control;
    private GameState state;

    public ButtonGun(Control control, GameState state)
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
         g.fillRoundRect(715, 400, 75, 75, 10, 10);
         g.setColor(Color.GRAY);
         g.fillRoundRect(717, 402, 71, 71, 10, 10);

         g.drawImage(control.getImage("canon.png"), 725, 410, null);
         g.setColor(Color.YELLOW);
         g.setFont(new Font("Arial", Font.BOLD, 24));
         g.drawString("200", 732, 500);
    }

    @Override
    public boolean consumeClick()
    {
        Point mouseLoc = state.getMouseLoc();
        if (mouseLoc.x >= 715 && mouseLoc.x <= 715+75 &&
            mouseLoc.y >= 400 && mouseLoc.y <= 400+75)
        {
            if (state.getMoney() >= 200)
                state.addGameObject(new Gun(control, state));
            return true;
        }

        return false;
    }
}
