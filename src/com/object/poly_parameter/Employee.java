package com.object.poly_parameter;

/**
 * @author pi
 * @date 2021/03/24 16:45:02
 **/
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getAnnual() {
        return 12 * salary;
    }
}
