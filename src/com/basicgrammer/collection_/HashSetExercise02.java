package com.basicgrammer.collection_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Pi
 * @date 2021-04-18 17:29
 */
@SuppressWarnings({"all"})
public class HashSetExercise02 {
    public static void main(String[] args) {
        //需求：创建三个Employee对象放入HashSet中
        //当name 和 birthday的值相同时，认为是相同员工，不能添加到HashSet集合中

        Set employees = new HashSet();
        employees.add(new Employee02("小王", 28, 8000.0, new MyDate(1991, 2, 3)));
        employees.add(new Employee02("小李", 32, 2000.0, new MyDate(1991, 2, 3)));
        employees.add(new Employee02("小王", 22, 2000.0, new MyDate(1991, 2, 3)));

        System.out.println(employees);
    }
}

class Employee02 {
    private String name;
    private int age;
    private double sal;
    private MyDate birthday;

    public Employee02(String name, int age, double sal, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee02 that = (Employee02) o;
        return name.equals(that.name) && birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
