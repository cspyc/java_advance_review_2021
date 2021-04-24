package com.basicgrammer.final_;

/**
 * @author pi
 * @date 2021/04/10 23:26:04
 **/
public class FinalExercise01 {
    public static void main(String[] args) {
        //需求：编写一个程序，能够计算圆形的面积。要求圆周率为3.14.赋值的位置3个方式都写一下
        Circle circle = new Circle(1);
        System.out.println(circle.getArea());
    }
}

final class Circle{
    private double radius;
    private final double PI = 3.14;

    public double getArea() {
        return PI * radius * radius;
    }

    public Circle(double radius) {
        this.radius = radius;
//        PI = 3.14;
    }

//    {
//        PI = 3.14;
//    }


}
