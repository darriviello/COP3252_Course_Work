import java.util.Scanner;
import java.lang.Math;

public class Reverse
{
    public static long reverseDigits(long x)
    {
        long reversedNum = 0;
        long remainder;

        while (x != 0)
        {
            remainder = x % 10;
            reversedNum = (reversedNum * 10) + remainder;
            x /= 10;
        }
        return reversedNum;
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long input;

        do {
            System.out.print("Please enter a long integer (0 to quit): ");
            input = s.nextLong();

            if (input == 0)
                System.out.println("Goodbye!");
            else
                System.out.println("The number reversed is: " + reverseDigits(input));
        }while (input != 0);


    }
}
