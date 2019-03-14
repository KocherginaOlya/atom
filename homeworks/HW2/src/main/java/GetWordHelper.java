import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GetWordHelper {
    private String fileName = "dictionary.txt";

    public String toGet() throws IOException {

        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
        scanner.close();

        int randomIndex = ThreadLocalRandom.current().nextInt(0, words.size());

        return words.get(randomIndex);
    }
}