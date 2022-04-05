package com.basicgrammer.netprogramming.homework;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author pi
 * @date 2021/05/15 13:46:15
 **/
public class Homework02ReceiverA {
    public static void main(String[] args) throws Exception {
        //需求：接收端A和发送端B，使用UDP协议完成
        //接收端在8888端口等待接收数据(receive)
        //发送端向接收端发送数据 “四大名著是哪些”
        //接收端 接收到 发送端 发送的问题后，返回"四大名著是《红楼梦》...."，否则返回what?

        //定义一个UDP通道，监听8888端口
        DatagramSocket socket = new DatagramSocket(8888, InetAddress.getByName("PYC"));

        //接收信息
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        String content = new String(bytes, 0, packet.getLength());
        String answer = "";
        if ("四大名著是哪些".equals(content)) {
            answer = "四大名著是《红楼梦》....";
        } else {
            answer = "what?";
        }

        //发送答案
        bytes = answer.getBytes();
        packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("PYC"), 8889);
        socket.send(packet);

        socket.close();

    }
}
