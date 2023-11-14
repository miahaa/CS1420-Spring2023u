package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class GameObject implements Animatable
{
    protected boolean hasExpired;

    public GameObject ()
    {
        hasExpired = false;
    }

    public boolean hasExpired ()
    {
        return hasExpired;
    }

    // Helper function

    protected void drawCenteredImage (Graphics k, BufferedImage image, int x, int y, double scale)
    {
        int width  = (int)(image.getWidth() * scale);
        int height = (int) (image.getHeight() * scale);
        int nx = x - width/2;
        int ny = y - height/2;

        k.drawImage(image, nx, ny, width, height, null);
    }


}
