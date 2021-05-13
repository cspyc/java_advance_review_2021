package com.basicgrammer.base;

public class BreakExercise{
    public static void main(String[] args){
        //需求：1-100以内的数求和，求出 当和 第一次大于20的当前数
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            sum += i;
            if(sum > 20){
                System.out.println("第一次大于20的当前数为：" + i);
                System.out.println("第一次大于20的和为：" + sum);
                break;
            }
        }
    }
}