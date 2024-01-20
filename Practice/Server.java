package java_chat_application;
import java.net.*;
import java.io.*;

public class Server {

    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    // constructor
    public Server() {
        try {
            server = new ServerSocket(6327);
            System.out.println("Server is ready to accept connections");
            System.out.println("Waiting.......");

            socket = server.accept();
            System.out.println("Client connected.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started");

            try {
                while (!socket.isClosed()) {
                    String msg = br.readLine();
                    if (msg.equals("EXIT")) {
                        System.out.println("Client terminated the chat");
                        break;
                    }
                    System.out.println("Client : " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
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
                while (!socket.isClosed()) {
                    content = br1.readLine();
                    out.println(content);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        };

        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is server... going to Start");
        // Call a server constructor
        new Server();
    }
}
