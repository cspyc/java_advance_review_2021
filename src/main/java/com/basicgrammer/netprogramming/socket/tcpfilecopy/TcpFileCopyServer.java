package com.basicgrammer.netprogramming.socket.tcpfilecopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 12:10:22
 **/
public class TcpFileCopyServer {
    public static void main(String[] args) {
        //需求：服务器端在8888端口监听；客户端，发送一张图片e:\\WDS.png，保存到src下，发送“收到图片”再退出
        //服务器端在收到服务端发送的"收到图片"，再退出
        //需要封装一个工具类StreamUtils
        //使用BufferedInputStream 和 BufferedOutputStream字节流

        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.服务端监听8888端口，等待客户端连接
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端 正在监听 本地8888端口，等待客户端连接......");

            //2.获取Socket对象
            socket = serverSocket.accept();

            //3.接收客户端图片信息，保存到src目录
            String path = "src/wdsCopied.png";
            InputStream inputStream = socket.getInputStream();
//            bufferedInputStream = new BufferedInputStream(inputStream);
//            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/wdsCopied.png"));
//            int readLength = 0;
//            byte[] readCache = new byte[1024];
//            while ((readLength = bufferedInputStream.read(readCache)) != -1) {
//                bufferedOutputStream.write(readCache, 0, readLength);
//            }
//            bufferedOutputStream.flush();

//            StreamUtils.readFromInputStreamAndWriteToOutputStream(bufferedInputStream,bufferedOutputStream,
//                    inputStream,new FileOutputStream("src/wdsCopied.png"));
            //从socket中读取数据
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = StreamUtils.readDataIntoByteArray(bufferedInputStream);
            //保存数据写到文件
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();

            //4.接收数据完毕，关闭输入流
            socket.shutdownInput();

            //5.发送“收到图片”信息到客户端
            OutputStream outputStream = socket.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write("收到图片".getBytes());
            //把内容刷新到socket数据管道
            bufferedOutputStream.flush();

            //6.关闭输出流
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }

                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
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

            System.out.println("服务端程序退出！");
        }
    }
}
