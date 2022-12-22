import java.util.ArrayList;

public class AlienArmy {
    private ArrayList<Alien> alienSoldiers = new ArrayList<>();
    public AlienArmy() {
        alienSoldiers.add(new Alien("Alien Race", 100, 2, 5));
    }

    @Override
    public String toString() {
        String printSoldiers = null;
        for (Alien alien : alienSoldiers) {
            printSoldiers = alien.toString();
        }
        return printSoldiers;
    }
    public Alien getAlien() {
        return alienSoldiers.get(0);
    }

}
