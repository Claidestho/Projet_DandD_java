package heros;

public class Warrior extends Hero {
    private String weapon;
    private String shield;

    //Default constructor
    public Warrior() {
        this.setName("Defaut");
        this.setHealthPoints(10);
        this.setAttackPoints(10);
    }

    public Warrior(String name) {
        this.setName(name);
        this.setHealthPoints(5);
        this.setAttackPoints(5);
    }

    public Warrior(String name, int healthPoints, int attackPoints) {
        this.setName(name);
        this.setHealthPoints(healthPoints);
        this.setAttackPoints(attackPoints);
    }

    @Override
    public String toString() {
        return "classes.Warrior{" +
                "name='" + this.getName() + '\'' +
                ", healthPoints=" + this.getHealthPoints() +
                ", attackPoints=" + this.getAttackPoints() +
                ", weapon='" + weapon + '\'' +
                ", shield='" + shield + '\'' +
                '}';
    }


}
