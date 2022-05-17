package system.board;

import heros.Hero;

public abstract class Tile {
    protected String name;
    public abstract boolean interactWithPlayer(Hero player);

    @Override
    public String toString() {
        return this.name;
    }
}
