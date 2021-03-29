package com.exercise.homework13;

/**
 * @author pi
 * @date 2021/03/26 11:22:11
 **/
public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学。");
    }

    @Override
    public String play() {
        return super.play() + "爱玩象棋";
    }

    public void printInfo() {
        System.out.println("老师的信息：");
        System.out.println(super.basicInfo());
        System.out.println("工齡：" + this.work_age);
        this.teach();
        System.out.println(this.play());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}' + super.toString();
    }
}
