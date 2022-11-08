import java.util.Scanner;
import java.util.Random;


public class DiceStats
{
    public static void main(String[] args)
    {
        int numOfDice, numOfRolls, maxSize, sum, randNum = 0;
        int[] rollSums;
        Random random = new Random();

        Scanner s = new Scanner(System.in);

        System.out.print("How many dice will constitute one roll? ");
        numOfDice = s.nextInt();

        System.out.print("How many rolls? ");
        numOfRolls = s.nextInt();

        maxSize = numOfDice * 6;
        rollSums = new int[maxSize + 1];

        for (int i = 0; i < numOfRolls; i++)
        {
            sum = 0;

            for (int j = 0; j < numOfDice; j++)
            {
                randNum = random.nextInt(6) + 1;
                sum += randNum;
            }

            rollSums[sum] = rollSums[sum] + 1;

        }

        System.out.println("Sum \t # of times \t Percentage");
        for(int i = numOfDice; i < maxSize + 1; i++)
        {
            System.out.printf("%-9d", i);
            System.out.printf("%-15d", rollSums[i]);
            double column = rollSums[i];
            double percent = ((column / numOfRolls)*100.0);
            System.out.printf("%.2f", percent);
            System.out.println("%");
        }

        s.close();

    }
}
