/*
 * Anthony Mozloom
 * Hangman Lab 2
 */
package game;

import util.HangmanDictionary;

public class NormalExecutioner extends ExecutionerBase{

    public NormalExecutioner(HangmanDictionary dictionary, int wordLength) {
        super(dictionary, wordLength);
    }

    @Override
    public boolean checkGuessInSecret(char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
    
}
