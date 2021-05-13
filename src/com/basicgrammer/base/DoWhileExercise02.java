package com.basicgrammer.base;

import java.util.Scanner;

public class DoWhileExercise02{
    public static void main(String[] args){
        //需求 如果李三不还钱，则老韩将一直使出闪电五连鞭，直到张三说还钱为止 [System.out.println("韩大师问：还钱吗？ y/n")] do...while...
        //Tasking
        //1.先输出问话；
        //2.获取键盘输入值，作为循环条件判断：y/n
        //3.张三回答y,跳出循环，如果张三回答n，则一直循环，执行闪电五连鞭

        char answer = 'n';
        do{
            System.out.println("韩大师对使张三出闪电五连鞭......");
            System.out.println("韩大师问张三：还钱吗？ y/n");

            System.out.println("张三回答道：(y/n)");

            Scanner inputAnswer = new Scanner(System.in);
            answer = inputAnswer.next().charAt(0);

        }while(answer != 'y');
        
        System.out.println("韩大师拿钱收工......");
    }
}