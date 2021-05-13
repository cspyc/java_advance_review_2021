package com.basicgrammer.base;

public class MulForExercise02{
    public static void main(String[] args){
        //打印九九乘法表
        // 1 * 1 = 1
        // 1 * 2 = 2    2 * 2 = 4
        // 1 * 3 = 3    2 * 3 = 6   3 * 3 = 9
        // ......
        for(int i = 1;i <= 9; i++){
            for(int j = 1;j <= i; j++){
                if(i == j){
                    System.out.println(j + " * " + i + " = " + (i * j));
                }else {
                    System.out.print(j + " * " + i + " = " + (i * j) + "\t" );
                }
            }
        }
    }
}