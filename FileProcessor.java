import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class process one file returning a Map of word -> count
 *
 * Remember you need to implement this by yourself.
 * You should only use the web for reading documentation https://docs.oracle.com/javase/8/docs/api/
 *
 * Copying code from the internet, even if it an extract is not allowed and will be considered
 * plagiarism.
 */
public class FileProcessor {
    private String filename;


    public FileProcessor(String filename) {
        this.filename = filename;
    }


    /**
     * Process the file associated with the object.
     *
     * @return a Map for each word as a key and the number of occurrences of that word as its value
     */
    public Map<String, Long> processFile() {
        Map<String, Long> wordCount = new HashMap<>();
        long startTime = System.currentTimeMillis(), finishTime;


        try {
            String[] string;
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            try {
                while (true) {
                    string = br.readLine().split(" ");
                        for (int j = 0; j < string.length; ++j) {
                            string[j] = string[j].replace(".", "")
                                    .replace(",", "")
                                    .replace("?", "")
                                    .replace(";", "")
                                    .replace(":", "")
                                    .replace("\'", "")
                                    .replace("\"", "")
                                    .replace("[", "")
                                    .replace("]", "")
                                    .trim();

                            if (wordCount.containsKey(string[j])) {
                                wordCount.put(string[j], wordCount.get(string[j]) + 1);
                            } else {
                                wordCount.put(string[j], (long) 0);
                            }
                        }
                }
            } catch (NullPointerException e){}
        } catch (FileNotFoundException e) {
            System.out.println("Cant find the file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        finishTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for "+ this.filename + ": " + finishTime );

        return wordCount;
    }

}
