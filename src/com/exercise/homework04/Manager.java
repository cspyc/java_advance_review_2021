package com.exercise.homework04;

/**
 * @author pi
 * @date 2021/03/25 17:15:42
 **/
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double dayRate, int workDays, double salaryGrade) {
        super(name, dayRate, workDays, salaryGrade);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + this.bonus;
    }

    @Override
    public void printSalary() {
        System.out.print("部门经理\t");
        super.printSalary();
    }
}
