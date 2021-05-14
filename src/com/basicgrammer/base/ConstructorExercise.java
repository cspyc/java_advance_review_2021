package com.basicgrammer.base;

public class ConstructorExercise{
    public static void main(String[] args){
        //需求：定义一个Person类，定义两个构造器：第一个无参构造器：利用构造器设置所有人的age属性初始值都为18；
        //      第二个带pName和pAge两个参数的构造器：使得每次创建Person对象的同时，初始化对象的age属性和name属性值。分别使用不同的构造器，创建对象。
        Person_ p = new Person_();
        System.out.println("Person对象 p的年龄为：" + p.age);

        Person_ p1 = new Person_("jacky",18);
        System.out.println("Person对象 p1的姓名为：" + p1.name + " ,年龄为： " + p1.age);
    }
}

class Person_ {
    String name;
    int age;

    public Person_(){
        age = 18;
    }

    public Person_(String pName, int pAge){
        name = pName;
        age = pAge;
    }
}
