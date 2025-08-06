package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw (int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw " + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");
                    try {
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Completed withdrawal. Remaining balance is " + balance);
                    } catch (InterruptedException e) {

                    }
                    finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Unable to acquire lock, withdrawal aborted ");
            }
        } catch (Exception e) {

        }
    }
}
