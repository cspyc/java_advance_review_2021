package com.basicgrammer.base;

public class ClassAndObjectHomeWork05{
    public static void main(String[] args){
        //需求：定义一个圆类Circle，定义属性：半径，提供显示圆周长功能的方法，提供显示圆面积的方法
        double radius = 1;
        Circle_ a = new  Circle_(radius);
        double aCircleArea = a.caculateCircleArea();
        double aCircumference = a.caculateCircumference();
        System.out.println("圆半径为: " + radius + "时，圆周长为：" + aCircumference + ",圆面积为：" + aCircleArea);

    }
}

class Circle_{
    private double radius;

    public Circle_(){}
    public Circle_(double radius){
        this.radius = radius;
    }

    public double caculateCircumference(){
        return 2 * Math.PI * this.radius;
    }

    public double caculateCircleArea(){
        return Math.PI * this.radius * this.radius;
    }
}