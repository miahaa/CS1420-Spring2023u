package checkpoint3;

import java.awt.*;

public class MenuArea extends GameObject
{
    private Control control;
    private GameState state;

    public MenuArea(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    public void setUpMenuArea()
    {
        state.addGameObject(new ButtonSatellite(control, state));
    }

    @Override
    public void update(double timeElapsed) {}

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(600, 0, 200, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Look up!", 630, 50);
        g.drawString("Cities left: " + state.getCityCount(), 630, 100);
    }
}
