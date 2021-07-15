public class RandomPlayer implements Player
{
    private int[] myNumbers;
    private BingoCard b;
    public RandomPlayer()
    {
        myNumbers = new int[4];
    }
    public void chooseNumbers()
    {
        for (int i = 0; i < myNumbers.length; i++)
        {
            int value = (int) (Math.random() * 90) + 10;
            myNumbers[i] = value;
        }
        b = new BingoCard(myNumbers[0], myNumbers[1], myNumbers[2], myNumbers[3]);
        System.out.println("Random Player is set up");
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