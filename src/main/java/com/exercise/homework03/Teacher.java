package com.exercise.homework03;

/**
 * @author pi
 * @date 2021/03/25 16:52:26
 **/
public class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;
    private double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public String introduce() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", grade=" + grade +
                '}';
    }
}
