package com.basicgrammer.collection_;

import java.util.*;

/**
 * @author Pi
 * @date 2021-04-18 21:39
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map employees = new HashMap();
        EmployeeMap e1 = new EmployeeMap("小王", 10000, 1);
        EmployeeMap e2 = new EmployeeMap("小小", 20000, 2);
        EmployeeMap e3 = new EmployeeMap("小二", 30000, 3);

        employees.put(e1.getId(), e1);
        employees.put(e2.getId(), e2);
        employees.put(e3.getId(), e3);

        //使用keySet遍历
        System.out.println("=======使用keySet遍历======");
        Set keys = employees.keySet();
        for (Object key : keys) {
            EmployeeMap employee = (EmployeeMap) employees.get(key);
            if (employee != null) {
                double salary = employee.getSalary();
                if (salary > 18000) {
                    System.out.println(employee);
                }
            }
        }

        //使用entrySet遍历
        System.out.println("======使用entrySet遍历=======");
        Set entrySet = employees.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;

//            EmployeeMap employee = (EmployeeMap) employees.get(entry.getKey());
            EmployeeMap employee = (EmployeeMap) entry.getValue();
            if (employee != null) {
                double salary = employee.getSalary();
                if (salary > 18000) {
                    System.out.println(employee);
                }
            }

        }


    }
}

class EmployeeMap {
    private String name;
    private double salary;
    private int id;

    public EmployeeMap(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeMap{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }


    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
