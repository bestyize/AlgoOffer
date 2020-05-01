package com.yize.network.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        while (true){
            Thread.sleep(1000);
            Socket socket=new Socket("192.168.5.113",8888);
            OutputStream os=socket.getOutputStream();
            String request="Time:"+System.currentTimeMillis()+"\tClient send message";
            os.write(request.getBytes());
            os.flush();
//            socket.shutdownOutput();
            os.close();
            InputStream is=socket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
//            socket.shutdownInput();
            reader.close();
            is.close();
        }
    }
}
