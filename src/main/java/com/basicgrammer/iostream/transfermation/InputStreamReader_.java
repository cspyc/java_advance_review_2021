package com.basicgrammer.iostream.transfermation;

import org.junit.Test;

import java.io.*;

/**
 * @author Pi
 * @date 2021-05-10 17:06
 */
public class InputStreamReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void read_file_by_input_stream_reader() {
        String file = "e:\\note.txt";
        InputStreamReader isr = null;

        try {
            //1. 把 FileInputStream 转成 InputStreamReader
            //2. 指定编码 gbk
            //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
            //3. 把 InputStreamReader 传入 BufferedReader
            //BufferedReader br = new BufferedReader(isr);
            isr = new InputStreamReader(new FileInputStream(file), "gbk");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String lineData = "";
            while ((lineData = bufferedReader.readLine()) != null) {
                System.out.println(lineData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
