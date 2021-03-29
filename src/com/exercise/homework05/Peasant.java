package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:09:19
 **/
public class Peasant extends Employee {
    public Peasant(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printAnnual() {
        System.out.print("农民\t");
        super.printAnnual();
    }
}
