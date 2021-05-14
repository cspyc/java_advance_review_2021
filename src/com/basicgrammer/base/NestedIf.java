package com.basicgrammer.base;

import java.util.Scanner;

public class NestedIf{
    public static void main(String[] args){
        //需求：参加歌手比赛，如果初赛成绩大于8.0进入决赛，否则提示淘汰。并且根据性别提示进入男子组或女子组。输入成绩和性别，进行判断和输出信息
        //Tasking:
        //1.提示输入选手初赛成绩double和性别char，接收到输入值；
        //2.根据输入值，根据规则，输出不同提示

        Scanner input = new Scanner(System.in);

        System.out.println("请输入选手初赛成绩：");
        double score = input.nextDouble();
        
       
        if(score > 8.0){
            System.out.println("请输入选手性别：");
            char gender = input.next().charAt(0);
            if(gender == '男'){
                System.out.println("恭喜！进入男子组决赛！");
            }else if(gender == '女'){
                System.out.println("恭喜！进入女子组决赛！");
            }
        }else{
            System.out.println("对不起，被淘汰了！");
        }
        
    }
}