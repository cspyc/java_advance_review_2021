package com.object.poly_parameter;

/**
 * @author pi
 * @date 2021/03/24 16:45:25
 **/
public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println("经理 " + this.getName() + "正在进行管理工作。。。。。。");
    }

    @Override
    public double getAnnual(){
        return super.getAnnual() + bonus;
    }
}
