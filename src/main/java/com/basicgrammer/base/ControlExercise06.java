package com.basicgrammer.base;

public class ControlExercise06{
    public static void main(String[] args){
        //需求：输出 1-100之间的不能被5整除的数，每5个一行
        //Tasking:
        // 1.遍历1-100之间的数；
        // 2.找到不能被5整除的数；
        // 3.打印，每5个一行，定义一个计数器变量，每累计到5，换行打印   另一种思路：count % 5 == 0
        int counter = 1;
        for(int i = 1;i <= 100;i++) {
            if(i % 5 != 0){
                if(counter == 5){
                    System.out.println(i);
                    counter = 0;//重置计数器，注意边界值
                }else{
                    System.out.print(i + " ");
                }
                counter++;
            }
        }
    }
}