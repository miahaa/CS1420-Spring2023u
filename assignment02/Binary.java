package assignment02;
import java.util.*;

/**
 * This class implements this cool idea: convert an integer between 0 and 255 (inclusive)
 * to eight-bit-binary
 *
 * @author  Thu Ha
 * @version January 16, 2023
 */
public class Binary {
    public static void main (String[] args)
    {
        // Create variables
        int first_digit, second_digit, third_digit, forth_digit, fifth_digit, sixth_digit, seventh_digit, eighth_digit;
        int userInput, quotient, remainder;
        int binary_number;

        //Create the scanner object
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        userInput = scan.nextInt();

        // Convert decimal to binary number
        first_digit = userInput % 2;
        quotient = userInput / 2;
        second_digit = quotient % 2;
        quotient = quotient / 2;
        third_digit = quotient % 2;
        quotient = quotient / 2;
        forth_digit = quotient % 2;
        quotient = quotient / 2;
        fifth_digit = quotient % 2;
        quotient = quotient / 2;
        sixth_digit = quotient % 2;
        quotient = quotient / 2;
        seventh_digit = quotient % 2;
        quotient = quotient / 2;
        eighth_digit = quotient % 2;

        System.out.print("The decimal number " + userInput + " is " + eighth_digit + seventh_digit + sixth_digit + fifth_digit + forth_digit + third_digit + second_digit + first_digit + " in binary.");

    }
}
