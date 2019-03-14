
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.LoggerFactory;

public class Main {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Main.class);

    public static StringBuilder typedWordChars;

    public static StringBuilder wordChars;

    public static void main(String[] args) throws IOException {
        System.out.println("Bulls and cows");
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        while (true) {
            GetWordHelper wordHelper = new GetWordHelper();
            String word = wordHelper.toGet();

            String typedWord;
            int tryCount = 0;

            log.info("Bulls and Cows started");
            System.out.println("Type any word:");

            do {
                typedWord = br.readLine();
                if (typedWord.toString().equals("/?")) {
                    System.out.println(word);
                    continue;
                }

                typedWordChars = new StringBuilder(typedWord);
                wordChars = new StringBuilder(word);
                tryCount++;

                int bullsCount = count_of_Bulls();
                int cowsCount = count_of_Cows();
                System.out.println("Count of Cows: " + cowsCount + ".  Count of Bulls: " + bullsCount);
            } while (!typedWord.equals(word) && tryCount < 10);

            System.out.println("The secret word was:");
            System.out.println(word);

            if (tryCount == 10) {
                log.info("Failed");
                System.out.println("Potracheno!");
            } else {
                log.info("Perfecto");
                System.out.println("You are incredible!");
            }

            System.out.println("For new game press key(O)");
            typedWord = br.readLine();
            if (!typedWord.toString().equals("O")) {
                break;
            }
        }
    }

    public static int count_of_Bulls() {
        int bullsCount = 0;

        for (int index = 0; index < typedWordChars.length(); index++) {
            if (index < wordChars.length() && typedWordChars.charAt(index) == wordChars.charAt(index)) {
                bullsCount++;
                typedWordChars.deleteCharAt(index);
                wordChars.deleteCharAt(index);
                index--;
            }
        }

        return bullsCount;
    }

    public static int count_of_Cows() {
        int cowsCount = 0;
        for (int index = 0; index < typedWordChars.length(); index++) {
            for (int wordCharIndex = 0; wordCharIndex < wordChars.length(); wordCharIndex++) {
                if (typedWordChars.charAt(index) == wordChars.charAt(wordCharIndex)) {
                    cowsCount++;
                    typedWordChars.deleteCharAt(index);
                    wordChars.deleteCharAt(wordCharIndex);
                    index--;
                    break;
                }
            }
        }

        return cowsCount;
    }
}
