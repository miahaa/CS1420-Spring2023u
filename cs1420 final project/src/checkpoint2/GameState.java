package checkpoint2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameState
{
    // Fields
    private List<GameObject> currentFrameObjects;
    private List<GameObject> nextFrameObjects;
    private int cities;
    private int money;
    private int mouseX;
    private int mouseY;

    public GameState ()
    {
        currentFrameObjects = new ArrayList<GameObject>();
        money = 100;
        cities = 100;
    }

    public List<GameObject> getCurrentObjects ()
    {
        return currentFrameObjects;
    }

    public void startFrame ()
    {
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
        for (int i = 0; i < nextFrameObjects.size(); i++)
        {
           if (nextFrameObjects.get(i).hasExpired)
               nextFrameObjects.remove(nextFrameObjects.get(i));
        }
        currentFrameObjects = nextFrameObjects;
        nextFrameObjects = null;  // This makes it clear there is only a current list now.
    }

    public int getMoney() {return money;}
    public int getCities(){return cities;}
    public void setMoney(int money){this.money = money;}
    public void setCities(int cities){this.cities = cities;}
    public Point getMouseLocation(){return new Point(mouseX, mouseY);}
    public void setMouseLocation(int mouseX, int mouseY)
    {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }
}
