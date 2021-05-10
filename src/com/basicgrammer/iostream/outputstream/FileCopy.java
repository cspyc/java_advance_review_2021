package com.basicgrammer.iostream.outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pi
 * @date 2021-05-09 09:51
 */
public class FileCopy {
    public static void main(String[] args) {
        //读入文件
        String inputFile = "e:\\WDS.png";
        FileInputStream inputStream = null;
        String outputFile = "d:\\WDS.png";
        FileOutputStream outputStream = null;

        int inputData = 0;
        byte[] readInputByte = new byte[1024];
        List<Integer> dataList = new ArrayList<>();
        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile, true);
            while ((inputData = inputStream.read(readInputByte)) != -1) {
                //将读入的数据，重新输出到另外的地方
                //边读边写
                outputStream.write(readInputByte, 0, inputData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流与输出流，释放资源
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
