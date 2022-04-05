package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:10:17
 **/
public class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double salary) {
        super(name, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateBaseAnnualSalary() {
        return super.calculateBaseAnnualSalary() + this.bonus;
    }

    @Override
    public void printAnnual() {
        System.out.print("科学家\t");
        super.printAnnual();
    }
}
