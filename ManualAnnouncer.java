import java.util.Scanner;
public class ManualAnnouncer extends Announcer
{
    private Scanner scan;
    public ManualAnnouncer()
    {
        scan = new Scanner(System.in);
    }
    public void chooseNextNumber()
    {
        boolean announced = false;
        do
        {
            System.out.println("\nEnter a number to announce");
            int value = scan.nextInt();
            if (value >= 10 && value < 100)
            {
                announceNextNumber(value);
                announced = true;
                System.out.println("\nAnnounced: " + value);
            }
            else
                System.out.println("Choose a number between 10 and 99 to announce! Now an announcement was wasted :(");
        } while (!announced);
    }
}