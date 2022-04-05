package com.basicgrammer.extend;

/**
 * @author pi
 * @date 2021/03/23 16:56:39
 **/
public class Person {
    private String name;
    private int age;

    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "我的名字叫：" + this.name + "，今年 " + this.age + "岁。";
    }
}

