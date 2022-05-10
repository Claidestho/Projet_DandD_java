package system.board;

import heros.Hero;

public abstract class Tile {

    protected boolean is;

    public abstract  boolean interactWithPlayer(Hero player);

}
