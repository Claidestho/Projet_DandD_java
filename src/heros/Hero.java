package heros;

import items.potions.Potion;
import items.weapons.Weapon;

/**
 * Abstract class parent of the classes Warrior and Magician. The Hero constructor is used by both of them.
 */
public abstract class Hero {
    private String name;
    private int healthPoints;
    private int attackPoints;

    private Weapon weapon;
    private Potion potion;

    protected Hero(String name, int healthPoints, int attackPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
    }

    /**
     * This method is used to show the stats sheet of the player character. It will be used by all Hero's children.
     * @return
     */
    @Override
    public String toString() {
        return "**********************\nSTATISTIQUES\nNom : " + name +
                "\nPoints de vie : " + healthPoints +
                "\nPuissance : " + attackPoints + "\n**********************";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void upgradeHealth(int amount){
        this.healthPoints += amount;
    }

    public void upgradeAttack(int amount){
        this.attackPoints += amount;
    }
}
