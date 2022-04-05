package com.basicgrammer.iostream.inputstream_;

import com.basicgrammer.iostream.outputstream.Dog;

import java.io.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Pi
 * @date 2021-05-10 11:37
 * 演示使用ObjectInputStream实现反序列化
 */
public class ObjectInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void test_deserialize() {
        String file = "e:\\data.dat";
        ObjectInputStream or = null;

        try {
            or = new ObjectInputStream(new FileInputStream(file));
//            ow = new ObjectOutputStream(new FileOutputStream(file));
//            ow.writeInt(100);//int -> Integer(实现了Serializable接口)
//            ow.writeBoolean(true);//boolean -> Boolean
//            ow.writeChar('P');//char -> Character
//            ow.writeFloat(1.1f);//float -> Float

//            //序列化对象
//            ow.writeObject(new Dog("小黄", 2));
            //反序列化
            System.out.println(or.readInt());
            System.out.println(or.readBoolean());
            System.out.println(or.readChar());
            System.out.println(or.readFloat());

            //反序列化对象
            Object dog = or.readObject();
            System.out.println("对象类型==" + dog.getClass());
            System.out.println(dog);

            //如果希望调用Dog的方法，需要向下转型
            //对于Dog对象的定义，需要放在可以被序列化代码及反序列化代码都能访问到的位置
            Dog dog1 = (Dog) dog;
            System.out.println(dog1.getName() + "-============-" + dog1.getAge());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (or != null) {
                try {
                    or.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
