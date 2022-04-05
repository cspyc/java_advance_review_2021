package com.basicgrammer.iostream.write_;


import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Pi
 * @date 2021-05-09 23:11
 */
public class BufferedCopy_ {
    public static void main(String[] args) {
        //需求：读取一个文本文件复制到另一个新文件
    }

    @Test
    public void copy_txt_file_by_buffered() {
        String srcFile = "e:\\a.txt";
        String destFile = "d:\\a.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String inputLine = "";

        try {
            //1. BufferedReader 和 BufferedWriter 是安装字符操作
            //2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
            //BufferedInputStream
            //BufferedOutputStream
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            bufferedWriter = new BufferedWriter(new FileWriter(destFile));
            while ((inputLine = bufferedReader.readLine()) != null) {
                //写到新文件
                bufferedWriter.write(inputLine);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
