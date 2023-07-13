import java.util.Scanner;
public class AliensVsHumans {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                You are a human at global war with aliens! You need to choose whether to out-think or out-fight.
                A turn can either be for research which improves stats at the expense of being vulnerable to\s
                attack or choose to attack at the expense of losing research, and therefore combat benefits.
                Get ready, strategize, and fight to save humanity!""");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int startInt;
        do {
            System.out.println("Type 0 to continue.");
            startInt = input.nextInt();
        } while (startInt != 0);
        AvHSimulator playerOne = new AvHSimulator(input);
        playerOne.startGame();
    }
}