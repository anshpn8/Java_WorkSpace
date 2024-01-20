package Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;

    public Client() {
        try {
            System.out.println("sending Request To server");
            socket = new Socket("127.0.0.1", 6327);
            System.out.println("Connection done.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true); // Set auto-flush to true

            startReading();
            startWriting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started");

            try {
                String msg;
                while ((msg = br.readLine()) != null && !socket.isClosed()) {
                    if (msg.equals("EXIT")) {
                        socket.close();
                        System.out.println("Server terminated the chat");
                        break;
                    }
                    System.out.println("Server: " + msg);
                }
            } catch (IOException e) {
                System.out.println("Client Disconnected");
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        Runnable r2 = () -> {
            System.out.println("Writer started");
            try {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String content;
                while ((content = br1.readLine()) != null && !socket.isClosed()) {
                    out.println(content);
                }
            } catch (IOException e) {
                System.out.println("Client Disconnected");
            }
        };

        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is Client..");
        new Client();
    }
}
