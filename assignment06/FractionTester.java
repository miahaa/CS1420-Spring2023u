/**
 * Fraction objects represent a fraction by numerator and denominator.
 *
 * @author Thu Ha
 * @version February 20, 2023
 */

package assignment06;

public class FractionTester {

    public static void main(String[] args) {
        System.out.println ("Fraction tester:");  // Put breakpoint right here ( for debugging)
        boolean isCorrect = true;

        Fraction f = new Fraction (2, 6);
        Fraction g = new Fraction (-1, -4);
        Fraction h = new Fraction (5, -10);
        Fraction i = new Fraction (3, 4);
        System.out.println();

        //Test reducing fraction using gcd and negate both numerator and denominator
        System.out.println("Test reducing fraction using gcd and negate both numerator and denominator: ");
        System.out.println ("Fraction f contains: " + f);
        System.out.println ("Fraction g contains: " + g);
        System.out.println ("Fraction h contains: " + h);
        System.out.println ("Fraction i contains: " + i);
        System.out.println();

        System.out.println ("G's denominator is: " + g.getDenominator());
        System.out.println ("F's numerator is: " + f.getNumerator());
        System.out.println ("H's denominator is: " + h.getDenominator());
        System.out.println ("G's numerator is: " + g.getNumerator());
        System.out.println();

        //Test multiply method
        System.out.println("Test multiply method: ");
        System.out.println("The left-hand side is f, the right-hand side is g and the product is " + f.multiply(g));
        System.out.println("The left-hand side is g, the right-hand side is h and the product is " + g.multiply(h));
        System.out.println("The left-hand side is h, the right-hand side is f and the product is " + h.multiply(f));
        Fraction a = new Fraction (2, 3);
        Fraction b = new Fraction (1, 5);
        Fraction c = a.multiply(b);
        System.out.println (a + " * " + b + " = " + c);
        if (a.getNumerator() != 2 || a.getDenominator() != 3 ||
                b.getNumerator() != 1 || b.getDenominator() != 5 ||
                c.getNumerator() != 2 || c.getDenominator() != 15)
        {
            System.out.println("Error - multiply did not complete correctly.");
            isCorrect = false;
        }
        System.out.println();

        //Test divide method
        System.out.println("Test divide method");
        System.out.println("The left-hand side is f, the right-hand side is g and the division is " + f.divide(g));
        System.out.println("The left-hand side is g, the right-hand side is h and the division is " + g.divide(h));
        System.out.println("The left-hand side is i, the right-hand side is f and the division is " + i.divide(f));
        Fraction d = f.divide(g);

        System.out.println (f + " / " + g + " = " + d);
        if (f.getNumerator() != 1 || f.getDenominator() != 3 ||
                g.getNumerator() != 1 || g.getDenominator() != 4 ||
                d.getNumerator() != 4 || d.getDenominator() != 3)
        {
            System.out.println("Error - division did not complete correctly.");
            isCorrect = false;
        }
        System.out.println();

        //Test sum method
        System.out.println("Test sum method: ");
        System.out.println("The left-hand side is f, the right-hand side is g and the sum is " + f.add(g));
        System.out.println("The left-hand side is g, the right-hand side is i and the sum is " + g.add(i));
        System.out.println("The left-hand side is h, the right-hand side is f and the sum is " + h.add(f));

        Fraction e = f.add(g);
        System.out.println (f + " + " + g + " = " + e);
        if (f.getNumerator() != 1 || f.getDenominator() != 3 ||
                g.getNumerator() != 1 || g.getDenominator() != 4 ||
                e.getNumerator() != 7 || e.getDenominator() != 12)
        {
            System.out.println("Error - add did not complete correctly.");
            isCorrect = false;
        }
        System.out.println();

        //Test subtract method
        System.out.println("Test subtract method");
        System.out.println("The left-hand side is f, the right-hand side is g and the subtraction is " + f.subtract(g));
        System.out.println("The left-hand side is g, the right-hand side is i and the subtraction is " + g.subtract(i));
        System.out.println("The left-hand side is h, the right-hand side is f and the subtraction is " + h.subtract(f));

        Fraction k = f.subtract(g);
        System.out.println (f + " - " + g + " = " + k);
        if (f.getNumerator() != 1 || f.getDenominator() != 3 ||
                g.getNumerator() != 1 || g.getDenominator() != 4 ||
                k.getNumerator() != 1 || k.getDenominator() != 12)
        {
            System.out.println("Error - subtract did not complete correctly.");
            isCorrect = false;
        }
        System.out.println();

        System.out.println("Test toDouble method: ");
        double m = f.toDouble();
        System.out.println(f + " to double is " + m);

        System.out.println();
        if (isCorrect == false)
        {
            System.out.println("All tests completed, errors found.");
        }
        else
            System.out.println("All tests completed, no errors.");

    }

}
