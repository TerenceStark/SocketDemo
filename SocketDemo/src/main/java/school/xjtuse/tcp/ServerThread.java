package school.xjtuse.tcp;

import school.xjtuse.user.User;
import school.xjtuse.user.UserDB;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String username = bufferedReader.readLine();
            String password = bufferedReader.readLine();
            User user = new User(username, password);
            List<User> users = UserDB.getUsers();

            //判断集合中是否包含客服端发过来的user对象 使用contains放法 注意重写equals方法
            boolean flag = false;
            if (users.contains(user)) flag = true;
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            if (flag) {
                bufferedWriter.write("login success, please input data");
            } else {
                bufferedWriter.write("login failure, please exit and try again.");
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();

            /*给客户端反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bwServer.write("success");
            bwServer.newLine();
            bwServer.flush();
            */

            BufferedReader brServer = new BufferedReader(new InputStreamReader(System.in));
            String data;

            BufferedWriter bufferedWriterTxt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\jin0805\\Desktop\\计算机网络\\Socket实验\\SocketDemo\\src\\main\\java\\school\\xjtuse\\tcp\\output.txt", true)));
            String line;
            while (true) {
                if ((line = bufferedReader.readLine()) != null && flag) {
                    System.out.println("FROM CLIENT(" + socket.getRemoteSocketAddress() + "): " + line);
                    bufferedWriterTxt.write("FROM CLIENT(" + socket.getRemoteSocketAddress() + "): " + line);
                    bufferedWriterTxt.newLine();
                    bufferedWriterTxt.flush();
                    bufferedWriter.write("success");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
/*                if ((data = brServer.readLine()) != null) {

                }*/
            }

//            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
