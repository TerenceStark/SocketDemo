package school.xjtuse.tcp;


/*
客户端:发送数据，接收服务器反馈
*/

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.31.218", 10086);

        System.out.println("connecting to server..");
        System.out.println(socket);

        //数据来自键盘录入
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("username:");
        String username = bufferedReader.readLine();
        System.out.println("password:");
        String password = bufferedReader.readLine();

        //数据来自文件
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("B:\\SocketDemo\\src\\main\\java\\school\\xjtuse\\tcp\\input.txt"));

        //输出流，写数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(username);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.write(password);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //接收服务器反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data;

        String line;
        while (true) {
            if ((data = brClient.readLine()) != null) {
                System.out.println("FROM SERVER(" +socket.getRemoteSocketAddress()+"):"+ data);
            }
            if ((line = bufferedReader.readLine()) != null) {
                if (line.equals("exit") || line.equals("quit")) {
                    socket.shutdownOutput();
                    break;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

        //socket.shutdownOutput();

        //bufferedWriter.close();
        socket.close();
    }

}
