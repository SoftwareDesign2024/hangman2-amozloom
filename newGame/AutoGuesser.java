/*
 * Anthony Mozloom
 * Hangman Lab 2
 */
package game;

public class AutoGuesser extends GuesserBase{
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private int myIndex;

    public AutoGuesser(int numGuesses) {
        super(numGuesses);
        myIndex = 0;
    }

    
    @Override
    public char makeGuess() {
        char guess = LETTERS_ORDERED_BY_FREQUENCY.charAt(myIndex);

        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index); 
        }
        myIndex++;

        return guess;
    }
}
