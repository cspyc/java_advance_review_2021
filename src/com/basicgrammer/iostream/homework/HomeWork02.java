package com.basicgrammer.iostream.homework;

import java.io.*;

/**
 * @author Pi
 * @date 2021-05-11 15:20
 */
public class HomeWork02 {
    public static void main(String[] args) {
        //需求：使用BufferedReader读取一个文本文件，为每行加上行号
        //再连同内容一并输出到屏幕上
        String file = "e:\\a.txt";
        BufferedReader br = null;
        try {
//            br = new BufferedReader(new FileReader(file));
            //读取gbk编码的文件
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
            int lineNum = 0;
            String lineContent = "";
            while ((lineContent = br.readLine()) != null) {
                System.out.println(lineNum + "----------" + lineContent);
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
