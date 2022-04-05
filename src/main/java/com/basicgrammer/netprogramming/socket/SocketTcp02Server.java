package com.basicgrammer.netprogramming.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 11:01:17
 **/
public class SocketTcp02Server {
    public static void main(String[] args) {
        //需求：服务端监听9999端口，服务端接收到客户端发送的消息并打印出来后，向客户端发送"hello,client",输出

        //1.监听本机9999端口，等待连接
        ServerSocket serverSocket = null;
        Socket socket = null;
        //读取IO
        InputStream inputStream = null;
        //发送消息
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("服务器端正在监听9999端口，等待连接.....");

            //2.接收到客户端连接，获取socket对象
            socket = serverSocket.accept();
            System.out.println("连接后，获取Socket对象：" + socket.getClass());

            //3.读取客户端发来的消息
            inputStream = socket.getInputStream();
            byte[] readCache = new byte[1024];
            int readLength = 0;
            while ((readLength = inputStream.read(readCache)) != -1) {
                System.out.println(new String(readCache, 0, readLength));
            }

            //接收数据后，需要一个结束标记
            socket.shutdownInput();

            //4.向客户端发送消息
            outputStream = socket.getOutputStream();
            outputStream.write("hello,client".getBytes());

            //发送数据后，需要一个结束标记
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
