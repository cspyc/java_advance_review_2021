package com.exercise.homework13;

/**
 * @author pi
 * @date 2021/03/26 11:21:21
 **/
public class Student extends Person {
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play() {
        return super.play() + "爱玩足球";
    }

    public void printInfo() {
        System.out.println("学生的信息：");
        System.out.println(super.basicInfo());
        System.out.println("学号：" + this.stu_id);
        this.study();
        System.out.println(this.play());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                '}' + super.toString();
    }
}
