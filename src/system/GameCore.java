package system;

import heros.Hero;
import menu.MainMenu;

import java.util.Scanner;

public class GameCore {
    private int tileNumber;
    private int currentPosition;
    private int turnCounter;
    private MainMenu gameMenu;
    private Hero heroPlayer;
    private Scanner userInput;

    public GameCore(MainMenu menu, Hero player) {
        this.gameMenu = menu;
        this.heroPlayer = player;
        this.tileNumber = 64;
        this.userInput = new Scanner(System.in);
    }

    public int throwDice() {
        int maxDiceValue = 6;
        int minDiceValue = 1;
        int diceResult = (int) Math.floor(Math.random() * (maxDiceValue - minDiceValue + 1) + minDiceValue);
        return diceResult;
    }

    public void playGame() {

        while (this.currentPosition < this.tileNumber) {
            gameMenu.turnStart(this.turnCounter, this.currentPosition, this.heroPlayer);
            int intChoice = gameMenu.getAnswerInt(this.userInput, 4);
            switch (intChoice) {
                case 1 -> {
                    this.turnCounter++;
                    int diceResult = this.throwDice();
                    this.currentPosition += diceResult;
                }
                case 2 -> System.out.println(this.heroPlayer);
                case 3 -> gameMenu.defineNewName(this.heroPlayer);
                case 4 -> System.exit(0);
            }
        }
        gameMenu.displayWinMessage();
    }


    public int getTileNumber() {
        return tileNumber;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getTurnCounter() {
        return turnCounter;
    }
}


