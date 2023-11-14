package checkpoint0;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Path
{
    ArrayList<Point> points;
    public Path()
    {
        points = new ArrayList<Point>();
    }

    public int getNumberOfPoints(){return points.size();}
    public Point getPoint(int n){return points.get(n);}
    public void addPoint(Point p){points.add(p);}

    public String toString()
    {
        String coordinates = "";
        for (int i = 0; i < points.size(); i++)
        {
            coordinates += points.get(i).x + " " + points.get(i).y + "\n";
        }
        return points.size() + "\n" + coordinates;
    }


}