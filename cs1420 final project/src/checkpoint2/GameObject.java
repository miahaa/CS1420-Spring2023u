package checkpoint2;

public abstract class GameObject implements Animatable
{
    protected boolean hasExpired;

    public GameObject()
    {
        this.hasExpired = false;
    }
    public boolean hasExpired(){return hasExpired;}
    public boolean consumeMouseClick()
    {
        return false;
    }
}
