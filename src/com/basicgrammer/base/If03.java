package com.basicgrammer.base;

import java.util.Scanner;

public class If03{
    public static void main(String[] args){
        //需求:编写一个程序，
        //输入保国同志的芝麻信用分：
        //如果：
        //1.信用分为100分时，输出 信用极好；
        //2.信用分为(80,99]时，输出信用优秀；
        //3.信用分为[60,80]时，输出信用一般；
        //4.其他情况，输出 信用 不及格
        //请从键盘输入保国的芝麻信用分，并加以判断

        //Tasking:
        //1.从键盘获取输入值；Scanner point
        //2.判断输入的分类属于哪个区间，输出对应的值

        Scanner input = new Scanner(System.in);
        System.out.println("请输入保国同志的芝麻信用分(1-100)：");
        int point = input.nextInt();
        
        //先对输入的信用分，进行一个范围的有效判断 1-100，否则提示输入错误
        if(point >= 1 && point <= 100){
            if(point == 100){
            System.out.println("信用极好！");
            }else if(point > 80 && point <= 99){
            System.out.println("信用优秀！");
            }else if(point >= 60 && point <= 80){
                System.out.println("信用一般！");
            }else{
                System.out.println("信用不及格");
            }
        }else{
            System.out.println("输入的信用分有误，请重新输入！");
        }
        System.out.println("程序继续......");
    }
}