package threadpooling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        for (int i = 0; i < 400; i++) {

            final int taskId = i;

            executorService.submit( () -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        }
        executorService.shutdown();
    }
}
