package heros;

public class Warrior extends Hero {

    /**
     * The default constructor permit to generate a new character with a default name and empty stats.
     */
    public Warrior() {
        this("Gerard");
    }

    public Warrior(String name) {
        this(name, 5, 5, 10, 10);
    }

    public Warrior(String name, int healthPoints, int attackPoints, int maxAttack, int maxHealth) {
        super(name, healthPoints, attackPoints, maxAttack, maxHealth);
    }


}
