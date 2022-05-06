package heros;

public class Magician extends Hero {
    private String spell;
    private String potion;

    //Default constructor
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
