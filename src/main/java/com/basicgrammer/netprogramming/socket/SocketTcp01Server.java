package com.basicgrammer.netprogramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 09:21:52
 **/
public class SocketTcp01Server {
    public static void main(String[] args) throws IOException {
        //1.服务端监听端口:监听9999接口,等待连接
        //要求在本机没有其它服务在监听9999
        //这个ServerSocket 可以通过accept()返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务端，在9999端口监听，等待连接......");

        //2.ServerSocket 建立连接
        //如果没有客户端连接9999端口时，会一直阻塞，直到有客户端socket连接
        Socket socket = serverSocket.accept();
        System.out.println("服务端建立Socket连接......");

        //3.读取消息
        //通过socket.getInputStream()读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();

        //通过IO读取数据
        byte[] readDataCache = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(readDataCache)) != -1) {
            System.out.println(new String(readDataCache, 0, readLength));
        }

        //4.关闭流，socket,serverSocket
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
