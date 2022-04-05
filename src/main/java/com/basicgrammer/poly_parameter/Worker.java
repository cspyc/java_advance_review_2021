package com.basicgrammer.poly_parameter;

/**
 * @author pi
 * @date 2021/03/24 16:45:13
 **/
public class Worker extends Employee{

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println("普通工人 " + this.getName() + "正在工作。。。。。。");
    }

    @Override
    public double getAnnual(){
        return super.getAnnual();
    }
}
