package com.basicgrammer.iostream.read_;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pi
 * @date 2021-05-09 15:48
 */
public class BufferedReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void read_file_by_bufferedReader() {
        String file = "e:\\a.txt";
        BufferedReader bufferedReader = null;
        char[] readData = new char[1024];
        int readDataLength = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((readDataLength = bufferedReader.read(readData)) != -1) {
                System.out.println(new String(readData, 0, readDataLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void read_file_line_by_line_by_bufferedReader() {
        String file = "e:\\a.txt";
        BufferedReader bufferedReader = null;

        String readLineData = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            //说明
            //1. bufferedReader.readLine() 是按行读取文件
            //2. 当返回null 时，表示文件读取完毕
            while ((readLineData = bufferedReader.readLine()) != null) {
                System.out.println(readLineData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
                    //FileReader。
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }

         */
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
