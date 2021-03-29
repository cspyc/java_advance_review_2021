package com.exercise.homework03;

/**
 * @author pi
 * @date 2021/03/25 16:54:53
 **/
public class AssociateProfessor extends Teacher{
    public AssociateProfessor(String name, int age, String post, double salary, double grade) {
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
