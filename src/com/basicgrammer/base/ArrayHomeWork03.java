package com.basicgrammer.base;

public class ArrayHomeWork03{
    public static void main(String[] args){
        //需求：冒泡排序的代码  -之前写过小数从后往前冒泡；这次写大数从后往前冒泡
        // Tasking:
        // 1.首先需要确认进行几轮排序，一般是 r =(待排序元素个数n-1)轮；
        // 2.每一轮进行多少次比较，一般是 c = n - 1 - r

        //动态随机生成一个数列
        int[] arr = new int[5];
        
        System.out.print("原始数组：");
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random() * 100) + 1;
            System.out.print(arr[i] + " ");
        }


        //冒泡排序，大数从前往后冒泡
        //比较的轮数
        for(int i = 0;i < arr.length -1;i++){
            //每轮需要比较的次数
            for(int j = 0; j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }                
            }
        }

        //输出排序后的数组：
        System.out.println("");
        System.out.print("排序后的数组：");
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}