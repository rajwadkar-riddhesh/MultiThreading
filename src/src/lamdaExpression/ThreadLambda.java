package lamdaExpression;

public class ThreadLambda {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread is running using lambda expression");
        };

        Thread t1 = new Thread(runnable);
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("Thread is running using lambda expression in a different way");
        });
        t2.start();
    }
}
