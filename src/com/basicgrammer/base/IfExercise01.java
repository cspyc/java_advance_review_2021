package com.basicgrammer.base;

import java.util.Scanner;

public class IfExercise01{
    public static void main(String[] args){
        //编写一个程序，声明2个double型变量并赋值。判断第一个数大于10.0，且第2个数小于20.0，打印两数之和
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个double数值：");
        double num1 = input.nextDouble();
        
        System.out.println("请输入第二个double数值:");
        double num2 = input.nextDouble();

        if(num1 > 10.0 && num2 < 20.0){
           System.out.println("num1 + num2 = " + (num1 + num2));
        }
        System.out.println("程序继续......");
    }
}