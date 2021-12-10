import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {
    private static final String VALUE = "H";
    private final Semaphore oxygenSemaphore;
    private final Semaphore hydrogenSemaphore;

    public Hydrogen(Semaphore oxygenSemaphore, Semaphore hydrogenSemaphore) {
        this.oxygenSemaphore = oxygenSemaphore;
        this.hydrogenSemaphore = hydrogenSemaphore;
    }

    private void releaseHydrogen() {
        System.out.print(VALUE);
    }

    @Override
    public void run() {
        try {
            hydrogenSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (hydrogenSemaphore.availablePermits() == 0 && hydrogenSemaphore.availablePermits() == 0) {
            releaseHydrogen();
            releaseHydrogen();
            oxygenSemaphore.release();
        }
    }
}
