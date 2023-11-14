package checkpoint3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Path
{
	// Mostly uncommented -- add contracts/comments to understand what's going
	// on.  (Style requirements checked on each checkpoint.)

	private ArrayList<Point> pathPoints;

	private double totalPathLength;  // Hack - only computed on construction

	public Path()
	{
		pathPoints = new ArrayList<Point>();
	}

	public Path(Scanner in)
	{
		pathPoints = new ArrayList<Point>();

		int size = in.nextInt();
		for (int i = 0; i < size; i++)
			pathPoints.add(new Point(in.nextInt(), in.nextInt()));

 		// Compute the path length.

		totalPathLength = 0;

		// If we count segments starting at 1,
		//   segment 1 is path[0]   ... path[1], and
		//   segment n is path[n-1] ... path[n].
		//
		// In an array or list, the last entry is indexed one less
		//   than the length of the list, so as long as the index is
		//   less than the length (or size) of the list, it is valid.
		//
		// Remember, for arrays use path.length.  For List objects, use path.size()

		for (int i = 1; i < pathPoints.size(); i++)
		{
			Point start = pathPoints.get(i-1);  // Extract segment start/end
			Point end   = pathPoints.get(i);

			totalPathLength += start.distance(end);
		}
	}

	public int getPointCount()
	{
		return pathPoints.size();
	}

	public int getX (int n)
	{
		return pathPoints.get(n).x;
	}

	public int getY (int n)
	{
		return pathPoints.get(n).y;
	}

	public void add (int x, int y)
	{
		pathPoints.add(new Point(x,y));
	}

	public String toString ()
	{
		String result = "" + getPointCount() + "\n";
		for (Point p : pathPoints)
			result += p.x + " " + p.y + "\n";
		return result;
	}

	public void draw (Graphics g)
	{
		g.setColor (Color.RED);
		Point last = null;
		for (Point p : pathPoints)
		{
			if (last != null)
			{
				g.drawLine(last.x, last.y, p.x,  p.y);
				g.drawLine(last.x, last.y+1, p.x,  p.y+1);
				g.drawLine(last.x+1, last.y, p.x+1,  p.y);
				g.drawLine(last.x+1, last.y+1, p.x+1,  p.y+1);
			}
			last = p;
		}

	}


	public Point convertToCoordinates(double percentTraveled)
	{
		// check starting point and ending point
		if (percentTraveled <= 0.0)
			return new Point(getX(0), getY(0));
		if (percentTraveled >= 1.0)
			return new Point(getX(getPointCount() - 1), getY(getPointCount() - 1));

		// calculate the length of the entire path
		double pathLength = 0.0;
		for (int i = 0; i < getPointCount() - 1; i++)
		{
			int x1 = getX(i);
			int x2 = getX(i+1);
			int y1 = getY(i);
			int y2 = getY(i+1);
			pathLength += Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		}

		double distanceTraveled = percentTraveled * pathLength; // the distance that has been travelled

		// Declare needed variables
		int xStart = 0;
		int yStart = 0;
		int xEnd = 0;
		int yEnd = 0;
		double checkPath = 0.0;
		double currentPercentTravel = 0.0;

		for (int i = 0; i < getPointCount() - 1; i++)
		{
			int x1 = getX(i);
			int x2 = getX(i+1);
			int y1 = getY(i);
			int y2 = getY(i+1);
			checkPath += Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
			if (distanceTraveled <= checkPath)
			{
				xStart = getX(i); // x coordinate of the starting point of the current path
				yStart = getY(i); // y coordinate of the starting point of the current path
				xEnd = getX(i+1); // x coordinate of the ending point of the current path
				yEnd = getY(i+1); // y coordinate of the ending point of the current path
				currentPercentTravel = 1 - (checkPath - distanceTraveled) / Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)); // the percentage of the current path that has been traveled
				break;
			}
		}

		int xResult = (int)((1 - currentPercentTravel) * xStart + currentPercentTravel * xEnd); // the x coordinate of the current position
		int yResult = (int)((1 - currentPercentTravel) * yStart + currentPercentTravel * yEnd); // the y coordinate of the current position
		return new Point(xResult, yResult);
	}

}
