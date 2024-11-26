import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClient {
    public void start(final int portNumber, final Scanner scanner) {
        try (var serverChannel = SocketChannel.open()) {
            serverChannel.connect(new InetSocketAddress(portNumber));
            serverChannel.configureBlocking(true);
            System.out.println("Connection established!");
            Runnable r = () -> {
                var buffer2 = ByteBuffer.allocate(1024);
                while (true) {
                    try {
                        var bytesRead = serverChannel.read(buffer2);
                        if (bytesRead > 0) {
                            buffer2.flip();
                            var readData = new byte[bytesRead];
                            buffer2.get(readData);
                            System.out.print("SERVER: " + new String(readData));
                            buffer2.clear();
                        }
                    } catch (IOException _) {}
                }
            };
            new Thread(r).start();
            var buffer = ByteBuffer.allocate(1024);
            while (true) {
                var line = scanner.nextLine();
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                line += System.lineSeparator();
                buffer.clear().put(line.getBytes()).flip();
                while (buffer.hasRemaining()) {
                    serverChannel.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
