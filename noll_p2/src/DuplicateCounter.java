import java.io.*;
import java.util.HashMap;   //Zybooks 11.5, 13.5/6 ~
import java.util.Scanner;
import java.nio.file.Path;

public class DuplicateCounter<map> {

    private int wordCounter = 0;
    HashMap<String, Integer> compare = new HashMap <String, Integer>();      //"Map of Strings" ~
    final int MAX_FILE_WORDS = 100;
    String[] allText = new String[MAX_FILE_WORDS];
    FileInputStream upStream = null;
    FileOutputStream downStream = null;
    Scanner inFS = null;
    PrintWriter outFS = null;

    public void count (Path dataFile) throws IOException {
        try {
            upStream = new FileInputStream(String.valueOf(dataFile));
            inFS = new Scanner(upStream);
            int i;
            int j;
            for (i = 0; i < allText.length; ++i) {
                allText[i] = inFS.next();
                for (j = 0; j < allText.length; ++j) {      //where i == j, compare.put(aT[], 1),
                    if (allText[i] == allText[j]) {         //so each word that appears at all has wC = 1 ~
                        compare.put(allText[i], wordCounter + 1);
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("IOException Caught: " + exception.getMessage());
        }
        finally {
            if (upStream != null) {
                upStream.close();
            }
        }
    } //write method shall print the current collection of unique words and their counts to outputFile ~
    public void write (Path outputFile) throws IOException {
        try {
            downStream = new FileOutputStream(String.valueOf(outputFile));
            outFS = new PrintWriter(downStream);
            outFS.println(compare); //print legibly? online search, yes. Untested ~
        } catch (IOException exception) {
            System.out.println("IOException Caught: " + exception.getMessage());
        }
        finally {
            outFS.flush();
            if (downStream != null) {
                downStream.close();
            }
        }
    }
}