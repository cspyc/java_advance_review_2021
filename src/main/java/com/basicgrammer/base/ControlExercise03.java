package com.basicgrammer.base;

import java.util.Scanner;

public class ControlExercise03{
    public static void main(String[] args){
        //需求：判断一个年份是否为闰年  判断标准：1.能整除4且不能整除100，2. 能整除400
        
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个年份:");
        int year = input.nextInt();

        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            System.out.println("输入的年份为： " + year + ", 是闰年");
        }else {
            System.out.println("输入的年份为： " + year + " ,不是闰年");
        }
    }
}