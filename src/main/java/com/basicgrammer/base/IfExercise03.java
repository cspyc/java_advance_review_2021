package com.basicgrammer.base;

import java.util.Scanner;

public class IfExercise03{
    public static void main(String[] args){
        //编写一个程序，判断一个年份是否是闰年，闰年的条件是符合下面两个条件之一：1.年份能被4整除，但不能被100整除；2.能被400整除

        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个代表年份的数值：");
        int year = input.nextInt();
        
        if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
           System.out.println("输入的年份值： " + year + ",是闰年");
        }else{
           System.out.println("输入的年份值： " + year + ",不是闰年");
        }
        System.out.println("程序继续......");
    }
}