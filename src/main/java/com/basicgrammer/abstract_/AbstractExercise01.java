package com.basicgrammer.abstract_;

/**
 * @author pi
 * @date 2021/04/11 11:30:30
 **/
public class AbstractExercise01 {
    public static void main(String[] args) {
        Employee e = new CommonEmployee("小李", "111", 3000);
        System.out.println(e);
        e.work();

        Manager m = new Manager("王经理", "222", 10000, 10000);
        System.out.println(m);
        m.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    abstract void work();

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        ", salary=" + salary;
    }
}

class CommonEmployee extends Employee {

    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    void work() {
        System.out.println("普通员工" + this.getName() + "正在工作.....");
    }

    @Override
    public String toString() {
        return "CommonEmployee{" + super.toString() + "}";
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    void work() {
        System.out.println("经理" + this.getName() + "正在工作....");
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                ", bonus=" + bonus +
                '}';
    }
}
