package checkpoint3;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class GameState
{
    // Fields

    private List<GameObject> currentFrameObjects;
    private List<GameObject> nextFrameObjects;
    private int cityCount;
    private Point mouseLocation;
    private double elapsedTime;
    private long lastFrameStartTime;

    public GameState ()
    {
        currentFrameObjects = new ArrayList<GameObject>();
        cityCount = 20;
        lastFrameStartTime = System.currentTimeMillis();
    }

    public int getCityCount ()
    {
        return cityCount;
    }

    public void adjustCityCount (int amount)
    {
        cityCount += amount;
    }

    public Point getMouseLoc()
    {
        return mouseLocation;
    }

    public void setMouseLocation(Point mouseLoc)
    {
        this.mouseLocation = mouseLoc;
    }

    public List<GameObject> getCurrentObjects ()
    {
        return currentFrameObjects;
    }
    public double getElapsedTime(){return elapsedTime;}

    public void startFrame ()
    {
        long currentFrameStartTime = System.currentTimeMillis();
        elapsedTime = (currentFrameStartTime - lastFrameStartTime)/1000.0;
        lastFrameStartTime = currentFrameStartTime;
        nextFrameObjects = new ArrayList<GameObject>();    // Creates empty list
        nextFrameObjects.addAll(currentFrameObjects);      // Add all the current ones to the new list.
    }

    public void addGameObject (GameObject a)
    {
        nextFrameObjects.add(a);
    }

    public void finishFrame ()
    {
        // Remove any current objects that are expired from the
        // next frame.

        for (GameObject go : currentFrameObjects)
            if (go.hasExpired())
                nextFrameObjects.remove(go);

        currentFrameObjects = nextFrameObjects;
        nextFrameObjects = null;  // This makes it clear there is only a current list now.
    }

    public Targetable findNearest (Point somePoint)
    {
        Targetable nearestObject = null;
        double shortestLength = 1000.0;
        for (GameObject g : currentFrameObjects)
        {
            if (g instanceof Targetable)
            {
                double distance = somePoint.distance(((Targetable) g).getLocation());
                if (distance < shortestLength)
                {
                    shortestLength = distance;
                    nearestObject = (Targetable) g;
                }
            }
        }
        return nearestObject;
    }
}
