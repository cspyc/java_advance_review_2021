package com.basicgrammer.iostream.outputstream;


import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Pi
 * @date 2021-05-09 09:33
 */
public class FileOutputStream_ {
    public static void main(String[] args) {
    }

    @Test
    public void test_write_file() {
        String file = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //1. new FileOutputStream(filePath) 创建方式，当写入内容是，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容是，是追加到文件后面
//            fileOutputStream = new FileOutputStream(file);
            fileOutputStream = new FileOutputStream(file, true);
//            //输出一个字符
//            fileOutputStream.write('H');
            //输出字符串
//            String str = "Hello,World!";
//            fileOutputStream.write(str.getBytes());

            /*
            write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流
             */
            String str = "test ,java";
            fileOutputStream.write(str.getBytes(), 0, 4);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
