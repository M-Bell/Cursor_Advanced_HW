package Task_2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    public CustomThreadPoolExecutor(int maximumPoolSize) {
        super(5, maximumPoolSize, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
    }

    @Override
    public void execute(Runnable command) {
        if (command.getClass().getAnnotation(Repeat.class) != null) {
            for (int i = 0; i < command.getClass().getAnnotation(Repeat.class).repeatsAmount(); i++) {
                command.run();
            }
        } else {
            command.run();
        }
    }
}
