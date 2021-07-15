import java.util.ArrayList;
public abstract class Announcer
{
    public ArrayList<Player> players;
    public Announcer()
    {
        players = new ArrayList<Player>();
    }
    public abstract void chooseNextNumber();
    public void addNewPlayer(Player p)
    {
        players.add(p);
    }
    public void announceNextNumber(int number)
    {
        for(Player p: players)
            p.checkForNumber(number);
    }
}
