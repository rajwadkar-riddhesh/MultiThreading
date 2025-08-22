package callablefuture;

import java.util.concurrent.*;

public class CallableFutureExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Task started by " + Thread.currentThread().getName());
            Thread.sleep(1000);
            return 10 * 2;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Main thread can do work...");

        Integer result = future.get();

        System.out.println("Result from callable: " + result);

        executor.shutdown();
    }
}