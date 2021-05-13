package com.basicgrammer.base;

public class ClassAndObjectHomeWork06{
    public static void main(String[] args){
        //需求：创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)，并创建两个对象，分别测试
        Cale a = new Cale(10,2);
        Double divResultA = a.divide();
        if(divResultA != null){
            System.out.println("10，2：两数之和为：" + a.add() + ", 两数之差为： " + a.minus() + ",两数之积为:" + a.mutiple() + "，两数之商为：" + divResultA);
        }
        Cale b = new Cale(15,5);
        Double divResult = b.divide();
        if(divResult != null){
            System.out.println("15,5:两数之和为：" + b.add() + ", 两数之差为： " + b.minus() + ",两数之积为:" + b.mutiple() + "，两数之商为：" + divResult);
        }
    }
}

class Cale{
    private double operateA;
    private double operateB;

    public Cale(){}
    public Cale(double operateA,double operateB){
        this.operateA = operateA;
        this.operateB = operateB;
    }

    public double add(){
        return operateA + operateB;
    }

    public double minus(){
        return operateA - operateB;
    }

    public double mutiple(){
        return operateA * operateB;
    }

    public Double divide(){
        if(operateB != 0){
            return operateA / operateB;
        }else{
            System.out.print("被除数不能为0");
            return null;
        }
    }

}