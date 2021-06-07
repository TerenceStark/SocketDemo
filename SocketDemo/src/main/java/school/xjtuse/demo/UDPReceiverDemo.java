package school.xjtuse.demo;

import java.io.IOException;
import java.net.*;

/*
UDP发送数据的步骤:
1:创建发送端的socket对象(DatagramSocket)
2:创建数据并把数据打包
3:调用DatagramSocket对象的方法发送数据
4:关闭发送端
*/

public class UDPReceiverDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] bytes = "sending message...".getBytes();
        InetAddress inetAddress = InetAddress.getByName("192.168.31.128");
        int port = 12345;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetAddress, port);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }

}
