package com.basicgrammer.base;

public class ControlExercise09{
    public static void main(String[] args){
        //需求：求出1 + (1+2) + (1+2+3) + (1+2+3+4) + ... +(1+2+3+...+100)的结果
        //Tasking:
        //1.两层循环；外层循环计算整个式子，100个数相加；
        //2.内层循环：计算出每个相加项的结果
        int sum = 0;
        for(int i = 1; i <= 100;i++){
            int addItem = 0;
            for(int j = 1;j <= i;j++){
                addItem += j;
            }
            sum += addItem;
        }
        System.out.println("1 + (1+2) + (1+2+3) + (1+2+3+4) + ... +(1+2+3+...+100)的结果为：" + sum);

    }
}