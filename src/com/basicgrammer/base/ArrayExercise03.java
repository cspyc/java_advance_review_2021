package com.basicgrammer.base;

import java.util.Scanner;

public class ArrayExercise03{
    public static void main(String[] args){
       //需求：求出一个数组的和以及平均值
       //Tasking:
       // 1.创建数组，保存一组输入的数值；先确定输入几个，后面循环输入数组元素；
       // 2.循环，求和，最后求平均值 

        Scanner input = new Scanner(System.in);
        System.out.println("请确认即将输入的数组大小：");
        int arrayNum = input.nextInt();

        int[] inputArray = new int[arrayNum];
        for(int i = 0;i < arrayNum;i++){
            System.out.println("请输入第 " + (i + 1) + "个数组元素： ");
            inputArray[i] = input.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < inputArray.length;i++){
            sum += inputArray[i];
        }

        double average = sum / inputArray.length;

        System.out.println("数组元素的和为：" + sum);
        System.out.println("数组元素的平均值为：" + average);
    }
}