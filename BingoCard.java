// The purpose of this class is to represent a Bingo Game-Card. It provides a mechanism
// to manage the 'marking-off' of 4 digits.
//
// When creating a BingoCard, you must provide the 4 numbers to be 'on' the card.
//
// To mark off a number, use the 'markOff' method.
// To check whether all numbers are marked off, use the 'areAllMarkedOff' method.
// To get a String that shows which numbers remain, use the 'getRemaining' method.
public class BingoCard
{
    private int[] numbers;
    private boolean[] markedOff;
	private int max = 4;
	private int printed;
    public BingoCard(int first, int second, int third, int fourth)
    {
        numbers = new int[4];
        markedOff = new boolean[4];
        numbers[0] = first;
        numbers[1] = second;
        numbers[2] = third;
        numbers[3] = fourth;
        markedOff[0] = false;
        markedOff[1] = false;
        markedOff[2] = false;
        markedOff[3] = false;
    }
    // Method: markOff
    // Passed: number - a number to check for amongst the four in this card.
    // Purpose: Each of the numbers that make up this card are checked. If any match the
    // parameter, then the 'markedOff' value is set to true.
    public void markOff(int number)
    {
        int position;
        for (position = 0; position < 4; position++)
        {
            if (numbers[position] == number)
            {
                if (!markedOff[position])
					max--;
				markedOff[position] = true;
            }
        }
    }
    // Method: areAllMarkedOff
    // Purpose: To check whether all numbers on this card are marked off. If any are not
    // marked off, then false is returned. If all are marked off, true is returned.
    public boolean areAllMarkedOff()
    {
        int position;
        for (position = 0; position < 4; position++)
            if (markedOff[position] == false)
            	return false;
        return true;
    }
    // Purpose: Returns a string listing the numbers which remain (not yet marked off).
    public String getRemaining()
    {
        String result = "";
        int position; 
		printed = 1;
        for (position = 0; position < 4; position++)
        {
			if (!markedOff[position] && printed != max)
            {
				result += numbers[position] + ", ";
				printed++;
            }
			else if (!markedOff[position] && printed == max)
				result += numbers[position];
        }
        return result;
    }
}