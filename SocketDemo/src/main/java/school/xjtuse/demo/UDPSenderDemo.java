package school.xjtuse.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
UDP接收数据的步骤
1:创建接收端的Socket对象(DatagramSocket)
2:创建一个数据包，用于接收数据
3:调用DatagramSocket对象的方法接收数据
4:解析数据包，并把数据在控制台显示
5:关闭接收端
*/
public class UDPSenderDemo {
    public static void main(String[] args) throws IOException {
        int port = 12345;
        DatagramSocket datagramSocket = new DatagramSocket(port);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        datagramSocket.receive(datagramPacket);

        byte[] data = datagramPacket.getData();
        String dataString = new String(data, 0, data.length);

        datagramSocket.close();
    }

}
