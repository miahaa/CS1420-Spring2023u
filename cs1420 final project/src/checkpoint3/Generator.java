package checkpoint3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Generator extends GameObject
{
    private Control control;
    private GameState state;
    private double countdownToNextAsteroid, countdownToNextComet;
    private int countAsteroid, countComet;
    private double waitingTimeForAsteroid, waitingTimeForComet;
    private int limitForAsteroid, limitForComet;

    public Generator(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;

        // Statistics for Asteroid
        countdownToNextAsteroid = 0.5;
        countAsteroid = 0;
        waitingTimeForAsteroid = 2.0;
        limitForAsteroid = 4;

        // Statistics for Comet
        countdownToNextComet = 0.0;
        countComet = 0;
        waitingTimeForComet = 2.5;
        limitForComet = 1;
    }

    @Override
    public void update(double timeElapsed)
    {
        if (countAsteroid == limitForAsteroid)
        {
            waitingTimeForAsteroid -= timeElapsed;
            if (waitingTimeForAsteroid <= 0)
            {
                waitingTimeForAsteroid = 2.0;
                countAsteroid = 0;
                limitForAsteroid += 1;
            }
        }

        else
        {
            countdownToNextAsteroid -= timeElapsed;
            if (countdownToNextAsteroid <= 0)
            {
                countdownToNextAsteroid = 0.5;
                countAsteroid += 1;
                state.addGameObject(new Asteroid(control, state));
            }
        }

        if (countComet == limitForComet)
        {
            waitingTimeForComet -= timeElapsed;
            if (waitingTimeForComet <= 0)
            {
                waitingTimeForComet = 2.0;
                countComet = 0;
                limitForComet += 1;
            }
        }

        else
        {
            countdownToNextComet -= timeElapsed;
            if (countdownToNextComet <= 0)
            {
                countdownToNextComet = 0.5;
                countComet += 1;
                state.addGameObject(new Comet(control, state));
            }
        }
    }

    @Override
    public void draw(Graphics g) {}

}
