package com.basicgrammer.base;

public class TwoDimensionalArray05{
    public static void main(String[] args){
        //需求：int arr[][]={{4,6},{1,4,5,7},{-2}}；遍历该二维数组，并得到和
        //Tasking:
        //  1. 静态初始化二维数组；
        //  2. 使用循环遍历二维数组，遍历元素的过程中求和
        int arr[][] = {{4,6},{1,4,5,7},{-2}};
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = 0; j < arr[i].length;j++){
                System.out.println("第 [" + (i+1)+"]["+(j+1)+"]个元素的值是：" + arr[i][j]);
                sum += arr[i][j];
            }
        }
        System.out.println("该二维数组所有元素的和为：" + sum);
    }
}