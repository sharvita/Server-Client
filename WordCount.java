import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Counts the words in the given files.
 *
 * Remember you need to implement this by yourself.
 * You should only use the web for reading documentation https://docs.oracle.com/javase/8/docs/api/
 *
 * Copying code from the internet, even if it an extract is not allowed and will be considered
 * plagiarism.
 */
public class WordCount {

    /**
     * Returns a new map with the merged values of the two maps.
     * @param map1
     * @param map2
     * @return
     */
    public  Map<String,Long> mergeMaps(Map<String,Long> map1, Map<String,Long> map2){
        String[] words = map2.keySet().toArray(new String[0]);

        for(int i = 0; i < words.length; ++i){
            if(map1.containsKey(words[i])){
                map1.put(words[i], map1.get(words[i]) + map2.get(words[i]));
            }else{
                map1.put(words[i], map2.get(words[i]));
            }
        }
        return map1;
    }

    public void run(String fileName) {
        Map<String,Long> wordCount = null;

            FileProcessor fileProcessor = new FileProcessor(fileName);
                wordCount = fileProcessor.processFile();

        List<String> wordsMostSeen = wordsMostSeen(wordCount);
    }
    public  List<String> wordsMostSeen(Map<String,Long> map){
        String[] keys = map.keySet().toArray(new String[0]);
        Long[] values = map.values().toArray(new Long[0]);
        List<String> mostWords = new ArrayList<>();

        for(int i = 0; i < 51; ++i){
            long max = 0;
            int index = 0;
            for(int j = 0; j < values.length; ++j) {
                if (values[j] > max) {
                    max = values[j];
                    index = j;
                }
            }
            values[index] = (long) 0;
            mostWords.add(keys[index]);
        }
        return mostWords;
    }

}
