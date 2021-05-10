package com.basicgrammer.iostream.inputstream_;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Pi
 * @date 2021-05-08 17:53
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示读取文件...
     * 单个字节的读取，效率比较低
     * -> 使用 read(byte[] b)
     */
    @Test
    public void test_file_input_stream_1() throws Exception {
        //定义读取文件路径
        String filePath = "e:\\newFile1.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        int readData = 0;
        //定义输入流
        try {
            fileInputStream = new FileInputStream(file);
            //读取文件内容
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 演示，每次读入自定义的字节数的数据
     *
     * @throws Exception
     */
    @Test
    public void test_file_input_stream2() {
        String filePath = "e:\\newFile1.txt";
        FileInputStream fileInputStream = null;

        //读入的字节
        byte[] readDataByte = new byte[8];
        int readLen = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            // //从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //            //如果返回-1 , 表示读取完毕
            //            //如果读取正常, readLen 返回实际读取的字节数
            while ((readLen = fileInputStream.read(readDataByte)) != -1) {
                System.out.print(new String(readDataByte, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
