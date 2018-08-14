import java.util.Comparator;

public class LastNameComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if(p1.getLastName().compareTo(p2.getLastName()) > 0)
            return 1;
        if(p1.getLastName().compareTo(p2.getLastName()) < 0)
            return -1;
        return 0;
    }
}
