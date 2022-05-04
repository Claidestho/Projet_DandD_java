package main;
import system.GameCore;
import heros.Hero;
import menu.MainMenu;


public class Main {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        Hero playerCharacter = menu.startMenu();
        GameCore game = new GameCore();
        menu.displaySeparator();
        menu.displayGameStart(playerCharacter, game);


    }
}
