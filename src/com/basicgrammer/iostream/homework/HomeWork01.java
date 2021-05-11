package com.basicgrammer.iostream.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Pi
 * @date 2021-05-11 15:06
 */
public class HomeWork01 {
    public static void main(String[] args) {
        //需求:判断e盘下是否有文件夹mytemp，如果没有就创建
        //在e:\\mytemp目录下，创建文件hello.txt
        //如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建
        //在hello.txt文件中，写入hello,world~

        String filePath = "e:\\mytemp";
        String fileName = "hello.txt";
        BufferedWriter bw = null;
        try {
            //判断目录是否存在
            File file = new File(filePath);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("目录创建成功");
                } else {
                    System.out.println("目录创建失败");
                }
            }
            File helloFile = new File(filePath + "\\" + fileName);
            if (!helloFile.exists()) {
                if (helloFile.createNewFile()) {
                    System.out.println("文件创建成功！");
                }
            } else {
                System.out.println("文件已经存在");
            }

            //在hello文件中写入hello，world~
            if (helloFile.exists()) {
                bw = new BufferedWriter(new FileWriter(helloFile));
                bw.write("hello,world");
                System.out.println("文字写入成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
