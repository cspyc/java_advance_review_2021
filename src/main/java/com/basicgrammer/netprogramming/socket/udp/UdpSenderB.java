package com.basicgrammer.netprogramming.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author pi
 * @date 2021/05/14 22:07:46
 **/
public class UdpSenderB {
    public static void main(String[] args) throws Exception {

        //1.建立发送通道,创建DatagramSocket对象，准备发送和接收数据，准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        //2.打包要发送的数据
        byte[] sendData = "hello,明天吃火锅！".getBytes();
        //封装的 DatagramPacket对象  data内容字节数组，data.length,主机(IP),端口 InetAddress.getLocalHost()
        DatagramPacket packet = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("PYC"), 9999);

        socket.send(packet);

        //3.接收消息
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        receiveData = receivePacket.getData();
        System.out.println("发送端B，接收到回复消息：" + new String(receiveData, 0, receiveData.length));

        //3.关闭连接
        socket.close();
    }
}
