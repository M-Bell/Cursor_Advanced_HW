package Task_2;

@Repeat(repeatsAmount = 5)
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
