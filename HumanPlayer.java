import java.util.Scanner;
public class HumanPlayer implements Player
{
    private int[] myNumbers;
    private BingoCard b;
    private Scanner scan;
    public HumanPlayer()
    {
        myNumbers = new int[4];
        scan = new Scanner(System.in);
    }
    public void chooseNumbers()
    {
        int i = 0;
		int value = 0;
        System.out.print("\nHuman Player:");
		while (i < myNumbers.length)
        {
            System.out.print("\nEnter 4 digits between 10 and 99 for your bingo card\n" + "Value " + (i+1) + ": ");
            try
			{
				value = scan.nextInt();
			}
			catch (java.util.InputMismatchException ime)
			{
				new java.util.InputMismatchException();
				value = 0;
				scan = new Scanner(System.in);
			}
            if(value >= 10 && value < 100)
            {    
                myNumbers[i] = value;
                i++;
            }
            else
                System.out.println("Please enter a number between 10 and 99");
        }
        b = new BingoCard(myNumbers[0], myNumbers[1], myNumbers[2], myNumbers[3]);
        System.out.println("Human Player is set up\n");
    }
    public void checkForNumber(int number)
    {
        b.markOff(number);
    }
    public void printRemaining()
    {
        System.out.println(b.getRemaining());
    }
    public boolean checkIfWon()
    {
        return b.areAllMarkedOff();
    }
}