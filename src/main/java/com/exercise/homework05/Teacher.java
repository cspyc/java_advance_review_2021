package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:09:27
 **/
public class Teacher extends Employee{
    private int classDays;
    private double classDaySalary;

    public Teacher(String name, double salary, int classDays, double classDaySalary) {
        super(name, salary);
        this.classDays = classDays;
        this.classDaySalary = classDaySalary;
    }

    @Override
    public double calculateBaseAnnualSalary() {
        return super.calculateBaseAnnualSalary() + (this.classDays * this.classDaySalary);
    }

    @Override
    public void printAnnual() {
        System.out.print("教师\t");
        super.printAnnual();
    }
}
