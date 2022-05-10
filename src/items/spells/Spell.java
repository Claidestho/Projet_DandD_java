package items.spells;

import heros.Hero;
import system.board.Tile;

public abstract class Spell extends Tile {
    private String name;
    private int power;

    public Spell(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean interactWithPlayer(Hero player) {
        player.upgradeAttack(this.power);
        return false;
    }
}
