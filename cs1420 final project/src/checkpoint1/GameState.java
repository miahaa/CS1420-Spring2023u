package checkpoint1;

import java.util.ArrayList;
import java.util.List;

public class GameState
{
    private List<Animatable> currentFrameObjects;
    private List<Animatable> nextFrameObjects;

    public GameState()
    {
        currentFrameObjects = new ArrayList<Animatable>();
    }

    public List<Animatable> getCurrentObjects ()
    {
        return currentFrameObjects;
    }

    public void startFrame ()
    {
        nextFrameObjects = new ArrayList<Animatable>();    // Creates empty list
        nextFrameObjects.addAll(currentFrameObjects);      // Add all the current ones to the new list.
    }

    public void finishFrame ()
    {
        currentFrameObjects = nextFrameObjects;
        nextFrameObjects = null;  // This makes it clear there is only a current list now.
    }

    public void addGameObject (Animatable a)
    {
        nextFrameObjects.add(a);
    }
}
