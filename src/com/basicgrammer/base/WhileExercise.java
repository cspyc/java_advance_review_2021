package com.basicgrammer.base;

public class WhileExercise{
    public static void main(String[] args){
        //需求：打印1-100 之间所有能被3整除的数<使用while>
        //Tasking:
        //1. 准备 1-100之间的数，逐个循环遍历；
        //2. 找出能被3整除的数，打印出来；
        //3. 动态化，从硬编码->变量

        int i = 1;
        int end = 100; 
        int dividedNum = 3;
        while(i <= end) {
            if(i % dividedNum == 0) {
                System.out.println(i + " 能够被3整除！");               
            }
             i++;
        }

        //需求：打印 40-200之间所有的偶数(使用while)
        //Tasking:
        //1. 准备 40-200之间的数，逐个循环遍历；
        //2. 找出偶数=>能被2整除的数，打印出来；
        //3. 动态化，从硬编码->变量
        int start = 40;
        int end2 = 200;
        while(start <= end2){
            if(start % 2 == 0){
                System.out.println(start + "是偶数");
            }
            start ++;
        }
        
    }
}