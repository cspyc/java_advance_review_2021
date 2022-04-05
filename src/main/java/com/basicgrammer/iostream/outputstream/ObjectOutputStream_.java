package com.basicgrammer.iostream.outputstream;


import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Pi
 * @date 2021-05-10 11:29
 * 演示使用ObjectOutputStream，对基本数据类型及对象进行序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) {
    }

    @Test
    public void test_serialize_by_object_output_stream() {
        String file = "e:\\data.dat";

        ObjectOutputStream ow = null;
        try {
            //ObjectOutputStream也是包装流
            ow = new ObjectOutputStream(new FileOutputStream(file));
            ow.writeInt(100);//int -> Integer(实现了Serializable接口)
            ow.writeBoolean(true);//boolean -> Boolean
            ow.writeChar('P');//char -> Character
            ow.writeFloat(1.1f);//float -> Float

            //序列化对象
            ow.writeObject(new Dog("小黄", 2));

            System.out.println("序列化对象成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ow != null) {
                try {
                    ow.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
