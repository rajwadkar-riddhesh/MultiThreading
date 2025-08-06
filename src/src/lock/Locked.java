package lock;

public class Locked {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                account.withdraw(50);
            }
        };

        Thread d1 = new Thread(task, "Thread 1");
        Thread d2 = new Thread(task, "Thread 2");

        d1.start();
        d2.start();
    }
}