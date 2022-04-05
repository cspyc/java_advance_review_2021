package com.basicgrammer.netprogramming.socket.tcpfilecopy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/14 14:24:36
 **/
public class TcpFileCopyClient {
    public static void main(String[] args) {
        //需求：服务器端在8888端口监听；客户端，发送一张图片/home/pi/Pictures/容器的概念.png，保存到src下，发送“收到图片”再退出
        //服务器端在收到服务端发送的"收到图片"，再退出
        //需要封装一个工具类StreamUtils
        Socket socket = null;
        BufferedOutputStream bufferedOutputStream = null;
        InputStream inputStream = null;
        try {
            //1.创建Socket对象连接服务器端
            socket = new Socket(InetAddress.getLocalHost(), 8888);

            //2.读取文件到数据管道，发送送到服务器端
            OutputStream outputStream = socket.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            //先读取文件
            String file = "/home/pi/Pictures/容器的概念.png";
            //实现方式一
//            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
//            byte[] readCache = new byte[1024];
//            int readLength = 0;
//            while ((readLength = bufferedInputStream.read(readCache)) != -1) {
//                //写到与服务器的连接流中
//                bufferedOutputStream.write(readCache, 0, readLength);
//            }
//            bufferedOutputStream.flush();

            //实现方式二
//            StreamUtils.readFromInputStreamAndWriteToOutputStream(bufferedInputStream, bufferedOutputStream,
//                    new FileInputStream(file), outputStream);

            //实现方式三
            // readData数组  就是读取的file对应的字节数据
            byte[] readData = StreamUtils.readDataIntoByteArray(new BufferedInputStream(new FileInputStream(file)));
            //将数据写到socket数据通道
            bufferedOutputStream.write(readData);
            bufferedOutputStream.flush();

            //3.关闭连接输出
            socket.shutdownOutput();

            //4.读取服务端发送的信息
            inputStream = socket.getInputStream();
//            bufferedInputStream = new BufferedInputStream(inputStream);
//            byte[] readCache2 = new byte[1024];
//            int readLength2 = 0;
//            while ((readLength2 = bufferedInputStream.read(readCache2)) != -1) {
//                System.out.println(new String(readCache2, 0, readLength2));
//            }
            //方式二
            System.out.println(StreamUtils.streamToString(inputStream));

            //5.关闭输入连接
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }

                if (socket != null) {
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("客户端程序退出！");
        }
    }
}
