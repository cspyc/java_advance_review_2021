package com.basicgrammer.base;

public class ClassAndObjectHomeWork07{
    public static void main(String[] args){
        //需求：设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。并创建对象，进行测试(提示 this.属性)
        Dog d = new Dog("小黄","黄色",3);
        System.out.println(d.show());
    }
}

class Dog{
    private String name;
    private String color;
    private int age;

    public Dog(){}

    public Dog(String name,String color,int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String show(){
        return "小狗的名字为：" + this.name; + ", 颜色为：" + this.color + ",年龄为：" + this.age;
    }
}