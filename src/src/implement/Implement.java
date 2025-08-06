package implement;

public class Implement {
    public static void main(String[] args) throws InterruptedException {

        process3 p3 = new process3();
        process4 p4 = new process4();
        process5 p5 = new process5();

        Thread t1 = new Thread(p3);
        Thread t2 = new Thread(p4);
        Thread t3 = new Thread(p5);

// This is way the thread will run if the main thread is finished its work
//        t1.start();
//        t2.setDaemon(true);
//        t2.start();

//Here the thread scheduler will give preference to t1 & t3
//        t1.start();
//        Thread.yield();
//        t2.start();
//        t3.start();

// Here the thread scheduler will give preference to t1 & t2
//        t1.start();
//        t2.start();
//        Thread.yield();
//        t3.start();

// Here the thread scheduler will give equal preference to t1, t2 & t3
//        t1.start();
//        t2.start();
//        t3.start();
//        Thread.yield();

// Here the thread with join will wait for the its thread to finish & then move to the next thread
//        t1.start();
//        t2.join();
//        t2.start();
//        t3.start();
//        t3.join();

        t1.start();
        t1.interrupt();
        t2.start();
        t3.start();
        t3.join();


    }
}
