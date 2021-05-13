package com.basicgrammer.base;

public class OverLoadExercise01{
    public static void main(String[] args){
        //需求1：编写程序，类Methods中定义三个重载方法并调用。方法名为m。三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
        //在主类的main()方法中分别用参数区别调用三个方法
        
        //需求2:在Method类，定义三个重载方法max()，每一个方法，返回两个int值中的最大值，每二个方法，返回两个double值中的最大值，每三个方法，返回三个double值中的最大值，并分别调用三个方法

        Methods method = new Methods();
        method.m(3);
        method.m(2,5);
        method.m("好好学习，耐心细心！");

        int maxInt = method.max(2,5);
        System.out.println("2,5中的最大值为：" + maxInt);

        double maxDouble1 = method.max(1.1,2.1);
        System.out.println("1.1与2.1中的最大值为：" + maxDouble1);

        double maxDouble2 = method.max(1.2,7.2,3.1);
        System.out.println("1.2，3.1，7.2中的最大值为：" + maxDouble2);
    }
}

class Methods{
    void m(int a) {
        int result = a * a;
        System.out.println(result);
    }

    void m(int a, int b){
        int result = a * b;
        System.out.println(result);
    }

    void m(String a) {
        System.out.println(a);
    }

    int max(int a,int b) {
        if(a > b){
            return a;
        }else{
            return b;
        }
    }

    double max(double a,double b){
        if(a > b) {
            return a;
        }else{
            return b;
        }
    }

    double max(double a,double b,double c){
        double maxNumber = a;
        if(b > maxNumber) {
            maxNumber = b;
        }

        if(c > maxNumber){
            maxNumber = c;
        }
        return maxNumber;
    }
}