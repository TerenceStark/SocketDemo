package school.xjtuse.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP接收数据的步骤
1:创建服务器端的socket对象(ServerSocket)
2:获取输入流，读数据，并把数据显示在控制台
3:释放资源
*/
public class TCPReceiverDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9876);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        String data = new String(bytes, 0, inputStream.read(bytes));

        System.out.println("data is: " + data);

        socket.close();
        serverSocket.close();
    }
}
