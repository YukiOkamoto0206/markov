import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Title: MarkovTest.java
 * Abstract: Markov Text Generation
 * Author: Yuki Okamoto
 * Date: Feb 24, 2022
 */
public class MarkovTest {
    private static final String PUNCTUATION = "__$";
    private static final String PUNCTUATION_MARKS = ".!?";
    private HashMap<String, ArrayList<String>> words;
    private String prevWord;

    @Test
    void constructor() {
        Markov markov = new Markov();
    }

    @Test
    void getWords() {

    }

    @Test
    void getSentence() {
    }

    @Test
    void randomWord() {
    }

    @Test
    void endsWithPunctuation() {
    }

    @Test
    void testToString() {
    }
}
