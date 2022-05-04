package system;

import menu.MainMenu;

public class GameCore {
    private int tileNumber = 64;
    private int currentPosition = 0;
    private int turnCounter = 0;

    public GameCore(MainMenu menu){

    }

    public int throwDice() {
        int maxDiceValue = 6;
        int minDiceValue = 1;
        int diceResult = (int) Math.floor(Math.random() * (maxDiceValue - minDiceValue + 1) + minDiceValue);
        return diceResult;
    }

    public void playTurn(MainMenu menu) {
        this.turnCounter++;
        this.throwDice();
        menu.turnStart(this);


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


