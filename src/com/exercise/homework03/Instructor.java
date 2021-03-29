package com.exercise.homework03;

/**
 * @author pi
 * @date 2021/03/25 16:55:26
 **/
public class Instructor extends Teacher {
    public Instructor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String introduce() {
        return super.introduce();
    }
}
