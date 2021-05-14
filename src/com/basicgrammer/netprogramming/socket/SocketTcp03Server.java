package com.basicgrammer.netprogramming.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 11:01:17
 **/
public class SocketTcp03Server {
    public static void main(String[] args) {
        //需求：服务端监听9999端口，服务端接收到客户端发送的消息并打印出来后，向客户端发送"hello,client",输出
        //使用字符流

        //1.监听本机9999端口，等待连接
        ServerSocket serverSocket = null;
        Socket socket = null;
        //读取IO
        BufferedReader bufferedReader = null;
        //发送消息
        BufferedWriter bufferedWriter = null;
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("服务器端正在监听9999端口，等待连接.....");

            //2.接收到客户端连接，获取socket对象
            socket = serverSocket.accept();
            System.out.println("连接后，获取Socket对象：" + socket.getClass());

            //3.读取客户端发来的消息
            //使用字符流-转换流
            InputStream inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String content = "";
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }

            //接收数据后，需要一个结束标记
//            socket.shutdownInput();

            //4.向客户端发送消息
            OutputStream outputStream = socket.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("hello,client");
            //插入一个换行符，表示写入的内容结束,使用这个结束标识，需要对方使用readLine()读取数据，否则无法读取到此结束标识
            bufferedWriter.newLine();
            //如果使用字符流，需要手动刷新，否则数据不会写入数据通道
            bufferedWriter.flush();

            //发送数据后，需要一个结束标记
//            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
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
