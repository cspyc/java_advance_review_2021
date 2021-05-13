package com.basicgrammer.base;

public class ControlExercise07{
    public static void main(String[] args){
        //需求：输出 小写的a-z以及大写的Z-A
        //Tasking:
        // 1.使用char，循环输出，a:97  Z:90   for(char c1 = 'a'; c1 <= 'z';c1++)
        for(char a = 97;a <= (97 + 25);a++){
            System.out.print(a + " ");
        }
        //for(char c1 = 'Z'; c1 >= 'A';c1--)
        for(char bigZ = 90; bigZ >= (90 - 25); bigZ--){
            System.out.print(bigZ + " ");
        }
    }
}