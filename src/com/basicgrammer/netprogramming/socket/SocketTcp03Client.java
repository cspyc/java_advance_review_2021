package com.basicgrammer.netprogramming.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 11:01:04
 **/
public class SocketTcp03Client {
    public static void main(String[] args) {
        //需求：客户端向服务端监听的本机9999端口发送消息"hello,server",接收服务端发送的消息，再退出
        //使用字符流

        Socket socket = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            //1.创建与服务端的Socket连接
            socket = new Socket(InetAddress.getLocalHost(), 9999);

            //2.向服务端发送消息
            //字节流 - 转换流 - 字符流
            OutputStream outputStream = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("hello,server");
            //插入一个换行符，表示写入的内容结束,使用这个结束标识，需要对方使用readLine()读取数据，否则无法读取到此结束标识
            writer.newLine();
            //如果使用字符流，需要手动刷新，否则数据不会写入数据通道
            writer.flush();

            //发送数据后，需要一个结束标记
//            socket.shutdownOutput();

            //3.接收服务端的消息，并打印
            InputStream inputStream = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String content = "";
            while ((content = reader.readLine()) != null) {
                System.out.println(content);
            }

            //接收数据后，需要一个结束标记
//            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("客户端退出");
        }
    }
}
