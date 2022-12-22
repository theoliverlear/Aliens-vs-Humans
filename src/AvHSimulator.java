import java.util.Scanner;

public class AvHSimulator {
     int round = 1;
     Scanner input = new Scanner(System.in);
     private HumanArmy humanArmy = new HumanArmy();
     private AlienArmy alienArmy = new AlienArmy();
     public AvHSimulator(Scanner input) {
         this.input = input;
     }
     public void roundCounter() {
        System.out.println("Round: " + round);
        round++;
    }
    public void turnCounter() {
        int turn = 2;
        if(turn % 2 == 0) {
            try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
            System.out.println("Alien's Turn");
            turn++;
        } else if(turn % 2 == 1) {
            try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
            System.out.println("Human's Turn");
            turn++;
        }
    }
    public void endGame() {
         if(aIsDead()) {
             System.out.println("You defeated the alien invasion!");
         } else if(hIsDead()) {
             System.out.println("You lose to the alien invasion!");
         }
    }
    public boolean aIsDead() {
         if(alienArmy.getAlien().getHealth() <= 0) {
             return true;
         } else {
             return false;
         }
    }
    public boolean hIsDead() {
         if(humanArmy.getHuman().getHealth() <= 0) {
             return true;
         } else {
             return false;
         }
    }
    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
        System.out.println(userInputPrompt);
        T temp_T = null;
        int userInt = input.nextInt();
        try {
            temp_T = intUserInputRetriever.produceOutputOnIntUserInput(userInt);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Illegal Argument Exception. " + userInt + " is unacceptable.");
        }
        return temp_T;
    }
    public void viewStats() {
                     System.out.println(humanArmy.toString());
        try {Thread.sleep(500);} catch (InterruptedException e) { throw new RuntimeException(e);}
                     System.out.println(alienArmy.toString());
    }
    public boolean humanTurn() {
        try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
        String userPrompt = ("Please input 2 to use your resources for an attack or 1 to conduct research. ");
        System.out.println("Press 1 to see stats or 0 to continue.");
        int userInt = input.nextInt();

        while(userInt == 1) {
            viewStats();
            try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
            System.out.println("Press 1 to see stats or 0 to continue.");
            userInt = input.nextInt();
        }
        boolean[] shouldAtk = new boolean[1];
        IntUserInputRetriever<?> intUserInputRetriever = (int selection) -> {

            if(selection == 2){
                int effectiveDamage = humanArmy.getHuman().getDamage() - alienArmy.getAlien().getArmor();
                if(effectiveDamage < 0) {
                    effectiveDamage = 0;
                }
                alienArmy.getAlien().setHealth(alienArmy.getAlien().getHealth() - effectiveDamage);
                System.out.println(selection + ": Attack chosen. You attack with " + humanArmy.getHuman().getDamage() + " damage. The alien's have " + alienArmy.getAlien().getArmor() + " armor - you did "  + effectiveDamage + " effective damage.");
                try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e); }
                if(aIsDead()) {
                    alienArmy.getAlien().setHealth(0);
                }
                System.out.println("The aliens now have " + alienArmy.getAlien().getHealth() + " health.");
                try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
                shouldAtk[0] = true;
            } else if (selection == 1) {
                System.out.println(selection + ": Research chosen. You increase " + humanArmy.getHuman().getResearchPerLevel()+ " research points.");
                try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
                humanArmy.getHuman().humanLvlUp(5);
                try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
                //function to check human level + level up - maybe extends?
                shouldAtk[0] = false;
            }
            else {
                throw new IllegalArgumentException(selection + ": Required input not met - terminating. Try again.");
            }
            return shouldAtk[0];};
        getOutputOnIntInput(userPrompt, intUserInputRetriever);
        return shouldAtk[0];
    }

    public void alienTurn() {
        try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
         int effectiveDamage = alienArmy.getAlien().getDamage() - humanArmy.getHuman().getArmor();
        if(effectiveDamage < 0) {
            effectiveDamage = 0;
        }
        humanArmy.getHuman().setHealth(humanArmy.getHuman().getHealth() - effectiveDamage);
        System.out.println("The alien's attack with " + alienArmy.getAlien().getDamage() + " damage. The humans's have " + humanArmy.getHuman().getArmor() + " armor - they did "  + effectiveDamage + " effective damage.");
        if(!hIsDead()){

            try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e); }
            if(humanArmy.getHuman().getHealth() == 0) {
                humanArmy.getHuman().setHealth(0);
            }
            System.out.println("You now have " + humanArmy.getHuman().getHealth() + " health.");
            try {Thread.sleep(1000);} catch (InterruptedException e) { throw new RuntimeException(e);}
        } else if(hIsDead()){

            System.out.println("The human race loses the battle for Earth!");
        }
    }
    public void startGame() {
        while(!hIsDead() && !aIsDead()){
            roundCounter();
            turnCounter();
            if(!hIsDead() && !aIsDead()) {
                alienTurn();
            } else {
                break;
            } if(!hIsDead() && !aIsDead()) {
                humanTurn();
            } else {
                break;
            }
        }
        endGame();
     }
}
