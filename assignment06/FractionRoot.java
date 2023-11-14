package assignment06;
/**
 * Fraction objects represent a fraction by numerator and denominator.
 *
 * @author Thu Ha
 * @version February 20, 2023
 */
import java.util.Scanner;

public class FractionRoot {
    public static void main (String[] args)
    {
        // Create a scanner object
        Scanner in = new Scanner(System.in);

        // Get user input
        System.out.print("Input a numerator: ");   // Get numerator
        int numerator = in.nextInt();

        System.out.print("Input a denominator: ");    // Get denominator
        int denominator = in.nextInt();

        System.out.print("Input an approximation count: ");      // Get approximation count
        int approximationCount = in.nextInt();

        Fraction s = new Fraction(numerator, denominator);


        Fraction currentX = s.divide(new Fraction(2));

        int count = 0;
        while(count < approximationCount) {
            Fraction nextX = new Fraction(1, 2).multiply(currentX.add(s.divide(currentX)));
            currentX = nextX;
            count++;
        }

        System.out.println("The square root of " + s + " is approximately " + currentX);
    }

}



