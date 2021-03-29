package com.exercise.homework10;

/**
 * @author pi
 * @date 2021/03/26 10:54:21
 **/
public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Tom", 30, "主治医师", '男', 10000);
        Doctor doctor1 = new Doctor("Tom", 30, "主治医师", '男', 10000);
        System.out.println(doctor.equals(doctor1));
    }
}
