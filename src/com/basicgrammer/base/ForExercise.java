package com.basicgrammer.base;

public class ForExercise{
    public static void main(String[] args) {
       //需求：打印 1~100之间所有是9的倍数的整数，统计个数及总和
       //Tasking:
       // 1.准备 1~100之间的数，遍历；
       // 2.找出所有9的倍数；
       // 3.计数   求和
       //从硬编码到考虑动态变化
       int count = 0;
       int sum = 0;
       int start = 1;
       int end = 100;
       int dividedNum = 9;
       for(int i = start;i <= end;i++){
           if(i % dividedNum == 0){
               System.out.println(i + "是9的倍数");
               count++;
               sum += i;
           }
       }
       System.out.println("1~100之间所有是9的倍数的整数，总共有 " + count + " 个，其总和为：" + sum);

       //需求：完成下面的表达式输出
       /*
        * 0 + 5 = 5
        * 1 + 4 = 5
        * 2 + 3 = 5
        * 3 + 2 = 5
        * 4 + 1 = 5
        * 5 + 0 = 5
        */ 
        int sumNumber = 5;
        for(int i = 0;i <= sumNumber;i++){            
            System.out.println(i + " + " + (sumNumber - i) + " = " + sumNumber);           
        }
    }
}