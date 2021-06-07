package school.xjtuse.demo;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP发送数据的步骤
1:创建客户端的socket对象(Socket)
2:获取输出流，写数据
3:释放资源
*/
public class TCPSenderDemo {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("192.168.31.218",9876);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("sending data...".getBytes());

        outputStream.close();
    }

}
