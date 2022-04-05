package com.basicgrammer.netprogramming.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 09:22:09
 **/
public class SocketTcp01Client {
    public static void main(String[] args) throws IOException {
        //1.发起连接:指定主机，端口
        //连接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());

        //2.发送消息
        //连接上后，生成Socket，通过socket.getOutputStream()
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());

        //3.关闭流与socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
