package main;

import heros.Hero;
import menu.MainMenu;
import system.GameCore;
import system.database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection db = new DatabaseConnection();
        db.listHeroesFromDB(db.executeQueries( "SELECT * FROM hero"));

        MainMenu menu = new MainMenu();
        Hero playerCharacter = menu.startMenu();
        GameCore game = new GameCore(menu, playerCharacter);
        game.playGame();
    }
}
