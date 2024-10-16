/*
 * Anthony Mozloom
 * Hangman Lab 2
 */
package game;

import util.ConsoleReader;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    private GuesserBase myGuesser;
    private ExecutionerBase myExecutioner;

    public HangmanGame(GuesserBase guesser, ExecutionerBase executioner) {
        myGuesser = guesser;
        myExecutioner = executioner;
    }

    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            char guessedLetter = myGuesser.makeGuess();

            if (!myExecutioner.checkGuessInSecret(guessedLetter)) {
                myGuesser.decreaseGuesses();  
            }

            if (myGuesser.isGameLost()) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            }
            else if (myExecutioner.isGameWon()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            }
            
        }
        myExecutioner.printSecretWord();
    }

    // Print game stats
    private void printStatus () {
        System.out.println(myExecutioner.getDisplayWord());
        System.out.println("# misses left = " + myGuesser.getNumGuessesLeft());
        System.out.println("letters not yet guessed = " + myGuesser.getLettersLeftToGuess());
        // NOT PUBLIC, but makes it easier to test
        //System.out.println("*** " + mySecretWord);
        System.out.println();
    }
}
