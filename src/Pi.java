import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Pi
{
    public static void main(String[] args)
    {
        int numOfTerms;
        double pi = 0;
        Scanner s = new Scanner(System.in);

        System.out.print("Compute to how many terms of the series? ");
        numOfTerms = s.nextInt();

        System.out.println("terms \t PI Approximation");

        for (double i = 1; i <= numOfTerms; i++)
        {
            if (i % 2 == 0)
            {
                pi -= (4 / ((i * 2) - 1));
            }
            else
            {
                pi += (4 / ((i * 2) - 1));
            }

            System.out.printf("%.0f \t" + pi + "\n", i);
        }
    }
}