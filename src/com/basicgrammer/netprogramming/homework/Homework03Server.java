package com.basicgrammer.netprogramming.homework;

import com.basicgrammer.base.Input;
import com.basicgrammer.netprogramming.socket.tcpfilecopy.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/15 17:27:08
 **/
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        //需求：客户端输入一个音乐文件名，比如 高山流水，服务端接收到音乐名后，可以给客户端返回这个音乐文件
        //如果服务器没有这个文件，返回一个默认的音乐文件即可
        //客户端收到文件后，保存到本地e:\\
        //该程序可以使用StreamUtils.java

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端监听9999端口，等待连接......");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        String clientMessage = StreamUtils.streamToString(inputStream);
        socket.shutdownInput();

        String musicFile = "";
        if ("高山流水".equals(clientMessage)) {
            musicFile = "src/高山流水.mp3";
        } else {
            musicFile = "src/tankGameMusic.wav";
        }
        //读取音乐文件信息
        byte[] musicData = StreamUtils.readDataIntoByteArray(new FileInputStream(musicFile));

        //发送文件到连接管道
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(musicData);
        bufferedOutputStream.flush();

        socket.shutdownOutput();
        inputStream.close();
        bufferedOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
