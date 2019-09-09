import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void startApplication(){
        List<String> filenameList = new ArrayList<>();
        filenameList.add("src/shakespeare-life-54.txt");
        filenameList.add("src/shakespeare-life-55.txt");
        filenameList.add("src/shakespeare-life-56.txt");
        WordCount program = new WordCount();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                program.run(filenameList.get(0));
                executorService1.shutdown();
            }
        });
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                program.run(filenameList.get(1));
                executorService2.shutdown();
            }
        });
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        executorService3.execute(new Runnable() {
            @Override
            public void run() {
                program.run(filenameList.get(2));
                executorService3.shutdown();
            }
        });
    }
    public static void main(String[] args){
        startApplication();
    }
}
