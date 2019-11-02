import java.nio.file.Paths;
import java.io.IOException;

public class Application {
    public static void main (String [] args) throws IOException {
        DuplicateCounter use = new DuplicateCounter();

        use.count(Paths.get("problem2.txt"));
        use.write(Paths.get("unique_word_counts.txt"));
    }
}