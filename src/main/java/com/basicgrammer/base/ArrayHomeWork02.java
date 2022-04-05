package com.basicgrammer.base;

public class ArrayHomeWork02{
    public static void main(String[] args){
        //需求：随机生成10个整数(1-100的范围)保存到数组，并倒序打印以及求平均值、求最大值和最大值的下标、并查找里面是否有8
        //Tasking:
        // 1.使用随机方法，生成一个数组；
        // 2.倒序打印，是指需要按数值从大到小打印？还是按数组从尾部打印到前面即可？
        // 3.计算平均值，int sum / length
        // 4.找出最大值，及最大值的下标；max maxIndex
        // 5.查找是否有8

        int[] arr = new int[10];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random() * 100) + 1;
        }

        //打印
        System.out.println("倒序打印数组数据：");
        int sum = 0;
        int max = 0;
        int maxIndex = 0;
        boolean isExistEight = false;
        for(int i = arr.length - 1;i >= 0;i--){
            System.out.print(arr[i] + " ");
            sum += arr[i];
            
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }

            if(arr[i] == 8){
                isExistEight = true;
            }
        }

        //求平均值
        double arrAverage = sum / arr.length;
        System.out.println("");
        System.out.println("数组元素平均值：" + arrAverage);
        System.out.println("数组内最大值为：" + max + ",最大值下标为：" + maxIndex);
        System.out.println("数组内是否存在8:" + isExistEight);
    }
}