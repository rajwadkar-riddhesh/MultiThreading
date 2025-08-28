package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        int workers = 3;

        CountDownLatch latch = new CountDownLatch(workers);

        for (int i = 1; i <= workers; i++) {
            int id = i;
            new Thread( () -> {
                System.out.println("Worker " + id + " stared.");
                try {
                    Thread.sleep(1000 * id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Worker " + id + " finished");
                latch.countDown();
            }).start();
        }

        System.out.println("Main thread is waiting for workers to finish");
        latch.await();
        System.out.println("All workers finished. Main thread continues");
    }
}