package com.basicgrammer.iostream.read_;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Pi
 * @date 2021-05-09 10:11
 */
public class FileRead_ {
    public static void main(String[] args) {

    }


    /**
     * 一个个字符读取
     */
    @Test
    public void read_char_by_char() {
        String file = "e:\\a.txt";
        FileReader fileReader = null;
        int readChar = 0;
        try {
            fileReader = new FileReader(file);
            //返回读取到的字符
            while ((readChar = fileReader.read()) != -1) {
                System.out.print((char) readChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按字符数组读
     */
    @Test
    public void read_by_char_array() {
        String file = "e:\\a.txt";
        FileReader fileReader = null;
        int readLength = 0;
        char[] chars = new char[1024];

        try {
            fileReader = new FileReader(file);
            //按设定的字符数组长度读取
            while ((readLength = fileReader.read(chars)) != -1) {
                //输出读取到的字符
                System.out.print(new String(chars, 0, readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
