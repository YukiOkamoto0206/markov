import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Title: MarkovTest.java
 * Abstract: Markov Text Generation Test class
 * Author: Yuki Okamoto
 * Date: Feb 24, 2022
 */
public class MarkovTest {
    private static final String PUNCTUATION = "__$";
    private HashMap<String, ArrayList<String>> words;
    private String prevWord;

    @Test
    void testConstructor() {
        Markov markov = new Markov();
    }

    @Test
    void testGetWords() {
        Markov markov = new Markov();
        markov.addFromFile("simpleTest.txt");
        System.out.println(markov.getWords());
    }

    @Test
    void testGetSentence() {
        Markov markov = new Markov();
        markov.addFromFile("simpleTest.txt");
        System.out.println(markov.getSentence());
    }

    @Test
    void testRandomWord() {
        Markov markov = new Markov();
        markov.addFromFile("simpleTest.txt");
        System.out.println(markov.randomWord("Hello"));
    }

    @Test
    void testEndsWithPunctuation() {
        assertFalse(Markov.endsWithPunctuation("Hello"));
        assertTrue(Markov.endsWithPunctuation("World."));
    }

    @Test
    void testToString() {
        Markov markov = new Markov();
        markov.addFromFile("simpleTest.txt");

        this.words = new HashMap<>() {
            {
                put(PUNCTUATION, new ArrayList<String>());
            }
        };
        ArrayList<String> arrayList = new ArrayList<String>();
        words.get(PUNCTUATION).add("Hello");
        words.put("Hello", new ArrayList<String>());
        words.get("Hello").add("World.");

        assertTrue(words.equals(markov.getWords()));
    }
}
