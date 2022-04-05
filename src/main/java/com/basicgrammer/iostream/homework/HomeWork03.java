package com.basicgrammer.iostream.homework;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author Pi
 * @date 2021-05-11 15:29
 */
public class HomeWork03 {
    public static void main(String[] args) {
        //编写一个dog.properties
        //name=tom
        //age=5
        //color=red
        //编写Dog类(name,age,color)创建一个dog对象，读取dog.properties用相应的内容完成属性初始化，并输出
        //将创建的Dog对象，序列化到文件dog.dat文件中
        String propertiesFile = "src\\dog.properties";
        String serializeFile = "src\\dog.dat";
        Properties properties = new Properties();
        FileReader fileReader = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileReader = new FileReader(propertiesFile);
            properties.load(fileReader);

            // 读取dog.properties用相应的内容完成属性初始化
            String name = properties.getProperty("name");
            String age = properties.getProperty("age");
            String color = properties.getProperty("color");
            Dog dog = new Dog(name, Integer.parseInt(age), color);
            System.out.println("dog=========" + dog);

//            创建的Dog对象，序列化到文件dog.dat文件中
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(serializeFile));
            objectOutputStream.writeObject(dog);
            System.out.println("将dog对象序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //在编写一个方法，反序列化dog
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "src\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog) ois.readObject();

        System.out.println("===反序列化后 dog====");
        System.out.println(dog);
        ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
