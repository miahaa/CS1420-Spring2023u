/*
 * A collection of unit tests for Assignment #7.  To make this work, you'll need to 
 * follow a few steps to get JUnit tests set up in your project.
 * 
 *     Find an @Test annotation above one of the functions below.
 *     It should be in red indicating that JUnit5 is not installed.
 *     Hover over it, and it will suggest JUnit4 along with more options.
 *     Do not install JUnit4.  Instead, look at the additional suggested
 *     options and select to install JUnit5.  Follow the prompts and
 *     JUnit5 will be installed for you.
 *
 *     That's it!  You should not need to adjust dependencies or
 *     install additional tools.  (Installing JUnit5 can be complex,
 *     but the above strategy is simple.)
 *
 *     I've already imported the needed classes (and functions) for
 *     JUnit5 assertions.  See below.
 *
 *  Peter Jensen
 *  
 * Modified by:
 * @author Thu Ha
 * @version March 1, 2023
 */
package assignment07;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	/* This is my first example unit test.  A unit test is just a piece of
	 * code that calls some method or builds some object, and tests 
	 * for errors.  The code/test design is up to the programmer.  
	 * 
	 * The unit test library provides functions for 'asserting' correctness.
	 * I use assertEquals below.  If the two values are not equal, the
	 * unit test library throws an exception and records a failure.
	 * 
	 * There are other assert functions in the unit test library that are
	 * useful for noting errors.  If the function below completes without
	 * recording a failure, then the test is marked as a success.
	 */
	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.
		
		int[] result;
		int size = 30;
		
		result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.
		
		// The function has a specific contract that guarantees things
		//  about it's return value.  Check to make sure the method
		//  call did what it was supposed to.
		
		// Make sure the size of the result array is correct.
		
		assertEquals(size, result.length);  // If unequal, an error is recorded.
		
		// Make sure the required numbers [0..n-1] are in the array.
		
		numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
		{
			// Search for n in the array.  When found, move on to the next n.
			
			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop;  // Found it, continue the outer loop.
			
			// If we get this far, the number n was not found.  This is an error.
			
			fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error 	
		}		
		
		// If the number loop completes without failing, all tests pass!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/* I wanted two unit tests for my function.  The first one, above,
	 *   just makes sure the basic operation of 'randomArray' is 
	 *   correct.  This second unit test makes sure the 'randomness'
	 *   is correct.  A truly random shuffle has equal likelihood
	 *   of any outcome.  I repeatedly generate random arrays,
	 *   then I count up results, and then check to make
	 *   sure that each outcome occurred with similar probability.
	 *   
	 * Because random numbers may produce results
	 *   that look uneven, I loop many times to reduce the likelihood
	 *   of random results looking like an error. 
	 *   
	 * I do not expect students to study this code - it is poor code.
	 *   (I don't like the way I'm counting permutations.)  There
	 *   are better ways, but you haven't seen the required lectures
	 *   yet, so I'm using a more primitive solution.  I expect your
	 *   unit tests to be much less complex.
	 */ 
	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.
		
		// Counts of how many times each permutation appears.
		
		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;
		
		// Repeatedly generate arrays (1,000,000 times).
		
		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.
			
			int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.
			
			// Keep counts of each permutation in the array.
			
			if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}
		
		// Check each permutation.  It should occur 166,666 times on average.  Accept
		//   anything within +/- 3,000.
		
		if (Math.abs(166_666 - count012) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
		
		if (Math.abs(166_666 - count021) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
		
		if (Math.abs(166_666 - count102) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
		
		if (Math.abs(166_666 - count120) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
		
		if (Math.abs(166_666 - count201) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
		
		if (Math.abs(166_666 - count210) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
		
		// If execution completes without failing, the test passes!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	
	@Test
	public void testReverseOrder01()
	{
		// create an array of characters
		char[] symbols = new char[26];
		for(int i = 0; i <26; i++)
		{
			symbols[i] = (char)( 65 + i);
		}

		// reverse the array
		ArrayExercises.reverseOrder(symbols);

		// create the array with the expected result
		char[] result = new char[26];
		for(int i = 0; i <26; i++)
		{
			result[i] = (char)( 65 + 25 - i);
		}

		// assert the array is equal
		assertArrayEquals(symbols, result);
	}
	
	/* Note:  You'll want more unit test functions.  Cut-and-paste existing tests, but increase
	 * the number in the function names.  Make sure to include @test before each function header.
	 * 
	 * testReverseOrder01
	 * testReverseOrder02
	 * testReverseOrder03  ...etc...
	 * 
	 * You can then put different test code in each test to be thorough.
	 */

	@Test
	public void testCount01()
	{
		// Create an array of characters
		String[] array = new String[] {new String("hello"), null, null};

		// count the number of character 'b'
		int count = ArrayExercises.count(array, null);

		// Create a new result
		int result = 2;
		assertEquals(count, result, "count test failed");
	}

	@Test
	public void testCount02()
	{
		String[] array = new String[]{"apple", "banana", "orange", "banana", "orange"};
		Object target = "banana";
		int count = ArrayExercises.count(array, target);
		int result = 2;
		assertEquals(count, result, "count test failed");
	}

	@Test
	public void testCount03()
	{
		Integer[] array = new Integer[]{1, 2, 3, 4, 3, 5};
		Object target = 3;
		int count = ArrayExercises.count(array, target);
		int result = 2;
		assertEquals(count, result, "count test failed");
	}

	@Test
	public void testCount04()
	{
		Color[] array = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.RED};
		Object target = Color.RED;
		int count = ArrayExercises.count(array, target);
		int result = 2;
		assertEquals(count, result, "count test failed");
	}

	@Test
	public void testCount05()
	{
		Object[] array = new Object[]{};
		Object target = "apple";
		int count = ArrayExercises.count(array, target);
		int result = 0;
		assertEquals(count, result, "count test failed");
	}
	@Test
	public void testReplace01()
	{
		// Create an array of String
		String[] list = new String[] {"Hello", "yes", "no", "Hello", "see you"};

		// Replace "hello" with "Goodbye"
		ArrayExercises.replace(list, "Hello", "Goodbye");

		// Create a new result
		String[] result = new String[] {"Goodbye", "yes", "no", "Goodbye", "see you"};

		assertArrayEquals(list, result, "replace test failed");
	}

	@Test
	public void testComputeAreas01()
	{
		// create width and height arrays
		double[] widths = {2.0, 2.0, 3.0, 0.0, 2.3};
		double[] heights = {5.0, 6.0, 7.0, 6.0, 3.3};

		// calculate the area
		double[] areas = ArrayExercises.computeAreas(widths, heights);

		// create a result
		double[] result = {10.0, 12.0, 21.0, 0.0, 2.3*3.3};

		assertArrayEquals(areas, result, "Test failed");
	}
	@Test
	public void testRemove01()
	{
		// Create array
		Color[] pixels = new Color[] {Color.RED, Color.cyan, Color.black, Color.WHITE, Color.BLUE};
		Color target = Color.WHITE;

		// Remove the target color
		Color[] removeArray = ArrayExercises.remove(pixels, target);

		// create a result
		Color[] result = {Color.RED, Color.cyan, Color.black, Color.BLUE};

		assertArrayEquals(removeArray, result, "test failed");
	}

	@Test
	public void testRemove02()
	{
		Color[] pixels = {Color.RED, null, Color.BLUE, Color.YELLOW, null};
		Color target = null;
		Color[] result = ArrayExercises.remove(pixels, target);
		Color[] expected = {Color.RED, Color.BLUE, Color.YELLOW};

		assertArrayEquals(result, expected, "test failed");
	}

	@Test
	public void testRemove03()
	{
		Color[] pixels = {Color.RED, new Color(0, 0, 153), Color.WHITE};
		Color target = new Color(0, 0, 153);
		Color[] result = ArrayExercises.remove(pixels, target);
		Color[] expected = {Color.RED, Color.WHITE,};

		assertArrayEquals(result, expected, "test failed");
	}
	@Test
	public void testSort01()
	{
		// create an array
		int[] values = new int[] {2, 5, 10, 3, 2, 10, 6, 7};
		// sort the data array
		ArrayExercises.sort(values);
		// create a result
		int[] result = {10, 10, 7, 6, 5, 3, 2, 2};

		assertArrayEquals(values, result, "test failed");
	}

	@Test
	public void testSort02() {
		int[] values = null;
		// sort the data array

		assertThrows(NullPointerException.class, () -> {
			ArrayExercises.sort(values);
		});
	}



	@Test
	public void testFindSmallest01()
	{
		// create an array
		Rectangle[] recs = new Rectangle[] {new Rectangle(2, 3), new Rectangle(5, 6), new Rectangle(10, 12), new Rectangle(3,2)};
		// find smallest rectangle
		Rectangle smallestRect = ArrayExercises.findSmallest(recs);
		// Create a result
		Rectangle result = new Rectangle(3, 2);

		assertEquals(smallestRect, result, "test Find Smallest failed");
	}
	
	@Test
	public void testHistogram01()
	{
		// create an array
		int[] data = new int[] {5, 6, 3, 2, 8, 6, 5, 5};
		// create a result
		int[] result = {0, 0, 1, 1, 0, 3, 2, 0, 1};

		assertArrayEquals(ArrayExercises.histogram(data), result, "histogram test failed");
	}
}
