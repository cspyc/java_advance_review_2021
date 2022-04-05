package com.exercise.homework04;

/**
 * @author pi
 * @date 2021/03/25 17:14:32
 **/
public class Worker extends Employee {
    public Worker(String name, double dayRate, int workDays, double salaryGrade) {
        super(name, dayRate, workDays, salaryGrade);
    }


    @Override
    public void printSalary() {
        System.out.print("普通员工\t");
        super.printSalary();
    }
}
