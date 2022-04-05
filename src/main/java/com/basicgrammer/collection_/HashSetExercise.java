package com.basicgrammer.collection_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Pi
 * @date 2021-04-18 16:13
 */
@SuppressWarnings("all")
public class HashSetExercise {
    public static void main(String[] args) {
        Set employees = new HashSet();
        employees.add(new Employee("李三", 25));
        employees.add(new Employee("王五", 33));
        employees.add(new Employee("李三", 25));
//
//        Iterator iterator = employees.iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            System.out.println(next);
//        }
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[name:" + this.name + ",age:" + this.age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
