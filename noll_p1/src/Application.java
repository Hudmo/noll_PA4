import java.nio.file.Paths;
import java.io.IOException;

public class Application {
    public static void main (String [] args) throws IOException {
        DuplicateRemover use = new DuplicateRemover();

        use.remove(Paths.get("problem1.txt"));     //should name files for DR class ~
        use.write(Paths.get("unique_words.txt"));
    }
}