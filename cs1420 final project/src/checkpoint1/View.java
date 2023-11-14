package checkpoint1;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class View extends JPanel
{
    private Control control;
    private GameState state;
    public View(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        JFrame f = new JFrame("Tower Defense");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setMinimumSize(new Dimension(600, 600));
        this.setPreferredSize(new Dimension(600, 600));

        // 'this' is our Runnable object, but it is also our JPanel.
        f.setContentPane(this);

        f.pack();
        f.setLocationRelativeTo(null);  // Centers window
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        for (Animatable a : state.getCurrentObjects())
            a.draw(g);
    }
}
