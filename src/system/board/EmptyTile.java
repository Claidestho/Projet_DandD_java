package system.board;

import heros.Hero;

public class  EmptyTile extends Tile{

    @Override
    public boolean interactWithPlayer(Hero player) {
        System.out.println("Noting here, go on");
        return false;
    }
}
