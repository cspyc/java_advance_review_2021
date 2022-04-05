package com.basicgrammer.base;

import java.util.Scanner;

public class ControlExercise04{
    public static void main(String[] args){
        //需求：判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。例如:153 = 1*1*1 + 3*3*3 + 5*5*5;
        //Tasking:
        // 1.接收一个输入的整数；
        // 2.获取每个位数上的整数字
        // 3.加入验证，如果少于3位数，直接结束程序，报出提示
        // 4.将3个位数上的数字，进行立方再相加的运算；
        // 5.判断结果是否与原输入的数字相等，如果相等，则说明是水仙花数
        
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个3位数:");
        int number = input.nextInt();

        //验证是否为3位数
        while(true){
            if((number / 100 > 10) || (number / 100 < 1)){
                System.out.println("输入的数字不是3位数,请重新输入：");
                number = input.nextInt();            
            }else{
                break;
            } 
        }
        //获取每个位数上的整数字
        //获取个位上的数 number % 10,除模取余
        int lastPositionNumber = number % 10;
        //获取百位上的数 number / 100，商
        int firstPositionNumber = number / 100;
        //获取十位上的数 number % 100, (余数 - 个位上的数) / 10
        int middlePositionNumber = ((number % 100) - lastPositionNumber) / 10;

        int sum = lastPositionNumber * lastPositionNumber * lastPositionNumber + middlePositionNumber * middlePositionNumber * middlePositionNumber 
        + firstPositionNumber *  firstPositionNumber * firstPositionNumber;

        if(sum == number){
            System.out.println("输入的数字为：" + number + "，是水仙花数");
        }else {
            System.out.println("输入的数字为:" + number + ", 不是水仙花数");
        }
    }
}