public class Human {
    String type = "";
    int research = 0;
    int level = 0;
    int health = 0;
    int armor = 0;
    int damage = 0;
    int researchPerLevel = 5;

    public Human(String type, int health, int armor, int damage, int researchPerLevel) {
        this.type = type;
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        this.researchPerLevel = researchPerLevel;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public int getArmor() {
        return armor;
    }
    public void setResearch(int research) {
        this.research = research;
    }
    public int getResearch() {
        return research;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getResearchPerLevel() {
        return researchPerLevel;
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return "Type: " + this.type + "   " + "Health: " + this.health + "   " + "Armor: " + this.armor + "   " + "Damage: " +  this.damage + "   " + "Research per lvl: " + this.researchPerLevel;
    }
    public void setResearchPerLevel(int researchPerLevel) {
        this.researchPerLevel = researchPerLevel;
    }
    public void humanLvlUp(int amount) {
        if(research + amount >= 20) {
            level++;
            System.out.println("Level up! You are now level " + level + ".");
            hLvlCheck();
        } else {
            research += amount;
            System.out.println("Research: " + research + "/20");
        }
    }
    public void hLvlCheck() {
        switch (level) {
            case 1:
                setArmor(getArmor() + 1);
                System.out.println("You discover that snow and swamp conditions weaken the aliens. Utilizing this, your armor increases by 1.");
                break;
            case 2:
                setHealth(getHealth() + 20);
                setResearchPerLevel(getResearchPerLevel() + 5);
                System.out.println("You manage a deal with the United Nations for a global effort. Your reinforcements grant you 20 health and 5 bonus research per turn.");
                break;
            case 3:
                setArmor(getArmor() + 2);
                System.out.println("You discover that the aliens use the Sun as a power source. You now fight better in nighttime conditions. Defense: + 2.");
                break;
            case 4:
                setArmor(getArmor() + 2);
                setDamage(getDamage() + 5);
                System.out.println("Your research discovered a more evolved projectile weapon - the laser blaster. With this, you also learned how to protect yourself from laster projectiles. Armor has increased by 2 and damage has increaded by 5.");
                break;
            case 5:
                setDamage(getDamage() + 5);
                System.out.println("Max Level: Your research discovered that water is fatal to the aliens. Utilizing this increased your damage by 5.");
                break;
        }
    }
}
