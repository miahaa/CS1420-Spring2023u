package assignment03;
import java.lang.Math;
/**
 * This class implements this cool idea: uses a loop to output the powers of two from 2^0
 * through 2^16, inclusive
 * @author  Thu Ha
 * @version January 24, 2023
 */
public class PowersOfTwo {
    public static void main(String[] arg) {
        // Declare variables
        double result;
        // Loop
        for(int i = 0; i <= 16; i++){
            result = Math.pow(2, i);
            System.out.println(result);
        }
    }
}
