import java.nio.file.Paths;
import java.io.IOException;

public class Application {
    public static void main (String [] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        duplicateCounter.count(Paths.get("problem2.txt"));
        duplicateCounter.write(Paths.get("unique_word_counts.txt"));
    }
}