package checkpoint4;

import java.awt.*;

public class GeneratorComet extends GameObject
{
    private Control control;
    private GameState state;
    private double countdownToNextComet;  // in seconds
    private int cometsCreated;  // count
    private double countdownMultiplier;

    public GeneratorComet(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        countdownToNextComet = 2.0;
        cometsCreated = 0;
        countdownMultiplier = 1.0;
    }

    public double getCountdownMultiplier(){return countdownMultiplier;}

    @Override
    public void update(double timeElapsed)
    {

        if (countdownMultiplier >= 0.5)
        {
            countdownToNextComet -= timeElapsed;
            if (countdownToNextComet <= 0)
            {
                countdownToNextComet = ((cometsCreated % 3 != 0) ? 0.5 : 3) * countdownMultiplier;
                state.addGameObject(new Comet(control, state));
                cometsCreated++;
                countdownMultiplier *= 0.99;
            }
        }

        else
        {
            state.adjustWin();
        }

    }

    @Override
    public void draw(Graphics g) {}
}
