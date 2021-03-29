package com.exercise.homework04;

/**
 * @author pi
 * @date 2021/03/25 17:10:44
 **/
public class Employee {
    private String name;
    private double dayRate;
    private int workDays;
    private double salaryGrade;


    public Employee(String name, double dayRate, int workDays, double salaryGrade) {
        this.name = name;
        this.dayRate = dayRate;
        this.workDays = workDays;
        this.salaryGrade = salaryGrade;
    }

    public double calculateSalary() {
        return this.dayRate * this.workDays * this.salaryGrade;
    }

    public void printSalary() {
        System.out.println(this.name + "\t工资=" + this.calculateSalary());
    }
}
