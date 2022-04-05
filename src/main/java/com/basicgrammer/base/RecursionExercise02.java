package com.basicgrammer.base;

import java.util.Scanner;

public class RecursionExercise02{
    public static void main(String[] args){
        //需求：猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！以后每天猴子都吃其中的一半，然后再多吃一个。当到第10天时，想再吃时(即还没吃),发现只有1个桃子。
        //问题： 最初共有多少个桃子？
        //Tasking:  从10天开始，往前倒推
        //  1.假设每天吃之前拥有n个桃子； 
        //  2.day = 10，n = 1; n < 10,每天吃了  n/2 + 1;
        //  => 最初共有多少桃子 <=> day = 1时，求出n
        // day    总桃子数                              吃的桃子数
        //  1       n                                   n/2 + 1
        //  2      n -(n/2 + 1)                         (n -(n/2 + 1))/2 + 1
        //  3      (n-(n/2+1)) - (n -(n/2 + 1))/2 + 1   ....
        //  ....
        // 10       1
        //  n1 = 2n2 + 2  ... n9 = 2n10 + 2
        System.out.println("请输入需要查询每几天拥有的桃子数？请输入一个整数：");
        Scanner input = new Scanner(System.in);
        int day = input.nextInt();

        MokeyEatPeach peach = new MokeyEatPeach();
        int peaches = peach.getNumberOfPeaches(day);
        if(peaches != -1){
            System.out.println("第 " + day + " 天，有 " + peaches + " 个桃子！");
        }

    }

}

class MokeyEatPeach{

    public int getNumberOfPeaches(int day){
        if(day > 0 && day < 10){
            return 2 * getNumberOfPeaches(day + 1) + 2;
        }else if(day == 10){
            return 1;
        }else {
            System.out.println("天数应当在1-10天的范围内");
            return -1;
        }
    }
}