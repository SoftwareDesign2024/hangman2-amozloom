/*
 * Anthony Mozloom
 * Hangman Lab 2
 */
package game;

import util.ConsoleReader;

public class ManualGuesser extends GuesserBase {

    public ManualGuesser(int numGuesses) {
        super(numGuesses);
    }

    @Override
    public char makeGuess() {
        String input = ConsoleReader.promptString("Make a guess: ");
        
        while (input.length() != 1 || !Character.isAlphabetic(input.charAt(0))) {
            System.out.println("Please enter a single letter ...");
            input = ConsoleReader.promptString("Make a guess: ");
        }
        char guessedLetter = input.charAt(0); 

        int index = myLettersLeftToGuess.indexOf("" + guessedLetter);
        if (index >= 0) {
            recordGuess(index); 
        }

        return guessedLetter;
    }

}