package system.exceptions;

/**
 * This class define a new custom exception used to handle when the player go past the maximum number of tiles available in the game.
 */
public class OutOfBoundException extends Exception {
    public OutOfBoundException(){
        super();
    }
}