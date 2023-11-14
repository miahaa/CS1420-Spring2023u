/**
 * Fraction objects represent a fraction by numerator and denominator.
 *
 * @author Thu Ha
 * @version February 20, 2023
 */

package assignment06;
public class Fraction {
    private long numerator;
    private long denominator;

    /**
     * Create new Fraction object
     *
     * @param n numerator
     * @param d denominator
     */
    public Fraction(long n, long d) {
        // compute the gcd of x and y using a well-known algorithm
        long gcd = n;
        long remainder = d;

        while (remainder != 0)
        {
            long temp = remainder;
            remainder = gcd % remainder;
            gcd = temp;
        }

        this.numerator = n / gcd;
        this.denominator = d / gcd;
        if ( this.denominator < 0 )
        {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }

    }
    /**
     * Return the fraction
     *
     * @return fraction
     */
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
    public Fraction (long n)
    {
        this.numerator = n;
        this.denominator = 1;

    }



    /**
     * @return numerator
     */
    public long getNumerator() {
        return this.numerator;
    }

    /**
     * @return denominator
     */
    public long getDenominator() {
        return this.denominator;
    }

    /**
     * Calculate the sum of 2 fractions
     *
     * @param rightHandSide right hand fraction
     * @return the product of 2 fractions
     */
    public Fraction add (Fraction rightHandSide)
    {
        // Build a new fraction
        Fraction result = new Fraction(this.numerator * rightHandSide.denominator + this.denominator * rightHandSide.numerator,
                this.denominator * rightHandSide.denominator);

        // Return
        return result;
    }

    /**
     * Calculate the substract of 2 fractions
     *
     * @param rightHandSide right hand fraction
     * @return the product of 2 fractions
     */

    public Fraction subtract (Fraction rightHandSide)
    {
        // Build a new fraction
        Fraction result = new Fraction(this.numerator * rightHandSide.denominator - this.denominator * rightHandSide.numerator,
                this.denominator * rightHandSide.denominator);

        // Return
        return result;
    }

    /**
     * Calculate the product of 2 fractions
     *
     * @param rightHandSide right hand fraction
     * @return the product of 2 fractions
     */
    public Fraction multiply(Fraction rightHandSide) {
        // Create a variable to hold the result
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction(this.numerator * rightHandSide.numerator, this.denominator * rightHandSide.denominator);

        // Pass the resulting fraction back to the caller.
        return result;
    }

    /**
     * Calculate the quotient of 2 fractions
     *
     * @param rightHandSide right hand fraction
     * @return the quotient of 2 fractions
     */
    public Fraction divide(Fraction rightHandSide) {
        // Create a variable to hold the result
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction(this.numerator * rightHandSide.denominator, this.denominator * rightHandSide.numerator);

        // Pass the resulting fraction back to the caller.
        return result;
    }
    public double toDouble()
    {
        return (double)this.numerator / (double)this.denominator;

    }

}


