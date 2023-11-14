package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

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
        state.addGameObject(new ButtonGun(control, state));
    }

    @Override
    public void update(double timeElapsed)
    {
        // nothing
    }

    @Override
    public void draw(Graphics g)
    {
        BufferedImage menu = control.getImage("menubackground.png");
        g.drawImage(menu, 600, 0, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        // Draw money
        BufferedImage money = control.getImage("money.png");
        g.drawImage(money, 640, 100, null);
        g.drawString(": " + state.getMoney(), 690, 135);

        // Draw cities
        BufferedImage city = control.getImage("city.png");
        g.drawImage(city, 635, 165, null);
        g.drawString(": " + state.getCityCount(), 690, 205);

        // Draw menu
        BufferedImage menuButton = control.getImage("menu.png");
        g.drawImage(menuButton, 615, -40, null);

    }
}
