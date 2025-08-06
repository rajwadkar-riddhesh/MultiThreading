package implement;

public class process4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++){

            System.out.println("Process 4");
        }
    }
}
