package com.basicgrammer.base;

import java.util.Scanner;

public class If01{
    public static void main(String[] args){
        //编写一个程序，可以输入人的年龄，如果该同志的年龄大于18岁，则输出"你年龄大于18，要对自己的行为负责"
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = input.nextInt();
        
        if(age > 18){
           System.out.println("你年龄大于18，要对自己的行为负责");
        }
        System.out.println("程序继续......");
    }
}