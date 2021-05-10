package com.basicgrammer.iostream.write_;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Pi
 * @date 2021-05-09 23:05
 */
public class BufferedWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void test_buffered_writer() {
        String file = "e:\\ok.txt";
        BufferedWriter bufferedWriter = null;

        try {
            //说明:
            //1. new FileWriter(filePath, true) 表示以追加的方式写入
            //2. new FileWriter(filePath) , 表示以覆盖的方式写入
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write('H');
            //换行
            bufferedWriter.newLine();
            bufferedWriter.write("学习IO流", 0, 5);
            bufferedWriter.newLine();
            bufferedWriter.write("抓紧时间的同时，要放平心态".toCharArray(), 0, 13);
            bufferedWriter.newLine();
            bufferedWriter.write("好好学习");
            bufferedWriter.newLine();
            bufferedWriter.write("虽然不一定能找到好工作，但还是要努力朝目标前进".toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
