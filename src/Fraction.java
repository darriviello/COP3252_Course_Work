public class Fraction
{
    private int numerator = 0;		// numerator (and keeps sign)
    private int denominator = 1;		// always stores positive value
    private boolean negative = false;

    public int gcd(int a, int b)
    {
        while ( b > 0)
        {
            int temp = b;
            b = ( a % b );
            a = temp;
        }

        return a;
    }

    public Fraction()
    {
    }

    public Fraction(int n, int d)
    {
        if (set(n,d)==false)
            set(0,1);
    }

    public boolean set(int n, int d)
    {
        if (d > 0)
        {
            numerator = n;
            denominator = d;
            return true;
        }
        else
            return false;
    }

    public String toString()
    {
        return (numerator + "/" + denominator);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public double decimal()
    {
        return (double)numerator / denominator;
    }

    public Fraction simplify()
    {
        Fraction simplifiedFac = new Fraction();
        int temp;

        if (numerator < 0)
        {
            numerator = numerator * -1;
            negative = true;
        }

        if (numerator < denominator)
        {
            temp = gcd(denominator, numerator);
        }
        else if (denominator < numerator)
        {
            temp = gcd(numerator, denominator);
        }
        else
            temp = numerator;

        if (negative)
        {
            numerator = numerator * -1;
            negative = false;
        }

        simplifiedFac.numerator = numerator / temp;
        simplifiedFac.denominator = denominator / temp;

        if (numerator == 0)
        {
            simplifiedFac.numerator = 0;
            simplifiedFac.denominator = 1;
        }

        return simplifiedFac;
    }
    public Fraction add(Fraction f)
    {
        Fraction addFrac = new Fraction();
        addFrac.numerator = (this.numerator * f.denominator) + (this.denominator * f.numerator);
        addFrac.denominator = this.denominator * f.denominator;
        return addFrac.simplify();
    }
    public Fraction subtract(Fraction f)
    {
        Fraction subFrac = new Fraction();
        subFrac.numerator = (this.numerator * f.denominator) - (this.denominator * f.numerator);
        subFrac.denominator = this.denominator * f.denominator;
        return subFrac.simplify();
    }
    public Fraction multiply(Fraction f)
    {
        Fraction multiFrac = new Fraction();
        multiFrac.numerator = this.numerator * f.numerator;
        multiFrac.denominator = this.denominator * f.denominator;
        return multiFrac.simplify();
    }
    public Fraction divide(Fraction f)
    {

        Fraction divFrac = new Fraction();
        divFrac.numerator = this.numerator * f.denominator;
        divFrac.denominator = this.denominator * f.numerator;
        if ( divFrac.denominator < 0 )                                     // checking if new denominator is negative and switching signs
        {
            divFrac.numerator = (divFrac.numerator * -1);
            divFrac.denominator = (divFrac.denominator * -1);
        }
        if (this.numerator == 0 || f.numerator == 0)
        {
            divFrac.numerator = 0;
            divFrac.denominator = 1;
            return divFrac;
        }

        return divFrac.simplify();
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(4,6);
        Fraction f2 = new Fraction(75,175);
        Fraction f3 = new Fraction(-6,17);

        System.out.println(f1 + " simplified = " + f1.simplify());
        System.out.println(f2 + " simplified = " + f2.simplify());
        System.out.println(f3 + " simplified = " + f3.simplify());

        // show that f1, f2, f3 haven't changed
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);

        // arithmetic
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        System.out.println();

        System.out.println(f2 + " + " + f3 + " = " + f2.add(f3));
        System.out.println(f2 + " - " + f3 + " = " + f2.subtract(f3));
        System.out.println(f2 + " * " + f3 + " = " + f2.multiply(f3));
        System.out.println(f2 + " / " + f3 + " = " + f2.divide(f3));
        System.out.println();

        // test 'division by zero' handling
        Fraction zero = new Fraction();
        System.out.println(f2 + " / " + zero + " = " + f2.divide(zero));
    }
}
