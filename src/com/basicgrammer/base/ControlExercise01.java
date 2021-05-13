package com.basicgrammer.base;

public class ControlExercise01{
    public static void main(String[] args){
        //需求：编程实现如下功能：
        //某人有100，000元，每经过一次路口，需要交费，规则如下
        // 1.当现金>50000时，每次交5%；
        // 2.当现金<=50000时，每次交1000
        //计算该人可以经过多少次路口，要求：使用while break方式完成
    
        //Tasking:
        //1.设置一个变量，保存所有余额；
        //2.设置一个变量，保存经过的路口次数，每经过一次+1
        //3.循环，使用现金过路口，只要手中的余额>1000,都要尝试到下一个路口
        double balance = 100000;
        int roadCrossNum = 0;

        while(balance > 0){
            if(balance > 50000){
                balance = balance * (1-0.05);
            }else{
                balance -= 1000;
            }
            roadCrossNum++;
            if(balance < 1000){
                break;
            }
        }
        System.out.println("可以经过 " + roadCrossNum + " 次路口！");
        System.out.println("手中还剩 " + balance + " 元");


    }
}