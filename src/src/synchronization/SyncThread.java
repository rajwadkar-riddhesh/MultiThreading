package synchronization;

public class SyncThread implements Runnable{

    private Counter counter;

    public SyncThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread th1 = new Thread(new SyncThread(counter));
        Thread th2 = new Thread(new SyncThread(counter));

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (Exception e) {

        }

        System.out.println(counter.getCount());
    }
}
