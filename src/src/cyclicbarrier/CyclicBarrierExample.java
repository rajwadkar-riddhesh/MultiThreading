package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int threads = 3;

        // Barrier with 3 parties
        CyclicBarrier barrier = new CyclicBarrier(threads,
                () -> System.out.println("All threads reached barrier, moving together..."));

        for (int i = 1; i <= threads; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + id + " doing work...");
                    Thread.sleep(1000 * id); // simulate work
                    System.out.println("Thread " + id + " waiting at barrier");
                    barrier.await(); // wait for others
                    System.out.println("Thread " + id + " passed the barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
