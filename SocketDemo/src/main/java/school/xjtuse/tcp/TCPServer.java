package school.xjtuse.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);

        System.out.println("Server Initializing..");
        while (true) {
            System.out.println(serverSocket);
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            count++;
            System.out.println("TCPServer" + count + "(" + socket.getLocalSocketAddress() + ")start");
            new Thread(new ServerThread(socket)).start();
        }
    }
}
