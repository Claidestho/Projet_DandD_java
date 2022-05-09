package heros;

public class Warrior extends Hero {
    private String weapon;
    private String shield;

    /**
     * The default constructor permit to generate a new character with a default name and empty stats.
     */
    public Warrior() {
        this("Gerard");
    }

    public Warrior(String name) {
        this(name, 5, 5);
    }

    public Warrior(String name, int healthPoints, int attackPoints) {
        super(name, healthPoints, attackPoints);
    }


}
