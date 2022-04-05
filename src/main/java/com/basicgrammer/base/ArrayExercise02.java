package com.basicgrammer.base;

public class ArrayExercise02{
    public static void main(String[] args){
        //需求：请求出一个数组int[]的最大值{4,-1,9,10,23},并得到对应的下标
        //Tasking:
        // 1.使用静态初始化，创建数组
        // 2.逐个元素进行对比，把最大的保存到一个变量，如果遇到更大的则赋值到变量，覆盖原先的值；同时保存下标
        int[] a =  {4,-1,9,10,23};
        int max = a[0];
        int maxIndex = 0;
        for(int i = 0;i < a.length;i++){
            if(a[i] > max){
                max = a[i];
                maxIndex = i;
            }
        } 
        System.out.println("数组中的最大值为：" + max +",其下标为：" + maxIndex);
    }
}