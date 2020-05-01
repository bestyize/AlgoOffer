package com.yize.network.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(8888);
        while (true){
            //�����������̣߳�׼������
            Socket socket=serverSocket.accept();
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            System.out.println("Server Receive Message:"+sb.toString());
//            //�ص�������
            socket.shutdownInput();
            reader.close();
            //��ȡ�����
            OutputStream os=socket.getOutputStream();
            String response="Time:"+System.currentTimeMillis()+"\tserver has receive message";
            os.write(response.getBytes());
            os.flush();
//            //����Ҫ��ͣ��������ٹر����
//            socket.shutdownOutput();
            os.close();
        }

    }
}
