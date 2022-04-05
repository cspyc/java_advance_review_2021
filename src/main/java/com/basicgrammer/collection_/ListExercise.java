package com.basicgrammer.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pi
 * @date 2021-04-17 18:59
 */
public class ListExercise {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //需求：添加10个以上的元素(比如：String "hello"),在2号位插入一个元素"韩顺平教育"；
        //获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合
        //  使用List实现类ArrayList完成

        List elements = new ArrayList();
        for (int i = 0; i < 10; i++) {
            elements.add("hello----" + i);
        }

        System.out.println("=====原数组元素========");
        System.out.println(elements.toString());

        elements.add(1, "hspjy");
        System.out.println("=====在2号位插入元素后======");
        System.out.println(elements.toString());

        System.out.println("第五个元素：" + elements.get(4));

        elements.remove(5);
        System.out.println("删除第6个元素后：" + elements.toString());

        elements.set(6,"修改第7个元素");
        System.out.println("修改第7个元素后：" + elements.toString());

        System.out.println("使用迭代器遍历集合");
        Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
