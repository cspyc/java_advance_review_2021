package com.basicgrammer.base;

import java.util.Scanner;

public class Starts{
    public static void main(String[] args){
        //需求：编写一个程序，可以接收一个整数，表示层数(totalLevel),打印出金字塔。
        //    *
        //   ***
        //  *****
        // *******
        //*********
        //Tasking:
        // 1.接收一个整数,表示要打印的层数
        // 2.打印"*"号，按层数，依次为1，3，5，7，9......
        // 3.打印空格:在每行的"*"号前，添加适当的空格，按层数依次为：<左，右>:<4,4>,<3,3>,<2,2>,<1,1>  规律：<总层数-1，总层数-1>，<总层数-2，总层数-2>...N-1层：<总层数-(总层数-1)，总层数(总层数-1）-1>
        // 4.打印空心金字塔：按层数，空心数依次为：0，1，3，5...... 1~(n-1)层
    
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要打印的金字塔层数：");
        int inputLevel = input.nextInt();

        int levelStartNumber = 1;
        for(int currentLevel = 1;currentLevel <= inputLevel; currentLevel++){
            //打空格
            int spaceNumber = 1;
            while(spaceNumber <= (inputLevel - currentLevel)){
                System.out.print(" ");
                spaceNumber++;
            }
            //打印*
            int printPosition = 1;
            while(printPosition <= levelStartNumber){
                if(currentLevel != 1 && currentLevel != inputLevel){
                    //每层每一个和最后一个打印"*",中间打印 空格
                    if(printPosition == 1 || printPosition == levelStartNumber){
                        System.out.print("*");
                    }else{
                        //打印空心
                         System.out.print(" ");
                    }   
                }else{
                    System.out.print("*");
                }   

                printPosition++;
            }
            
            System.out.println(" ");
            levelStartNumber += 2;
        }



    }
}