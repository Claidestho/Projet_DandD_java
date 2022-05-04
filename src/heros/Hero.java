package heros;

public abstract class Hero {
    public String name;
    private int healthPoints;
    private int attackPoints;

    public String showCharacterStats() {
        return "Nom : " + this.name + "\nPoints de vie : " + this.getHealthPoints() + "\nPuissance : " + this.getAttackPoints();
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
}
