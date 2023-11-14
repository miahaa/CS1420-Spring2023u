package checkpoint2;

import java.awt.Graphics;

public interface Animatable
{
    // Uncommented -- add contracts/comments to understand what's going
    // on.  (Style requirements checked on each checkpoint.)

    public void update(double timeElapsed);
    public void draw(Graphics g);
}
