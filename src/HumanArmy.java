import java.util.ArrayList;
public class HumanArmy {
    private ArrayList<Human> humanSoldiers = new ArrayList<>();
    public HumanArmy() {
        humanSoldiers.add(new Human("Human Race", 100, 1, 5, 5));
    }

    @Override
    public String toString() {
        String printSoldiers = null;
        for (Human human : humanSoldiers) {
            printSoldiers = human.toString();
        }
        return printSoldiers;
    }
    public Human getHuman() {
        return humanSoldiers.get(0);
    }

}
