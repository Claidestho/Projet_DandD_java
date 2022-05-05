package heros;

public class Magician extends Hero {

    private String spell;
    private String potion;

    //Default constructor
    public Magician() {
        this.name = "Default";
        this.setHealthPoints(6);
        this.setAttackPoints(15);
    }

    public Magician(String name) {
        this.name = name;
        this.setHealthPoints(3);
        this.setAttackPoints(8);
    }

    public Magician(String name, int healthPoints, int attackPoints, String spell, String potion) {
        this.name = name;
        this.setHealthPoints(healthPoints);
        this.setAttackPoints(attackPoints);
        this.spell = spell;
        this.potion = potion;
    }

}
