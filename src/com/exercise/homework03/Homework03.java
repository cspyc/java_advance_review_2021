package com.exercise.homework03;

/**
 * @author pi
 * @date 2021/03/25 17:01:14
 **/
public class Homework03 {
    public static void main(String[] args) {
        Teacher teacher = new Professor("King", 38, "教授", 10000,1.3);
        System.out.println(teacher.introduce());

        Teacher teacher1 = new Instructor("Tom", 38, "讲师", 6000,1.1);
        System.out.println(teacher1.introduce());
    }
}
