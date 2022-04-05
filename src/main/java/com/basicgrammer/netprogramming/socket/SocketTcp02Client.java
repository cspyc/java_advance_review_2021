package com.basicgrammer.netprogramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 11:01:04
 **/
public class SocketTcp02Client {
    public static void main(String[] args) {
        //需求：客户端向服务端监听的本机9999端口发送消息"hello,server",接收服务端发送的消息，再退出

        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //1.创建与服务端的Socket连接
            socket = new Socket(InetAddress.getLocalHost(), 9999);

            //2.向服务端发送消息
            outputStream = socket.getOutputStream();
            outputStream.write("hello,server".getBytes());

            //发送数据后，需要一个结束标记
            socket.shutdownOutput();

            //3.接收服务端的消息，并打印
            inputStream = socket.getInputStream();
            byte[] readCache = new byte[1024];
            int readLength = 0;
            while ((readLength = inputStream.read(readCache)) != -1) {
                System.out.println(new String(readCache, 0, readLength));
            }

            //接收数据后，需要一个结束标记
            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
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
