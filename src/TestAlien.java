import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class TestAlien {
    private Alien testAlien = new Alien("Armed Alien", 5,  0, 1);
    @Test
    public void testSetHealth() {
        testAlien.setHealth(50);
        assertThat(50, equalTo(testAlien.getHealth()));
    }
    @Test
    public void testGetHealth() {
        assertThat(5,equalTo(testAlien.getHealth()));
    }
    @Test
    public void testSetArmor() {
        testAlien.setArmor(5);
        assertThat(5, equalTo(testAlien.getArmor()));
    }
    @Test
    public void testGetArmor() {
        assertThat(0,equalTo(testAlien.getArmor()));
    }
    @Test
    public void testSetDamage() {
        testAlien.setDamage(33);
        assertThat(33, equalTo(testAlien.getDamage()));
    }
    @Test
    public void testGetDamage() {
        assertThat(1, equalTo(testAlien.getDamage()));
    }
    @Test
    public void testSetType() {
        testAlien.setType("Rugged Soldier");
        assertThat(equalTo("Rugged Soldier"), equalTo(testAlien.getType()));
    }
    @Test
    public void testGetType() {
        assertThat(equalTo("Armed Alien"), equalTo(testAlien.getType()));
    }
    @Test
    public void testToString() {
        String one = new String("Type: " + "Armed Alien" + "   " + "Health: " + "5" + "   " + "Armor: " + "0" + "   " + "Damage: " +  "1" + "   " + "Research per lvl: " + "0");
        String two = new String("Type: " + testAlien.getType() + "   " + "Health: " + testAlien.getHealth() + "   " + "Armor: " + testAlien.getArmor() + "   " + "Damage: " +  testAlien.getDamage());
        assertThat(equalTo(one), equalTo(two));
    }
}
