package assignment02;
import java.util.*;

/**
 * This class implements this cool idea: calculating the hypotenuse of a triangle based on Pythagorean theorem
 *
 * @author  Thu Ha
 * @version January 16, 2023
 */

public class Hypotenuse {
    public static void main (String[] args)
    {
        // Create two Int variables
        double first_side;
        double second_side;

        // Create the scanner object
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the length of the first side: ");
        first_side = in.nextDouble();
        System.out.println("Please enter length of the second side: ");
        second_side = in.nextDouble();

        // Double the lengths of two sides
        double a = first_side * first_side;
        double b = second_side * second_side;

        // Calculate hypotenuse
        double hypotenuse = Math.sqrt(a + b);
        System.out.println("A triangle " + first_side + " feet and " + second_side
        + " feet long has the hypotenuse of " + hypotenuse + " feet.");
    }
}
