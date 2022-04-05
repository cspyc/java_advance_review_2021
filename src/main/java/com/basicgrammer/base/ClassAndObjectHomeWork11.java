package com.basicgrammer.base;

public class ClassAndObjectHomeWork11{
    public static void main(String[] args){
        //需求：在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的定义形式，调用语句为：System.out.println(method(method(10.0,20.0),100));
        MethodTest a = new MethodTest();
        a.methodTest();
    }
}

class MethodTest{
    public void methodTest(){
       System.out.println(method(method(10.0,20.0),100));
    }
    public double method(double a,double b){
        return 0.0;
    }
}