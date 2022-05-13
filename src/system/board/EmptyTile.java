package system.board;

import heros.Hero;

public class  EmptyTile extends Tile{

    @Override
    public boolean interactWithPlayer(Hero player) {
        System.out.println("C'est une case vide olala pas très le fun avances hihi");
        return false;
    }
}
