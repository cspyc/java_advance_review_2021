package com.basicgrammer.extend;

/**
 * @author pi
 * @date 2021/03/23 16:56:53
 **/
public class Student extends Person{
    private String id;
    private double score;

    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "我的学号是：" + this.id + ",考试分数是：" + this.score;
    }
}
