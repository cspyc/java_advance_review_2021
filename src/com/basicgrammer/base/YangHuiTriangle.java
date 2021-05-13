package com.basicgrammer.base;

public class YangHuiTriangle{
    public static void main(String[] args){
        //需求：使用二维数组打印一个10行杨辉三角
        //          1
        //         1 1
        //        1 2 1
        //       1 3 3 1
        //      1 4 6 4 1
        //    1 5 10 10 5 1
        //   1 6 15 20 15 6 1
        //...
        //找到关键规律：从第三行开始，对于非第一个元素和最后一个元素的值 arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
        // 第n行有n个元素
        // 每行第一个和最后一个元素为1
        //Tasking:
        // 1.定义一个二维数组，10行n列，列数根据行数动态初始化；
        // 2.循环，固定设置每行第1个以及最后一个元素；
        // 3.根据关键规律，计算，非每行非第一个及最后一个元素
        int[][] arr = new int[10][];
        //行
        for(int i = 0; i < arr.length;i++){
            //初始化每行数列
            arr[i] = new int[i+1];
            //列
            for(int j = 0; j < arr[i].length;j++){
                //赋值第一个和最后一个元素的值
                if(j == 0 || j == arr[i].length - 1){
                    arr[i][j] = 1;
                }else{
                     //从第三行开始,除去第一个元素及最后一个元素的赋值
                     arr[i][j] = arr[i-1][j] + arr[i-1][j-1]; 
                }
            }
        }

        //输出
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            //换行
            System.out.println("");
        }
        
    }
}