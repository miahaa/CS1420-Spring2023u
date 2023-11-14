package assignment03;
import java.util.*;
/**
 * This class implements this cool idea: Hailstone consequence that if the current integer N is even, the next number
 * is computed as N / 2. If the current integer N is odd, the next number is computed as N * 3 + 1.
 * @author  Thu Ha
 * @version January 24, 2023
 */
public class Hailstone {
    public static void main(String[] arg) {
        // Create scanner object
        Scanner in = new Scanner(System.in);

        // Declare variables
        int userInput = 0;
        int number = 0;
        int counts = 0;

        // Check userInput is positive or not
        boolean userInputIsPositive = false;
        while ( userInputIsPositive == false )// Loop as long as the user input is NOT positive
        {
            // Get input from user
            System.out.print("Enter the first number to start the Hailstone sequence: ");
            userInput = in.nextInt();
            // Test the input for validity
            //  If valid, set userInputIsPositive to true
            if (userInput > 0)
                userInputIsPositive = true;
        }
        number = userInput;
        System.out.print(number + " ");

        while(number != 1)
        {
            counts += 1;
            if(number % 2 == 0){
                number = number/2;
            }
            else {
                number = number*3 + 1;
            }
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("The total iterations performed is " + counts);
    }

}





