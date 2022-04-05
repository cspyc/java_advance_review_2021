package com.basicgrammer.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pi
 * @date 2021-04-17 17:21
 */
public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //需求：创建3个Dog{name,age}对象，放入到ArrayList中，赋给List引用
        // 用迭代器和增强for循环两种方式来遍历
        //重写Dog的toString方法，输出name 和 age

        List dogs = new ArrayList();
        dogs.add(new Dog("小白", 1));
        dogs.add(new Dog("毛毛", 5));
        dogs.add(new Dog("阿黄", 3));

        System.out.println("=====迭代器循环======");
        Iterator iterator = dogs.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next.toString());
        }

        System.out.println("=====增加for循环=======");
        for (Object o : dogs) {
            System.out.println(o.toString());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
