package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:08:14
 **/
public class Employee {
    private String name;
    private double salary;
    private int salMonth = 12;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    public double calculateBaseAnnualSalary() {
        return this.salary * this.salMonth;
    }

    public void printAnnual() {
        System.out.println(this.name + "\t全年工资=" + this.calculateBaseAnnualSalary());
    }
}
