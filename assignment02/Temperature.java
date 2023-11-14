package assignment02;
import java.util.*;

/**
 * This class implements this cool idea: Convert Fahrenheit temperature into Celsius temperature
 *
 * @author  Thu Ha
 * @version January 16, 2023
 */

public class Temperature {
    public static void main (String[] args)
    {
        // Create Int variable
        int Fahrenheit;

        // Create the scanner object
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the Fahrenheit temperature: ");
        Fahrenheit = in.nextInt();

        // Convert into Celsius temperature
        int Celsius = ((Fahrenheit - 32) * 5)/9;

        System.out.println(Fahrenheit + "°F is equal " + Celsius + "°C.");
    }
}
