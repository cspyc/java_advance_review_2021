package com.exercise.homework13;

/**
 * @author pi
 * @date 2021/03/26 11:24:03
 **/
public class Person {
    private String name;
    private char sex;
    private int age;

    public int getAge() {
        return age;
    }

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String play() {
        return this.name + "\t";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public String basicInfo() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex + "\n";
    }
}
