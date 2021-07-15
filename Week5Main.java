import java.util.Scanner;
public class Week5Main
{
    private Announcer theAnnouncer;
    private Player[] players;
    private Scanner scan;
    private boolean playAgain;
    public Week5Main()
    {
        scan = new Scanner(System.in);
    }
    // Method: start
    // Purpose: Starts the main program's key processing loop. The loop continues until
    // the user says they don't want to play any more rounds. Each round starts
    // by setting up the configuration of the announcer and players, and then
    // the round is played.
    public void start()
    {
        int curRound = 0;
        char response;
        playAgain = true;
        while (playAgain)
        {
            curRound++;
            System.out.println("Round "+curRound);
            newRound();
            System.out.println("Round Begins...");
            playRound();
			boolean proceed = true;
            while (proceed)
			{
				System.out.println("\nPlay another round?\n'Y' or 'N'");
           	 	try
				{
					response = scan.nextLine().toUpperCase().charAt(0);
				}
				catch (StringIndexOutOfBoundsException sioobe)
				{
					new StringIndexOutOfBoundsException();
					response = 'x';
				}
            	switch (response)
            	{
			    	case 'Y':
						playAgain = true;
						proceed = false;
						break;
					case 'N':
						playAgain = false;
						proceed = false;
						System.exit(0);
						break;
					default: 
						System.out.println("Please Enter 'Y' or 'N'");
				}
			}
        }
    }
    // Method: playRound
    // Purpose: Controls the logic for one round of the Bingo game. It will run until
    // either a person wins the round, or until 25 numbers have been announced.
    // The status of each player's bingo card is to be reported before the
    // Announcer chooses a number. After the announcer chooses a number,
    // the callbacks in the player classes will respond to mark numbers off their
    // playing card. Finally, a check is made to see if there is a player who has
    // won with the most recent number having been announced.
    public void playRound()
    {
        boolean gameOver = false;
        int i;
        int totalNumbers = 0;
        while (!(gameOver || totalNumbers >= 25))
        {
            // show status
            for (i = 0; i < players.length; i++)
            {
				System.out.print("Player " + (i+1) + ":\tNumbers Remaining: ");
                players[i].printRemaining();
			}
            // ************ For students to do ***************
            // choose number
            // INSERT CODE TO CAUSE THE ANNOUNCER TO CHOOSE NEXT NUMBER
			if (totalNumbers != 24)
				theAnnouncer.chooseNextNumber();
            // Check to see if any player has won yet...
            for (i = 0; i < players.length; i++)
            {
                // INSERT CODE TO CHECK FOR WINNER, AND IF SO, END THIS ROUND.
				if(players[i].checkIfWon())
				{
					gameOver = true;
				}	
            }
			if(gameOver)
			{
				for (i = 0; i < players.length; i++)
				{
					if (!players[i].checkIfWon())
					{
						System.out.print("Player " + (i+1) + ":\tNumbers Remaining: ");
                		players[i].printRemaining();
					}
					else
						System.out.println("Player " + (i+1) + ":\tBingo!!!!");
				}
			}
        }
    }
    // Method: newRound
    // Purpose: To set up ready for a new round. It allows the user to select which kind of
    // announcer to use. The default implementation assumes a
    // RandomAnnouncer. It then asks the user to specify the players for the round.
    public void newRound()
    {
        System.out.println("Which type of Announcer do you want?");
        System.out.println("1. the Random Announcer");
        System.out.println("2. the Manually-Controlled Announcer");
        
        int response = getUserSelection(1,2);
        if (response == 1)
        	theAnnouncer = new RandomAnnouncer();
        else
        	theAnnouncer = new ManualAnnouncer();
 
        System.out.println("Now to set the players for this round.");
        players = new Player[2];
		players[0] = new RandomPlayer(); 	
		players[1] = new HumanPlayer();
        // Cause the players to choose their numbers for this round...
		players[0].chooseNumbers();
        players[1].chooseNumbers();
        // ************ For students to do ***************
        // Ensure that the players are 'subscribed' to the announcer for this round.
		theAnnouncer.addNewPlayer(players[0]);
		theAnnouncer.addNewPlayer(players[1]);
    }
    // METHOD: getUserSelection
    // PURPOSE: To obtain from the user a selection (an integer) from a range of values
    // PASSED:
    // lower - the Lowest permissible value the user can enter as their selection.
    // upper - the Highest permissible value the user can enter
    // RETURNS:
    // The value entered by the user, unless the "lower" parameter was higher
    // than the "upper" parameter, in which case 0 is returned.
    // EFFECTS:
    // A prompt is displayed on the screen to ask the user for a value in the range.
    // Input is sought from the user via the keyboard (System.in)
    public int getUserSelection(int lower, int upper)
    {
        int userInput;
        if (lower > upper)
            return 0;
        do {
            System.out.print("Enter a selection ("+lower + "-" + upper+"):");
            try
			{
				userInput = scan.nextInt();
			}
			catch (java.util.InputMismatchException ime)
			{
				new java.util.InputMismatchException();
				userInput = 99;
			}
            scan.nextLine();
            if (userInput < lower || userInput > upper)
                System.out.println("Invalid choice.");
        } while (userInput < lower || userInput > upper);
        System.out.println();
        return userInput;
    }
    public static void main(String[] args)
    {
        Week5Main mainProgram = new Week5Main();
        mainProgram.start();
    }
}