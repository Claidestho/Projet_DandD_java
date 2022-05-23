package system;

import enemies.Dragon;
import enemies.Goblin;
import enemies.Sorcerer;
import heros.Hero;
import items.potions.LargePotion;
import items.potions.MediumPotion;
import items.spells.Fireball;
import items.spells.Lightning;
import items.weapons.Mace;
import items.weapons.Sword;
import main.InteractionInterface;
import menu.MainMenu;
import system.board.EmptyTile;
import system.board.Tile;
import system.exceptions.OutOfBoundException;

import java.util.*;
import java.util.function.Supplier;

/**
 * This class handle all the logic of the game. Need to put all the display in the MainMenu class.
 */
public class GameCore {
    private final int tileNumber;
    private final List<Tile> board;
    private final MainMenu gameMenu;
    private final Hero heroPlayer;
    private final Scanner userInput;
    private int currentPosition;
    private int turnCounter;

    public GameCore(MainMenu menu, Hero player) {
        this.gameMenu = menu;
        this.heroPlayer = player;
        this.tileNumber = 64;
        this.userInput = new Scanner(System.in);
        this.board = new ArrayList<Tile>(tileNumber);
    }


    public List generateBoard() {
        Map<Supplier<Tile>, Integer> possibleTiles = new HashMap<>();
        possibleTiles.put(Sword::new, 4);
        possibleTiles.put(Dragon::new, 4);
        possibleTiles.put(Sorcerer::new, 10);
        possibleTiles.put(Goblin::new, 10);
        possibleTiles.put(Mace::new, 5);
        possibleTiles.put(Lightning::new, 5);
        possibleTiles.put(Fireball::new, 2);
        possibleTiles.put(MediumPotion::new, 6);
        possibleTiles.put(LargePotion::new, 2);
        possibleTiles.put(EmptyTile::new, 16);
        for (Map.Entry<Supplier<Tile>, Integer> entry : possibleTiles.entrySet()) {
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                Tile key = entry.getKey().get();
                board.add(key);
            }
        }
        System.out.println(board);
        Collections.shuffle(board);
        return board;
    }


    public int throwDice() {
        int maxDiceValue = 6;
        int minDiceValue = 1;
        return (int) Math.floor(Math.random() * (maxDiceValue - minDiceValue + 1) + minDiceValue);
    }

    /**
     * This function handle all the logic of the game for now. It permit the user to throw the dice, view his character stats sheet, rename his character and quit the game.
     */
    public void playGame() {
        this.generateBoard().clear();
        this.generateBoard();

        while (this.currentPosition < this.board.size() - 1) {
            gameMenu.turnStart(this.turnCounter, this.currentPosition, this.heroPlayer);
            int intChoice = gameMenu.getAnswerInt(this.userInput, 4);

            switch (intChoice) {
                case 1 -> {
                    this.turnCounter++;
                    int diceResult = this.throwDice();
                    this.currentPosition += diceResult;

                    /* AFFICHAGE POUR UTILISATION DE L INTERFACE */
                    if(this.board.get(currentPosition) instanceof InteractionInterface anInterface){
                        anInterface.typeOfInteract();
                    }

                    if (currentPosition != this.board.size() - 1) {
                        if (this.board.get(currentPosition).interactWithPlayer(heroPlayer)) {
                            restartGame();
                        }
                    }
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
     *
     * @param position
     * @throws OutOfBoundException
     */
    public void getOOBException(int position) throws OutOfBoundException {
        if (position > this.tileNumber) {
            throw new OutOfBoundException();
        }
    }

}



