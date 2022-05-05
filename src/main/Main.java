package main;

import heros.Hero;
import menu.MainMenu;
import system.GameCore;


public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        Hero playerCharacter = menu.startMenu();
        GameCore game = new GameCore(menu, playerCharacter);
        game.playGame();
    }
}
