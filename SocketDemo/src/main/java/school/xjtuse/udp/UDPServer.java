package school.xjtuse.udp;

/*
UDP发送数据:数据来自于键盘录入，直到输入的数据是exit，发送数据结束
UDP接收数据:因为接收端不知道发送端什么时候停止发送，故采用死循环接收
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        int port = 12345;

        DatagramSocket datagramSocket = new DatagramSocket(port);

        System.out.println("Server initializing.."+datagramSocket.getLocalSocketAddress());

        while (true) {
            byte[] bytes = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            datagramSocket.receive(datagramPacket);

            System.out.println("FROM CLIENT("+datagramSocket.getRemoteSocketAddress()+"):" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        }

        //datagramSocket.close();
    }


}
