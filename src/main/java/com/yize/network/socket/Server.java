package com.yize.network.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(8888);
        while (true){
            //服务器阻塞线程，准备接受
            Socket socket=serverSocket.accept();
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            System.out.println("Server Receive Message:"+sb.toString());
//            //关掉输入流
            socket.shutdownInput();
            reader.close();
            //获取输出流
            OutputStream os=socket.getOutputStream();
            String response="Time:"+System.currentTimeMillis()+"\tserver has receive message";
            os.write(response.getBytes());
            os.flush();
//            //必须要先停掉输出，再关闭输出
//            socket.shutdownOutput();
            os.close();
        }

    }
}
