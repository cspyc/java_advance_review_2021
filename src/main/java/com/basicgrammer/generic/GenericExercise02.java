package com.basicgrammer.generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author Pi
 * @date 2021-04-22 09:57
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("小王", 1000.1, new MyDate(1991, 11, 22)));
        employees.add(new Employee("小李", 2000, new MyDate(1999, 11, 23)));
        employees.add(new Employee("小李", 2003, new MyDate(1992, 12, 3)));

        //排序：先按照name排序，如果name相同，则按生日日期先后排序
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 != null && o1 != null)) {
                    return 0;
                }
                int compareName = o1.getName().compareTo(o2.getName());
                if (compareName != 0) {
                    return compareName;
                }

                //如果名字比较等于0,说明名字相同，再比较日期
                MyDate date1 = o1.getBirthday();
                MyDate date2 = o2.getBirthday();

                return date1.compareTo(date2);
            }
        });
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.sal, sal) == 0 && Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, birthday);
    }
}

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
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
    public int compareTo(MyDate o) {
        LocalDate date1 = LocalDate.of(this.getYear(), this.getMonth(), this.getDay());
        LocalDate date2 = LocalDate.of(o.getYear(), o.getMonth(), o.getDay());
        return date1.compareTo(date2);
    }
}
