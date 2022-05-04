package main;
import system.GameCore;
import heros.Hero;
import menu.MainMenu;


public class Main {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        GameCore game = new GameCore(menu);
        Hero playerCharacter = menu.startMenu();
        menu.displaySeparator();
        menu.displayGameStart(playerCharacter, game);
        game.playTurn(menu);


    }
}
