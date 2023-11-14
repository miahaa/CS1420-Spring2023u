package assignment02;
import java.util.*;
/**
 * This class implements this cool idea: calculating the area of a circle from the
 * value inputted by user
 *
 * @author  Thu Ha
 * @version January 16, 2023
 */

public class CircleArea {
    public static void main (String[] args)
    {
        // Create two variables
        double radius;
        double area;
        // Create the scanner object
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the radius: ");
           radius = in.nextDouble();
        // Compute the area.
        area = Math.PI * radius * radius;
        System.out.println("A circle " + radius + " feet radius has an area of " + area + " square feet.");
    }
}
