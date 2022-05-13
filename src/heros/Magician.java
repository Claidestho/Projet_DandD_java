package heros;

public class Magician extends Hero {

    /**
     * The default constructor permit to generate a new character with a default name and empty stats.
     */
    public Magician() {
        this("Gandalf");
    }

    public Magician(String name) {
        this(name, 3, 8, 15, 6);
    }

    public Magician(String name, int healthPoints, int attackPoints, int maxAttack, int maxHealth) {
        super(name, healthPoints, attackPoints, maxAttack, maxHealth);
    }

}
