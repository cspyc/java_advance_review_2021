package com.basicgrammer.netprogramming.homework;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pi
 * @date 2021/05/15 09:46:29
 **/
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        IoStreamUtil ioStreamUtil = new IoStreamUtil();
        //开启与服务器的连接通道
        Socket socket = new Socket(InetAddress.getByName("PYC"), 9999);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bw = null;
        //循环输入，获取服务输入信息
        while (true) {
            //获取输入内容
            System.out.println("请输入发送到服务器端的信息：(退出程序：exit)");
            Scanner scanner = new Scanner(System.in);
            String sendMessage = scanner.next();

            //退出指令
            if ("exit".equals(sendMessage)) {
                System.out.println("退出客户端程序......");
//                ioStreamUtil.sendMessageByBufferedWriter(outputStream, "exit");
                bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                bw.write(sendMessage);
                bw.flush();
                bw.close();
                socket.close();
                break;
            }
            //使用字符流向服务器发送信息
//            ioStreamUtil.sendMessageByBufferedWriter(outputStream, sendMessage);
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write(sendMessage);
            bw.flush();
            socket.shutdownOutput();

            //接收信息，并打印到控制台
            String allContent = ioStreamUtil.receiveMessageByBufferedReader(inputStream);
            System.out.println("服务端应答：" + allContent);
        }
    }
}
