/*
 * Anthony Mozloom
 * Hangman Lab 2
 */
package game;

public abstract class GuesserBase {
    
    protected static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    protected StringBuilder myLettersLeftToGuess;
    protected int myNumGuessesLeft;

    public GuesserBase(int numGuesses){
        myLettersLeftToGuess = new StringBuilder(ALPHABET);
        myNumGuessesLeft = numGuesses;
    }

    public abstract char makeGuess ();

    // Record that a specific letter was guessed
    public void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }

    // Decrease the number of guesses left
    public void decreaseGuesses() {
        myNumGuessesLeft--;
    }

    // Check if the game is lost
    public boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }

    // Get the number of guesses left
    public int getNumGuessesLeft() {
        return myNumGuessesLeft;
    }

    // Get the letters left to guess
    public String getLettersLeftToGuess() {
        return myLettersLeftToGuess.toString();
    }
}
