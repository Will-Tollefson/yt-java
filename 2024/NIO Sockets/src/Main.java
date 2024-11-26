import java.util.Scanner;

final int PORT_NUMBER = 12345;

void main() {
    try (var scanner = new Scanner(System.in)) {
        System.out.println("Is this a server? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            new NioServer().start(PORT_NUMBER);
        } else {
            new NioClient().start(PORT_NUMBER, scanner);
        }
    }
}