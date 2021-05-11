package com.basicgrammer.iostream.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Pi
 * @date 2021-05-11 14:31
 */
public class PropertiesReader {
    public static void main(String[] args) {
        //读取配置文件
        FileReader fileReader = null;
        try {
            //1. 创建Properties 对象
            Properties properties = new Properties();
            //2. 加载指定配置文件
            fileReader = new FileReader("src/mysql.properties");
            properties.load(fileReader);
            //3. 把k-v显示控制台
            properties.list(System.out);
            //4. 根据key 获取对应的值
            System.out.println(properties.getProperty("user"));
            System.out.println(properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
