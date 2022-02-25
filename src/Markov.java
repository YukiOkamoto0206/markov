import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Title: Markov.java
 * Abstract: Markov Text Generation
 * Author: Yuki Okamoto
 * Date: Feb 24, 2022
 */
public class Markov {
    private static final String PUNCTUATION = "__$";
    private static final String PUNCTUATION_MARKS = ".!?";
    private HashMap<String, ArrayList<String>> words;
    private String prevWord;

    public static void main(String[] args) {
        Markov markov = new Markov();

        markov.addFromFile("spam.txt");
        System.out.println(markov);

//        System.out.println(randomWord("and"));

        for (int i = 0; i < 10; i ++){
            System.out.println(markov.getSentence());
        }

    }

    public Markov() {
        this.words = new HashMap<>() {
            {
                put(PUNCTUATION, new ArrayList<String>());
            }
        };
        this.prevWord = PUNCTUATION;
    }

    protected HashMap<String, ArrayList<String>> getWords() {
        return words;
    }

    public void addFromFile(String fileName) {
        File f = new File(fileName);
        Scanner scan = null;

        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + fileName);
            e.printStackTrace();
        }

        while (scan != null && scan.hasNextLine()) {
            String input = scan.nextLine();
            addLine(input);
        }
    }

    protected void addLine(String line) {
        if (line.length() == 0) return;
        String[] wordArr = line.split(" ");

        for (String word : wordArr) {
            addWord(word);
        }
    }

    protected void addWord(String word) {
        // check if it is punctuated or not
        if (endsWithPunctuation(prevWord)) {
            // current word is added under the PUNCTUATION key in the words HashMap.
            words.get(PUNCTUATION).add(word);
        }
        // not punctuated
        else {
            // Words have prevWord
            if (!words.containsKey(prevWord)) {
                words.put(prevWord, new ArrayList<String>());
            }
        }
        if (words.containsKey(prevWord)) {
            words.get(prevWord).add(word);
        }
        prevWord = word;
    }

    public String getSentence() {
        String sentence = "";
        String random_word = randomWord(PUNCTUATION);
        sentence += random_word;
        while (!endsWithPunctuation(random_word)) {
            random_word = randomWord(random_word);
            sentence = sentence + " " + random_word;
        }
        return sentence;
    }

    protected String randomWord(String word) {
        ArrayList<String> arrayList = words.get(word);
        Random random = new Random();
        int random_number = random.nextInt(arrayList.size());
        return (String) arrayList.get(random_number);
    }

    public static boolean endsWithPunctuation(String word) {
        boolean isPunctuation = false;
        try {
            isPunctuation = PUNCTUATION_MARKS.contains(word.substring(word.length() - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPunctuation;
    }

    @Override
    public String toString() {
        return words + "";
    }
}
