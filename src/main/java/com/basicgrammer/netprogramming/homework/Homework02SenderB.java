package com.basicgrammer.netprogramming.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author pi
 * @date 2021/05/15 13:46:28
 **/
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        //建立UDP连接
        DatagramSocket socket = new DatagramSocket(8889);

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入问题：");
        String s = scanner.next();
        //打包要发送的信息
        byte[] bytes = s.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("PYC"), 8888);
        socket.send(packet);

        //接收消息
        bytes = new byte[1024];
        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        System.out.println("收到服务器答复：" + new String(bytes, 0, packet.getLength()));

        socket.close();
    }
}
