package checkpoint1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Path
{
	private ArrayList<Point> pathPoints; // Arraylist storing the points of the path class

	/**
	 * Constructor creates Path object
	 */
	public Path ()
	{
		pathPoints = new ArrayList<Point>();
	}

	/**
	 * Second construct with one Scanner parameter
	 *
	 * @param in scanner to scan through the ArrayList
	 */
	public Path (Scanner in)
	{
		pathPoints = new ArrayList<Point>();
		
		int size = in.nextInt();
		for (int i = 0; i < size; i++)
			pathPoints.add(new Point(in.nextInt(), in.nextInt()));		
	}

	/**
	 *
	 * @return the size of the pathPoints ArrayList
	 */
	public int getPointCount()
	{
		return pathPoints.size();
	}

	/**
	 * Return x coordinate of a point in pathPoints, given its location.
	 * @param n the location in the pathPoints ArrayList
	 * @return the x coordinate of the nth point in the pathPoints
	 */
	public int getX (int n)
	{
		return pathPoints.get(n).x;
	}

	/**
	 * Return y coordinate of a point in pathPoints, given its location.
	 * @param n the location in the pathPoints ArrayList
	 * @return the y coordinate of the nth point in the pathPoints
	 */
	public int getY (int n)
	{
		return pathPoints.get(n).y;
	}

	/**
	 * Return a point in pathPoints, given its location.
	 * @param n the location in the pathPoints ArrayList
	 * @return the nth point in the pathPoints
	 */
	public Point getPoint (int n) { return pathPoints.get(n); }

	/**
	 * Add point to the pathPoints ArrayList
	 * @param x the x coordinate of the point that will be added
	 * @param y the y coordinate of the point that will be added
	 */
	public void add (int x, int y)
	{
		pathPoints.add(new Point(x,y));
	}

	/**
	 * Return the String representation of the pathPoints ArrayList
	 */
	public String toString ()
	{
		String result = "" + getPointCount() + "\n";
		for (Point p : pathPoints)
			result += p.x + " " + p.y + "\n";
		return result;
	}

	/**
	 * Draw the path based on the coordinates of the points in pathPoints
	 * */
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

	/**
	 * Given a percentage between 0% and 100%, this method calculates
	 * the location along the path that is exactly this percentage
	 * along the path. The location is returned in a Point object
	 * (integer x and y), and the location is a screen coordinate.
	 *
	 * If the percentage is less than 0%, the starting position is
	 * returned. If the percentage is greater than 100%, the final
	 * position is returned.
	 *
	 * Callers must not change the x or y coordinates of any returned
	 * point object (or the caller could be changing the path).
	 *
	 * @param percentTraveled a distance along the path
	 * @return the screen coordinate of this position along the path
	 */
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
