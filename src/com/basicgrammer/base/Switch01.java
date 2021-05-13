package com.basicgrammer.base;

import java.util.Scanner;

public class Switch01{
    public static void main(String[] args){

        //需求：编写一个程序，可以接收一个字符，比如：a,b,c,d,e,f,g
        // a表示星期一，b表示星期二，依此类推......
        // 根据用户的输入显示相应的信息。要求使用switch语句完成

        //Tasking:
        //  1.获取输入的字符；
        //  2.使用swith语句，匹配输出相应的星期

        System.out.println("请输入一个小写字母字符(a-g):");
        Scanner input = new Scanner(System.in);
        char weekChar = input.next().charAt(0);

        switch(weekChar){
            case 'a':
                System.out.println("星期一");
                break;
            case 'b':
                System.out.println("星期二");
                break;
            case 'c':
                System.out.println("星期三");
                break;
            case 'd':
                System.out.println("星期四");
                break;
            case 'e':
                System.out.println("星期五");
                break;
            case 'f':
                System.out.println("星期六");
                break;
            case 'g':
                System.out.println("星期日");
                break;
            default:
                System.out.println("无法识别");
        }
    }
}