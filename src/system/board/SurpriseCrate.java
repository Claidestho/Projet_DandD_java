package system.board;

import heros.Hero;

public class SurpriseCrate extends Tile {
    @Override
    public boolean interactWithPlayer(Hero player) {
        int randomNumber = (int)Math.random();
        return false;
    }
}
