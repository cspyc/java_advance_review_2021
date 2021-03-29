package com.exercise.homework11;

/**
 * @author pi
 * @date 2021/03/26 11:05:29
 **/
public class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println("学生：" + this.getName() + "正在奔跑.....");
    }

    public void study() {
        System.out.println("学生：" + this.getName() + " 正在学习......");
    }
}
