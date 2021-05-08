package com.basicgrammer.iostream.file;

import org.junit.Test;

import java.io.File;

/**
 * @author Pi
 * @date 2021-05-08 11:24
 */
public class FileDirectory_ {
    public static void main(String[] args) {

    }

    @Test
    public void should_create_dir_file_if_not_exist() throws Exception {
        String filePath = "e:\\a\\";
        File file = new File(filePath);

        //如果目录不存在就创建
        if (!file.exists()) {
            file.mkdir();
            System.out.println("创建目录成功！");
        } else {
            System.out.println("文件已经存在！");
        }
    }

    @Test
    public void should_delete_if_dir_is_exist() throws Exception {
        String filePath = "e:\\a\\";
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        } else {
            file.delete();
        }

        if (!file.exists()) {
            System.out.println("文件删除成功！");
        }
    }

    @Test
    public void should_create_dirs_if_dir_is_not_exist() throws Exception {
        String filePath = "e:\\a\\b\\c";
        File file = new File(filePath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("多级目录创建成功");
            } else {
                System.out.println("多级目录创建失败");
            }
        } else {
            System.out.println("目录已存在");
        }
    }

    @Test
    public void should_delete_dirs_if_dir_exist() throws Exception {
        String filePath = "e:\\a\\b\\c";
        File file = new File(filePath);
        if (file.exists()) {
            //多级目录，使用file.delete()只能删除一层目录
            if (file.delete()) {
                System.out.println("多级目录删除成功");
            } else {
                System.out.println("多级目录删除失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }


}
