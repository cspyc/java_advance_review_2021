package com.basicgrammer.base;

public class ArrayExercise01{
    public static void main(String[] args){
        //需求：创建一个char类型的26个元素的数组，分别 放置 'A'-'Z'.使用for循环访问所有元素并打印出来。提示：char类型数据运算 'A' + 2 -> 'C'
        //Tasking:
        // 1.声明并创建数组；
        // 2.利用for循环放置字母值；
        // 3.使用for循环访问所有元素并打印数组元素   abc[i] = (char)('A' + 1) //强制类型转换
        char[] abc = new char[26];
        for(char i = 'A',index = 0; i <= 'Z';i++, index++){            
            abc[index] = i;
           
        }
        //打印元素
        for(int i = 0;i < abc.length;i++){
            System.out.print(abc[i] + " ");
        }
    }
}