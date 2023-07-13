import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class TestHuman {
    private Human testHuman = new Human("Armed Civilian", 5,  0, 1, 0);
    @Test
    public void testSetHealth() {
        testHuman.setHealth(50);
        assertThat(50, equalTo(testHuman.getHealth()));
    }
    @Test
    public void testGetHealth() {
        assertThat(5,equalTo(testHuman.getHealth()));
    }
    @Test
    public void testSetArmor() {
        testHuman.setArmor(5);
        assertThat(5, equalTo(testHuman.getArmor()));
    }
    @Test
    public void testGetArmor() {
        assertThat(0,equalTo(testHuman.getArmor()));
    }
    @Test
    public void testSetDamage() {
        testHuman.setDamage(33);
        assertThat(33, equalTo(testHuman.getDamage()));
    }
    @Test
    public void testGetDamage() {
        assertThat(1, equalTo(testHuman.getDamage()));
    }
    @Test
    public void testSetResearchPerLevel() {
        testHuman.setResearchPerLevel(10);
        assertThat(10, equalTo(testHuman.getResearchPerLevel()));
    }
    @Test
    public void testGetResearchPerLevel() {
        assertThat(0, equalTo(testHuman.getResearchPerLevel()));
    }
    @Test
    public void testSetType() {
        testHuman.setType("Rugged Soldier");
        assertThat(equalTo("Rugged Soldier"), equalTo(testHuman.getType()));
    }
    @Test
    public void testGetType() {
        assertThat(equalTo("Armed Civilian"), equalTo(testHuman.getType()));
    }
    @Test
    public void testSetLevel() {
        testHuman.setLevel(100);
        assertThat(100, equalTo(testHuman.getLevel()));
    }
    @Test
    public void testSetResearch() {
        testHuman.setResearch(50);
        assertThat(50, equalTo(testHuman.getResearch()));
    }
    @Test
    public void testGetResearch() {
        assertThat(0, equalTo(testHuman.getResearch()));
    }
    @Test
    public void testGetLevel() {
        assertThat(0, equalTo(testHuman.getLevel()));
    }
    @Test
    public void testToString() {
        String one = "Type: " + "Armed Civilian" + "   " + "Health: " + "5" +
                "   " + "Armor: " + "0" + "   " + "Damage: " + "1" + "   " +
                "Research per lvl: " + "0";
        String two = "Type: " + testHuman.getType() + "   " + "Health: " +
                testHuman.getHealth() + "   " + "Armor: " + testHuman.getArmor()
                + "   " + "Damage: " + testHuman.getDamage() + "   " + "Research" +
                " per lvl: " + testHuman.getResearchPerLevel();
        assertThat(equalTo(one), equalTo(two));
    }
    @Test
    public void testLvlCheck() {
        testHuman.setLevel(1);
        testHuman.hLvlCheck();
        assertThat(1, equalTo(testHuman.getArmor()));
        testHuman.setLevel(2);
        testHuman.hLvlCheck();
        assertThat(25, equalTo(testHuman.getHealth()));
        assertThat(5, equalTo(testHuman.getResearchPerLevel()));
        testHuman.setLevel(3);
        testHuman.hLvlCheck();
        assertThat(3, equalTo(testHuman.getArmor()));
        testHuman.setLevel(4);
        testHuman.hLvlCheck();
        assertThat(5, equalTo(testHuman.getArmor()));
        assertThat(6, equalTo(testHuman.getDamage()));
        testHuman.setLevel(5);
        testHuman.hLvlCheck();
        assertThat(11, equalTo(testHuman.getDamage()));
    }
    @Test
    public void testHumanLvlUp() {
        testHuman.setResearch(15);
        testHuman.humanLvlUp(10);
        assertThat(1, equalTo(testHuman.getLevel()));
        testHuman.humanLvlUp(15);
        assertThat(2, equalTo(testHuman.getLevel()));
    }
}
