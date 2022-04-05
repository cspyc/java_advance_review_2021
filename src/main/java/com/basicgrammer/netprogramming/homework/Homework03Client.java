package com.basicgrammer.netprogramming.homework;

import com.basicgrammer.netprogramming.socket.tcpfilecopy.StreamUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pi
 * @date 2021/05/15 17:27:26
 **/
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        //需求：客户端输入一个音乐文件名，比如 高山流水，服务端接收到音乐名后，可以给客户端返回这个音乐文件
        //如果服务器没有这个文件，返回一个默认的音乐文件即可
        //客户端收到文件后，保存到本地e:\\
        //该程序可以使用StreamUtils.java

        //开启与服务器的连接通道
        Socket socket = new Socket(InetAddress.getByName("PYC"), 9999);

        //读取输入文件
        System.out.println("请输入要下载的音乐文件名：");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(fileName.getBytes());
        bufferedOutputStream.flush();
        socket.shutdownOutput();


        //读取服务器端发送的文件
        byte[] musicData = StreamUtils.readDataIntoByteArray(socket.getInputStream());
        socket.shutdownInput();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/media/pi/DATA/" + fileName + ".mp3"));
        bos.write(musicData);
        bos.flush();

        bos.close();
        bufferedOutputStream.close();
        socket.close();

    }
}
