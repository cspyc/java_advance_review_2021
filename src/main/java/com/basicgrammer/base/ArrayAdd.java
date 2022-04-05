package com.basicgrammer.base;

import java.util.Scanner;

public class ArrayAdd{
    public static void main(String[] args){
        //需求：实现动态的给数组添加元素效果，实现对数组扩容。
        //     1.原数组使用静态分配 int[] arr = {1,2,3}
        //     2.增加的元素4，直接放在数组的最后 arr = {1,2,3,4}
        //     3.用户可以通过如下方法来决定是否继续添加，添加成功，是否继续？ y/n
        //Tasking:
        //  1.静态初始化一个数组；
        //  2.提示输入一个数组，添加到数组；
        //  3.创建一个比原数组大1的数组，将原数组的值复制到新数组，将需要添加的数，增加到新数组最后的位置；
        //  4.添加成功后，提示是否继续添加

        int[] arr = {1,2,3};
        char addNewElement = 'y';
       
        while(addNewElement == 'y') {
            System.out.println("请输入一个需要添加到数组尾部的整数：");
            Scanner input = new Scanner(System.in);
            int newElement = input.nextInt();

            //将原数组的值，复制到新数组            
            int[] newArr = new int[arr.length + 1];
            for(int i = 0;i < arr.length;i++){
                newArr[i] = arr[i];
            }
            //末尾增加新元素
            newArr[newArr.length - 1] = newElement;

            //将原始数组变量指向一个新建的数组，将添加元素后的新数组所有元素复制到这个新数组中去
            arr = new int[newArr.length];
            for(int i = 0;i < newArr.length;i++){
                arr[i] = newArr[i];
            }           

            System.out.println("添加成功，是否继续？ y/n");
            addNewElement = input.next().charAt(0);
        }

        System.out.println("添加元素后的新数组有如下值：");
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
}