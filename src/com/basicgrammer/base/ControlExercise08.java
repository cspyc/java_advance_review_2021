package com.basicgrammer.base;

public class ControlExercise08{
    public static void main(String[] args){
        //需求：求出1-1/2+1/3-1/4.....1/100的和
        //Tasking:
        // 1. 分母为 1~100循环；
        // 2. 分两组计算，分母为偶数时，符号为负；分母为奇数时，符号为正 
        // 3.注意点：公式的分子需要写成1.0,否则分数的结果都为0
        double sum = 0;
        for(int i = 1;i <= 100;i++) {
            if(i % 2 == 0){
                sum -= (1.0/i);
            }else {
                sum += (1.0/i);
            }
        }

        System.out.println("1 - 1/2 + 1/3 - 1/4 .....1/100的和为：" + sum);
    }
}