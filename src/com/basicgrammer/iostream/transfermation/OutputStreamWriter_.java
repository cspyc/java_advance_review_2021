package com.basicgrammer.iostream.transfermation;

import org.junit.Test;

import java.io.*;

/**
 * @author Pi
 * @date 2021-05-10 17:32
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) {
    }

    @Test
    public void test_output_stream_writer() {
        String filePath = "e:\\outputStreamTest.txt";

        OutputStreamWriter osw = null;
        try {
            String charSet = "utf-8";
            osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
            String writeString = "赶紧学习呀.......";
            osw.write(writeString);
            System.out.println("按照 " + charSet + "保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
