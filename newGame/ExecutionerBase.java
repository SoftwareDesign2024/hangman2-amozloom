/*
 * Anthony Mozloom
 * Hangman Lab 2
 */
package game;

import util.DisplayWord;
import util.HangmanDictionary;

public abstract class ExecutionerBase {
    protected String mySecretWord;
    protected DisplayWord myDisplayWord;

    public ExecutionerBase(HangmanDictionary dictionary, int wordLength) {
        mySecretWord = makeSecretWord(dictionary, wordLength);
        myDisplayWord = new DisplayWord(mySecretWord);
    }

    //Return a secret word
    private String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }

    public abstract boolean checkGuessInSecret(char guess);

    public boolean isGameWon() {
        return myDisplayWord.equals(mySecretWord);
    }

    public String getDisplayWord() {
        return myDisplayWord.toString();
    }

    public void printSecretWord() {
        System.out.println("The secret word is: " + mySecretWord);
    }
}
