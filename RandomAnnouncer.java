public class RandomAnnouncer extends Announcer
{
    public void chooseNextNumber()
    {
        int value = (int) (Math.random() * 90) + 10;
        announceNextNumber(value);
        System.out.println("\nAnnounced: " + value);
    }
}