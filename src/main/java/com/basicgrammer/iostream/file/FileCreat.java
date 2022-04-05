package com.basicgrammer.iostream.file;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Pi
 * @date 2021-05-07 16:39
 */
public class FileCreat {

    @Test
    public void create_file_way1() {
        File file = new File("e:\\newFile1.txt");
        try {
            file.createNewFile();
            System.out.println("创建文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create_file_way2() {
        File parentFile = new File("e:\\");
        String fileName = "newFile2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("创建文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create_file_way3() {
        String parentPath = "e:\\";
        String fileName = "newFile3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("创建文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
