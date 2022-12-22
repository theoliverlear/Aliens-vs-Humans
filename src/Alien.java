public class Alien {
    //abilities array
    String type = "";
    int gold = 0;
    int research = 0;
    int level = 1;
    int health = 0;
    int armor;
    int damage;
    public Alien(String type, int health, int armor, int damage) {
        this.type = type;
        this.health = health;
        this.armor = armor;
        this.damage = damage;
    }
    public int getArmor() {
        return armor;
    }
    public int getHealth() {
        return health;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return "Type: " + this.type + "   " + "Health: " + this.health + "   " + "Armor: " + this.armor + "   " + "Damage: " +  this.damage;
    }

    public void alienLvlUp(int amount) {
        if(research + amount >= 100) {
            level++;
        } else {
            research += amount;
        }
    }
}
