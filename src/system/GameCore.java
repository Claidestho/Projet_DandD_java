package system;

public class GameCore {
    private int tileNumber = 64;
    private int currentPosition = 0;

    public int throwDice() {
        int maxDiceValue = 6;
        int minDiceValue = 1;
        int diceResult = (int) Math.floor(Math.random() * (maxDiceValue - minDiceValue + 1) + minDiceValue);
        return diceResult;
    }

    public void playTurn() {
        this.throwDice();

    }


    public int getTileNumber() {
        return tileNumber;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}


