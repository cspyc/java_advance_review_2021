package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:08:51
 **/
public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printAnnual() {
        System.out.print("工人\t");
        super.printAnnual();
    }
}
