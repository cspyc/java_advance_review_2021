package com.basicgrammer.netprogramming.homework;

import com.sun.javafx.iio.ios.IosDescriptor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/15 09:46:05
 **/
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //需求：使用字符流的方式，编写一个客户端和服务器端程序
        //客户端发送"name",服务器端接收到后，返回"我是nova"，nova是你自己的名字
        //客户端发送"hobby",服务器端接收到后，返回"编写java程序"
        //不是这两个问题，回复"你说啥呢"
        IoStreamUtil ioStreamUtil = new IoStreamUtil();
        //服务器端，监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端已开启，正监听9999端口，等待连接.......");

        //开启通道准备接收客户端发送的数据
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = null;
        //读取客户端发送的消息
        String receiveMessage = ioStreamUtil.receiveMessageByBufferedReader(inputStream);
        if (receiveMessage != null) {
            String sendMessage = "";
            if ("name".equals(receiveMessage)) {
                sendMessage = "我是Nova";
            } else if ("hobby".equals(receiveMessage)) {
                sendMessage = "编写java程序";
            } else if ("exit".equals(receiveMessage)) {
                socket.close();
                serverSocket.close();
                System.out.println("客户端程序已退出，服务端程序同步退出......");
            } else {
                sendMessage = "你说啥呢......";
            }
//            ioStreamUtil.sendMessageByBufferedWriter(outputStream, sendMessage);
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write(sendMessage);
            bw.flush();

            socket.shutdownOutput();
        }
    }


}
