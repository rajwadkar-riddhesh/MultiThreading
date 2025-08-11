package deadlock;

public class DeadLockExample {

    static class Pen {

        public synchronized void writeWithPenAndPaper(Paper paper) {
            System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to write on paper ");
            paper.finishWriting();
        }

        public synchronized void finishWriting() {
            System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
        }
    }

    static class Paper {

        public synchronized void writeWithPaperAndPen(Pen pen) {
            System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to write with pen ");
            pen.finishWriting();
        }

        public synchronized void finishWriting() {
            System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
        }
    }

    static class Task1 implements Runnable {

        private Pen pen;
        private Paper paper;

        public Task1(Pen pen, Paper paper) {
            this.pen = pen;
            this.paper = paper;
        }

        @Override
        public void run() {
            pen.writeWithPenAndPaper(paper);
        }
    }

    static class Task2 implements Runnable {

        private Pen pen;
        private Paper paper;

        public Task2(Pen pen, Paper paper) {
            this.pen = pen;
            this.paper = paper;
        }

        @Override
        public void run() {
            paper.writeWithPaperAndPen(pen);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}
