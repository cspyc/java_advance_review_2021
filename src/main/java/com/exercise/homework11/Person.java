package com.exercise.homework11;

/**
 * @author pi
 * @date 2021/03/26 11:03:43
 **/
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void run(){
        System.out.println(this.name + "正在奔跑......");
    }

    public void eat(){
        System.out.println(this.name + "正在吃东西......");
    }
}
