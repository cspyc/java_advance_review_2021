package com.basicgrammer.base;

public class ClassAndObjectHomeWork13{
    public static void main(String[] args){
        //需求：将对象作为参数传递给方法
        //1.定义一个Circle类，包含一个double型的radius属性代表圆的半径， findArea()方法返回圆的面积；
        //2.定义一个类PassObject，在类中定义一个方法printAreas(),该方法的定义如下：public void printAreas(Circle c,int times) //方法签名
        //3.在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。例如：times为5，则输出半径 1，2，3，4，5,以及对应的圆面积
        //4.在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示
        //   Radius               findArea
        //   1.0                   3.1415926
        //   2.0                   12.5663706
        //   3.0                   28.27433388
        //   4.0                   50.265482457
        //   5.0                   78.53981633974483

        System.out.println("Radius \t findArea");
        Circle c = new Circle();
        PassObject p = new PassObject();
        p.printAreas(c,5);
    }
}

class Circle{
    private double radius;

    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }

    public void modifyCircleRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return Math.PI * radius * radius;
    }
}

class PassObject{
    public void printAreas(Circle c,int times) {
        for(int i = 1;i <= times;i++){
            c.modifyCircleRadius(i);
            System.out.print((double)i + "\t");
            System.out.println(c.findArea() + "\t");
        }
    }
}