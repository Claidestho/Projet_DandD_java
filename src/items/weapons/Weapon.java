package items.weapons;

import heros.Hero;
import system.board.Tile;

public abstract class Weapon extends Tile {
    private String name;
    private int strength;

    public Weapon(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean interactWithPlayer(Hero player) {
        player.upgradeAttack(this.getStrength());
        return false;
    }
}
