import java.util.Scanner;
public class AliensVsHumans {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("You are a human at global war with aliens! You need to choose whether to out-think or out-fight." + "\n" + "A turn can either be for research which improves stats at the expense of being vulnerable to attack or choose to attack at the expense of losing research, and therefore combat benefits." + "\n" + "Get ready, strategize, and fight to save humanity!");
        try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
        System.out.println("Type 0 to continue.");
        int startInt = input.nextInt();
        AvHSimulator playerOne = new AvHSimulator(input);
        playerOne.startGame();
    }
}