package system;

import heros.Hero;
import menu.MainMenu;
import system.exceptions.OutOfBoundException;

import java.util.Scanner;

/**
 * This class handle all the logic of the game. Need to put all the display in the MainMenu class.
 */
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

    /**
     * This function handle all the logic of the game for now. It permit the user to throw the dice, view his character stats sheet, rename his character and quit the game.
     */
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

        try {
            getOOBException(this.currentPosition);

        } catch (OutOfBoundException e) {
            System.out.println("ERREUR : Limites du plateau dépassées, vous avez quand même gagné !");
        }

        gameMenu.displayWinMessage();
        this.restartGame();
    }

    /**
     * This function handle the end of a game, asking the user if he wants to launch another game or quit.
     */
    public void restartGame() {
        System.out.println("Voulez vous rejouer ? | [1] Oui - [2] Non");
        int lastChoice = gameMenu.getAnswerInt(this.userInput, 2);
        if (lastChoice == 1) {
            this.currentPosition = 0;
            this.turnCounter = 0;
            playGame();
        } else {
            System.exit(0);
        }
    }

    /**
     * Define the condition needed to throw an out of bound exception when the player go past the maximum number of tiles available.
     * @param position
     * @throws OutOfBoundException
     */
    public void getOOBException(int position) throws OutOfBoundException {
        if (position > this.tileNumber) {
            throw new OutOfBoundException();
        }
    }

}



