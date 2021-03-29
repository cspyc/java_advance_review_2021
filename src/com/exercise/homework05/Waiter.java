package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:12:02
 **/
public class Waiter extends Employee{
    public Waiter(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printAnnual() {
        System.out.print("服务生\t");
        super.printAnnual();
    }
}
