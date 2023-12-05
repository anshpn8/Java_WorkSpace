import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPrinter {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AtomicBoolean isStopped = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            while (!isStopped.get()) {
                System.out.println(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            while (!isStopped.get()) {
                if (scanner.nextLine().equals("x")) {
                    isStopped.set(true);
                    break;
                }
                System.out.println(2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
