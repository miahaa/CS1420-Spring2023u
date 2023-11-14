package checkpoint4;

import java.awt.*;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound extends GameObject
{
    private GameState state;
    private Control control;
    private double time;
    private int i;
    Clip clip;
    URL soundURL[] = new URL[10];

    public Sound(Control control, GameState state, int i)
    {
        this.state = state;
        this.control = control;
        this.i = i;
        soundURL[0] = getClass().getResource("/sound/explosion.wav");
        soundURL[1] = getClass().getResource("/sound/heart.wav");
        soundURL[2] = getClass().getResource(("/sound/background_music.wav"));
        time = 0.05;
    }

    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            FloatControl fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            if (i == 1)
                fc.setValue(-20.0f);
            else if (i == 0)
                fc.setValue(-10.0f);
        }
        catch(Exception e) {}
    }

    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }

    @Override
    public void update(double timeElapsed)
    {
        if (i != 2)
        {
            time -= timeElapsed;
            this.setFile(i);
            this.play();
            if (time <= 0) {
                hasExpired = true;
            }
        }
    }

    @Override
    public void draw(Graphics g) {}
}