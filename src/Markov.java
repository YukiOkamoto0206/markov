import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Markov {
    private static final String PUNCTUATION = "__$";
    private static final String PUNCTUATION_MARKS = ".!?";
    private HashMap<String, ArrayList<String>> words;
    private String prevWord;

    public static void main(String[] args) {
        Markov markov = new Markov();

        markov.addFromFile("spam.txt");
//        System.out.println(markov);

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
        // split individual word
//        System.out.println(s);
        String[] word = line.split(" ");

//        for (){
//          addword(word)
//    }
    }

    protected void addWord(String s) {
        // ガチガチ
    }

    public String getSentence() {
        return "";
    }

    protected static String randomWord(String s) {
        return "";
    }

    public boolean endsWithPunctuation(String s) {
        return false;
    }

    @Override
    public String toString() {
        return "Markov{" +
                "words=" + words +
                ", prevWord='" + prevWord + '\'' +
                '}';
    }
}
