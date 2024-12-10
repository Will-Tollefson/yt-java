import java.util.Random;
import java.util.concurrent.Executors;

public class Main {

    private static final int NUM_REQUESTS = 1000;

    public static void main(String[] args) {
        final Server server = new Server();
        final Random random = new Random();
        try (var executor = Executors.newFixedThreadPool(NUM_REQUESTS)) {
            for (int i = 0; i < NUM_REQUESTS; i++) {
                executor.submit(() -> {
                   try {
                       while (!server.tryLogin()) {
                           Thread.sleep(random.nextInt(1000));
                       }
                       Thread.sleep(random.nextInt(1000));
                       server.logout();
                   } catch (InterruptedException e) {
                       throw new RuntimeException();
                   }
                });
            }
        }
    }
}