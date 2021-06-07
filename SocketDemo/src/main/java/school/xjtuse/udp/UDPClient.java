package school.xjtuse.udp;

/*
UDP发送数据:数据来自于键盘录入，直到输入的数据是886，发送数据结束
UDP接收数据:因为接收端不知道发送端什么时候停止发送，故采用死循环接收
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("192.168.31.218");
        int port = 12345;

        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("Connecting to server.."+datagramSocket.getRemoteSocketAddress());


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("exit") || line.equals("quit")) {
                break;
            }

            byte[] bytes = line.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetAddress, port);

            datagramSocket.send(datagramPacket);
        }

        datagramSocket.close();
    }


}
