import java.util.Scanner;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;

public class TestAvHSimulator {
    int round = 1;
    Scanner input = new Scanner(System.in);
    AvHSimulator simulator = new AvHSimulator(input);
    AlienArmy testAlienArmy = new AlienArmy();
    HumanArmy testHumanArmy = new HumanArmy();
    @Test
    public void testAIsDead() {
        testAlienArmy.getAlien().setHealth(0);
        assertThat(true, equalTo(simulator.aIsDead()));
    }
    @Test
    public void testHIsDead() {
        testHumanArmy.getHuman().setHealth(0);
        assertThat(true, equalTo(simulator.hIsDead()));
    }
    @Test
    public void testRoundCounter() {
        round = 1;
        simulator.roundCounter();
        assertThat(2, equalTo(round));
    }
}
