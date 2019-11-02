import java.io.*;       //rep. any necessary java.io. imports ~
import java.util.HashSet;   //Zybooks 11.5, 13.5/6 ~
import java.util.Scanner;
import java.nio.file.Path;

public class DuplicateRemover {

    private String uniqueWords;
    HashSet<String> compare = new HashSet<String>();    //Set of Strings ~
    final int MAX_FILE_WORDS = 100;
    String[] allText = new String[MAX_FILE_WORDS];  //couldn't measure dF length before inFS, so had to set cap ~
    FileInputStream upStream = null;
    FileOutputStream downStream = null;
    Scanner inFS = null;
    PrintWriter outFS = null;

    public void remove (Path dataFile) throws IOException {
        try {   //in = new DataInputStream(new BufferedInputStream(new FileInputStream (String.valueOf(dataFile))));
            upStream = new FileInputStream(String.valueOf(dataFile));
            inFS = new Scanner(upStream);
            int i;
            int j;
            for (i = 0; i < allText.length; ++i) {
                allText[i] = inFS.next();
                compare.add(allText[i]);
                for (j = 0; j < allText.length; ++j) {
                    if (allText[i] == allText[j]) {
                        if (i != j) {
                            compare.remove(allText[i]);
                        }
                    } else if (!uniqueWords.contains(allText[i])) {
                        uniqueWords = uniqueWords.concat(allText[i]);
                        if (i % 10 == 0) {      //newline every 10 words ~
                            uniqueWords = uniqueWords.concat("\n");
                        } else {
                            uniqueWords = uniqueWords.concat(" ");
                        }
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Caught IOException: " + exception.getMessage());
        }
        finally {
            if (upStream != null) {
                upStream.close();
            }
        }
    } //write method shall print the current collection of unique words to outputFile ~
    public void write (Path outputFile) throws IOException {
        try {
            downStream = new FileOutputStream(String.valueOf(outputFile));
            outFS = new PrintWriter(downStream);
            outFS.println(uniqueWords);     //All words, one line; for multiple, edit: uW = uW.cc("\n"); in else{} ~
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