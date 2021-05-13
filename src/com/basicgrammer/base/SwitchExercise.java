package com.basicgrammer.base;

import java.util.Scanner;

public class SwitchExercise{
    public static void main(String[] args){
        //1.需求：使用switch把小写类型的char型转为大写(键盘输入)。只转换a,b,c,d,e,其它输出"other"
        //Tasking:
        //  1.获取输入的字符；
        //  2.使用swith语句，匹配输出相应的字母大写

        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个小写字母字符:");
        char englishChar = input.next().charAt(0);

        switch(englishChar){
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("other");
        }
        //2.需求：对学生成绩大于60分的，输出"合格"，低于60分的，输出"不合格"。（注：输入的成绩不能大于100），提示:成绩/60
       
        System.out.println("请输入分数值:");
       
        int score = input.nextInt();
        int scoreValue = score / 60; 

        if(score > 100 || score < 0) {
            System.out.println("输入的分数不正确！");
        }else{
            switch(scoreValue){
                case 1:
                    System.out.println("合格");
                    break;
                default:
                    System.out.println("不合格");
            }
        }

        //3.根据用于指定月份，打印该月份所属的季节。3，4，5春季，6，7，8夏季，9，10，11秋季，12，1，2冬季(使用穿透)
        System.out.println("请输入一个月份:");
        int month = input.nextInt();

        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季"); 
            default:
                System.out.println("输入的月份不对！");
        }
    }
}