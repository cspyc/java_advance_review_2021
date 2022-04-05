package com.basicgrammer.base;

import java.util.Scanner;

public class IfExercise02{
    public static void main(String[] args){
        //编写一个程序，定义两个变量int，判断二者的和，是否能被3，又能被5整除，打印提示信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个int数值：");
        int num1 = input.nextInt();
        
        System.out.println("请输入第二个int数值:");
        int num2 = input.nextInt();

        int sum = num1 + num2;
        System.out.println("输入的两个数之和为:" + sum);

        if((sum % 3 == 0) && (sum % 5 == 0)){
           System.out.println("输入的两个数之和既能被3整除，又能被5整除 ");
        }else{
           System.out.println("输入的两个数之和不能既被3整除，又被5整除 ");
        }
        System.out.println("程序继续......");
    }
}