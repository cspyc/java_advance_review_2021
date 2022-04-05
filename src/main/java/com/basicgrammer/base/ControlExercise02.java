package com.basicgrammer.base;

import java.util.Scanner;

public class ControlExercise02{
    public static void main(String[] args){
        //需求：实现判断一个整数，属于哪个范围：大于0；小于0；等于0
        //Tasking:
        // 1.获取一个输入的整数，并用一个int变量接收；
        // 2.使用多分支选择结构，判断输入数字与0的关系，并输出结果
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int inputNumber = input.nextInt();

        if(inputNumber > 0) {
            System.out.println("输入的数字为： " + inputNumber + " , 大于0");
        } else if(inputNumber < 0) {
            System.out.println("输入的数字为： " + inputNumber + " , 小于0");
        } else {
            System.out.println("输入的数字等于0");
        }

    }
}