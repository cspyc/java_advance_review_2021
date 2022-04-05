package com.basicgrammer.base;

import java.util.Scanner;

public class ArrayHomeWork01{
    public static void main(String[] args){
        //需求：已知有个升序的数组，需求插入一个元素，该数组顺序依然是升序，比如 [10,12,45,90],添加23后，数组为[10,12,23,45,90]
        //Tasking:
        // 1.静态初始化一个数组 a；
        // 2.接收用户输入的整数；
        // 3.新建一个大小为a.length + 1大小的新数组；
        // 4.遍历原数组，把原数组的元素保存到新数组，并在这个过程中，比较新输入的值与原数组的值，将其插入到合适的位置。

        //另一种思路：先定位，再扩容；找到插入的数值，在数组中的index；相当下面的实现，把问题分解了
        int[] arr = {10,12,45,90};

        System.out.print("原始数组为：[10,12,45,90]，请输入一个整数：");
        Scanner input = new Scanner(System.in);
        int insertNum = input.nextInt();

        int[] newArr = new int[arr.length + 1];
        boolean inserted = false;
        for(int i = 0;i < arr.length;i++){           
           if(insertNum <= arr[i]  && !inserted){
                newArr[i] = insertNum;
                newArr[i + 1] = arr[i];
                inserted = true; 
            }else if(insertNum <= arr[i] && inserted){
                newArr[i+1] = arr[i];
            }else{
                newArr[i] = arr[i];
                if(!inserted){
                    newArr[newArr.length - 1] = insertNum;
                }
            }           
        }

        //输出
        System.out.print("插入元素后的数组：[");
        for(int i = 0;i < newArr.length;i++){
            if(i != newArr.length - 1){
                System.out.print(newArr[i] + ",");
            }else{
                System.out.print(newArr[i]);
            }            
        }
        System.out.print("]");

    }
}