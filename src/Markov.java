import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Markov {
    private static final String PUNCTUATION = "__$";
    private static final String PUNCTUATION_MARKS = ".!?";
    private HashMap<String, ArrayList<String>> words;
    private String prevWord;

    public static void main(String[] args) {
        Markov markov = new Markov();

        markov.addFromFile("spam.txt");
        System.out.println(markov);

//        for (int i = 0; i < 10; i ++){
//            System.out.println(markov.getSentence());
//        }

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
            words.get(prevWord).add(word);
        }
        prevWord = word;
//        if(endsWithPunctuation(prevWord)) {
//            words.get(PUNCTUATION).add(word);
//        } else {
//            if (!words.containsKey(prevWord)) {
//                words.put(prevWord, new ArrayList<String>());
//            }
//            words.get(prevWord).add(word);
//        }
//        prevWord = word;
    }

    public String getSentence() {
        return "";
    }

    protected static String randomWord(String s) {
        return "";
    }

    public boolean endsWithPunctuation(String word) {
        boolean isPunctuation = false;
        try {
            isPunctuation = word.contains(PUNCTUATION_MARKS);
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
