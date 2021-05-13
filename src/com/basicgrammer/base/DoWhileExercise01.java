package com.basicgrammer.base;

public class DoWhileExercise01{
    public static void main(String[] args){
        //需求：打印 1-100值
        int i1 = 1;
        do{
            System.out.println(i1);
            i1++;
        }while(i1 <= 100);

        //需求：计算 1-100的和
        int j2 = 1;
        int sum = 0;
        do{
            sum += j2;
            j2++;
        }while(j2 <= 100);
        System.out.println("1-100的和等于：" + sum);
        
        //需求：统计1-200之间能被5整除，但不能被3整除的个数
        //Tasking
        int k3 = 1;
        int end = 200;
        int count = 0;
        do{
            if(k3 % 5 == 0 && k3 % 3 != 0){
                count++;
            }
            k3++;
        }while(k3 <= end);
        System.out.println("1-200之间能被5整除，但不能被3整除的个数:" + count);

    }
}