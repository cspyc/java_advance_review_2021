package com.basicgrammer.netprogramming.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author pi
 * @date 2021/05/14 22:07:34
 **/
public class UdpReceiverA {
    public static void main(String[] args) throws Exception {
        //需求：接收端A在9999端口等待接收数据(receive)
        //发送端B向接收端A发送数据"hello,明天吃火锅~"
        //接收端A接收到 发送端B发送的数据，回复"好的，明天见"，再退出
        //发送端接收 回复的数据，再退出

        //1.设置监听端口，开始监听
        DatagramSocket socket = new DatagramSocket(9999, InetAddress.getLocalHost());

        //2.接收消息
        //UDP协议中，每个数据包最大的数据为64K (1024 * 64)
        byte[] receiveData = new byte[1024];
        DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
        //调用接收方法，将通过网络传输的DatagramPacket对象
        //当有数据包发送到9999端口时，就会接收到数据，如果没有数据包发送到9999端口，那就会阻塞等待
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);
        //把package 进行拆包，取出数据，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println("接收端A,接收到的消息：" + s);

        //3.发送消息
        byte[] sendData = "好的，明天见！".getBytes();
        packet = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("PYC"), 9998);
        socket.send(packet);

        //3.关闭连接
        socket.close();
    }
}
