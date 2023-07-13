import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAlienArmy {
    private ArrayList<Alien> testAlienSoldiers = new ArrayList<>();
    @Test
    public void testAddSoldier() {
        testAlienSoldiers.add(new Alien("Super Soldier", 100, 20, 20));
        assertThat(equalTo(testAlienSoldiers.get(0)),
                   equalTo(new Alien("Super Soldier", 100, 20, 20)));
    }
    @Test
    public void testGetAlien() {
        testAlienSoldiers.add(new Alien("Super Soldier", 100, 20, 20));
        assertThat(equalTo(testAlienSoldiers), equalTo(testAlienSoldiers.get(0)));
    }
    @Test
    public void testToString() {
        testAlienSoldiers.add(new Alien("Super Soldier", 100, 20, 20));
        assertThat(equalTo("Type: Super Soldier   Health: 100   Armor: 20   Damage: 20"),
                   equalTo(testAlienSoldiers.toString()));
    }
}
