package checkpoint4;

import java.awt.*;

public class GeneratorAsteroid extends GameObject
{
    private Control control;
    private GameState state;
    private double countdownToNextAsteroid;  // in seconds
    private int asteroidsCreated;  // count
    private double countdownMultiplier;

    public GeneratorAsteroid(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        countdownToNextAsteroid = 2.0;
        asteroidsCreated = 0;
        countdownMultiplier = 1.0;
    }

    public double getCountdownMultiplier(){return countdownMultiplier;}

    @Override
    public void update(double timeElapsed)
    {
        if (countdownMultiplier >= 0.0)
        {
            countdownToNextAsteroid -= timeElapsed;

            if (countdownToNextAsteroid <= 0)
            {
                countdownToNextAsteroid = ((asteroidsCreated % 4 != 0) ? 0.5 : 2) * countdownMultiplier;
                state.addGameObject(new Asteroid(control, state));
                asteroidsCreated++;
                countdownMultiplier *= 0.99;
            }
        }

    }

    @Override
    public void draw(Graphics g){}
}
