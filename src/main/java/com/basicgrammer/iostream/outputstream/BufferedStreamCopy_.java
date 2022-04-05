package com.basicgrammer.iostream.outputstream;

import org.junit.Test;

import java.io.*;

/**
 * @author Pi
 * @date 2021-05-10 10:20
 * 演示使用BufferedInputStream和BufferedOutputStream来拷贝图片等二进制文件
 * 字节流既可以操作二进制文件，也可以操作文本文件
 */
public class BufferedStreamCopy_ {
    public static void main(String[] args) {
        //需求：拷贝文件
    }

    @Test
    public void copy_picture() {
        String srcFile = "e:\\WDS.png";
        String destFile = "d:\\WDS.png";
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;

        try {
            //FileInputStream继承了InputStream;FileOutputStream继承了OutputStream
            bi = new BufferedInputStream(new FileInputStream(srcFile));
            bo = new BufferedOutputStream(new FileOutputStream(destFile));
            //读取文件
            int readLength = 0;
            byte[] readData = new byte[1024];
            while ((readLength = bi.read(readData)) != -1) {
                bo.write(readData, 0, readLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bi != null) {
                    bi.close();
                }
                if (bo != null) {
                    bo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
