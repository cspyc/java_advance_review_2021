package com.basicgrammer.base;

import java.util.Scanner;

public class RecursionExercise01{
    public static void main(String[] args){
        //需求：请使用递归的方式求出斐波那契数  1,1,2,3,5,8,13....给出一个整数n，求出它的值是多少
        //Tasking:
        // 1. 斐波那契数规律，从第三个数开始，n > 2, An = A(n-1) + A(n-2)
        // 2. 定义一个整数n , 一个方法fibonacci(),n作为方法入参，返回斐波那契数列，第n位数的值

        System.out.println("您想知道Fibonacci数列，第几位的数值？请输入：");        
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        Fibonacci f = new Fibonacci();
        int result = f.getFibonacci(n);
        System.out.println("Fibonacci数列，第 " + n + " 位数值为：" + result);
    }
}

class Fibonacci {

     int getFibonacci(int n) {
            if(n > 2) {
                return getFibonacci(n - 1) + getFibonacci(n - 2); 
            }
            return 1;
        }
}