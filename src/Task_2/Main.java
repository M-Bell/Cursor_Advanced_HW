package Task_2;

public class Main {
    public static void main(String[] args) {
        CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(10);
        threadPoolExecutor.execute(new MyRunnable());
    }

}
