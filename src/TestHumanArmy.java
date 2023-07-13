import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;

public class TestHumanArmy {
    private ArrayList<Human> testHumanSoldiers = new ArrayList<>();
    @Test
    public void testAddSoldier() {
        testHumanSoldiers.add(new Human("Super Soldier", 100, 20, 20, 5));
        assertThat(equalTo(testHumanSoldiers.get(0)),
                   equalTo(new Human("Super Soldier", 100, 20, 20, 5)));
    }
    @Test
    public void testGetHuman() {
        testHumanSoldiers.add(new Human("Super Soldier", 100, 20, 20, 5));
        assertThat(equalTo(testHumanSoldiers), equalTo(testHumanSoldiers.get(0)));
    }
    //Type: Human Race   Health: 96   Armor: 1   Damage: 5   Research per lvl: 5
    @Test
    public void testToString() {
        testHumanSoldiers.add(new Human("Super Soldier", 100, 20, 20, 5));
        assertThat(equalTo("Type: Super Soldier   Health: 100   " +
                                   "Armor: 20   Damage: 20   Research per lvl: 5"),
                                   equalTo(testHumanSoldiers.toString()));
    }
}
