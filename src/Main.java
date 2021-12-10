import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore hydrogen = new Semaphore(2);
        Semaphore oxygen = new Semaphore(1);
        String[] input = "OHHOHOHHH".split("");
        Arrays.stream(input).forEach(x -> (x.equals("O") ? new Oxygen(oxygen, hydrogen) : new Hydrogen(oxygen, hydrogen)).start());
    }
}
