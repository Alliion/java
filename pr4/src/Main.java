
// 10

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = new MyExecutorService(5);
        executorService.submit(() -> {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));
    }
}
