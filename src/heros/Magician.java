package heros;

public class Magician extends Hero {
    private String spell;
    private String potion;

    /**
     * The default constructor permit to generate a new character with a default name and empty stats.
     */
    public Magician() {
        this("Gandalf");
    }

    public Magician(String name) {
        this(name, 3, 8);
    }

    public Magician(String name, int healthPoints, int attackPoints) {
        super(name, healthPoints, attackPoints);
    }

}
