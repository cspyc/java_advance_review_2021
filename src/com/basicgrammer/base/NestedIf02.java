package com.basicgrammer.base;

import java.util.Scanner;

public class NestedIf02{
    public static void main(String[] args){
        //需求：出票系统：根据淡旺季的月份和年龄，打印票价
        // 4-10月 旺季：
        //      成人(18-60)：60
        //      儿童(<18):半价
        //      老人(>60):1/3
        // 淡季：
        //      成人：40
        //      其他：20
        //Tasking:
        //      1.获取输入的月份和年龄； int  int
        //      2.判断是旺季和淡季；再判断输入年龄属于什么年龄分组，确定票价
        Scanner input = new Scanner(System.in);
        
        System.out.println("请输入当前月份：");
        int month = input.nextInt();

        System.out.println("请输入游客年龄：");
        int age = input.nextInt();

        double price = 60;

        if(month > 0 && month < 13) {
            if(month > 4 && month < 10) {
                if(age >= 18 && age <= 60){
                    System.out.println("票价为：" + price);
                }else if(age > 60) {
                    System.out.println("票价为：" + (price / 3));
                }else if(age < 18) {
                    System.out.println("票价为：" + (price / 2));
                }
            }else{
                if(age >= 18 && age <= 60){
                    System.out.println("票价为：" + 40);
                }else{
                    System.out.println("票价为：" + 20);
                }  
            }
        }else{
            System.out.println("请输入有效的月份值！");
        }

    }
}