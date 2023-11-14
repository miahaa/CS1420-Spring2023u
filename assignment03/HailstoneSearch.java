package assignment03;
import java.util.*;
/**
 * This class implements this cool idea: "Is there a Hailstone sequence of length X that starts from some N?"
 * That from the sequence length we can find the starting number
 * @author  Thu Ha
 * @version January 24, 2023
 */

public class HailstoneSearch {
    public static void main(String[] arg){
        // Declare variable
        int sequenceLength;
         // Create scanner object and get userInput
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter sequence length: ");
        sequenceLength = in.nextInt();
        // Loop
        for (int i = 2; i <= 1000; i++) {
            int n = i;
            int counts = 0;
            while(n != 1)
            {
                counts += 1;
                if(n % 2 == 0){
                    n = n/2;
                }
                else {
                    n = n*3 + 1;
                }
            }
            if (counts == sequenceLength) {
                System.out.println("The Hailstone sequence starting at " + i + " takes " + sequenceLength + " steps to converge to 1.");
                break;
            }
        }
    }
}
