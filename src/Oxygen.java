import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {
    private static final String VALUE = "O";
    private final Semaphore oxygenSemaphore;
    private final Semaphore hydrogenSemaphore;

    public Oxygen(Semaphore oxygenSemaphore, Semaphore hydrogenSemaphore) {
        this.oxygenSemaphore = oxygenSemaphore;
        this.hydrogenSemaphore = hydrogenSemaphore;
    }

    private void releaseOxygen() {
        System.out.print(VALUE);
    }

    @Override
    public void run() {
        try {
            oxygenSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        releaseOxygen();
        if (hydrogenSemaphore.availablePermits() == 0 && oxygenSemaphore.availablePermits() == 0) {
            hydrogenSemaphore.release(2);
        }
    }
}
