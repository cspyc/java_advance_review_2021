package com.basicgrammer.iostream.file;

import java.io.File;

/**
 * @author Pi
 * @date 2021-05-08 11:12
 */
public class FileInfo {
    public static void main(String[] args) {
        File file = new File("e:\\newFile1.txt");

        System.out.println("文件名称===" + file.getName());
        System.out.println("文件绝对路径===" + file.getAbsolutePath());
        System.out.println("文件父目录===" + file.getParent());
        System.out.println("文件大小===" + file.length());
        System.out.println("文件是否存在===" + file.exists());
        System.out.println("这个是否是文件===" + file.isFile());
        System.out.println("这个是否是目录===" + file.isDirectory());

    }
}
