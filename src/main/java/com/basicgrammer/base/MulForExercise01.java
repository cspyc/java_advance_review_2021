package com.basicgrammer.base;

import java.util.Scanner;

public class MulForExercise01{
    public static void main(String[] args){
       //需求：统计3个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分[学生成绩从键盘输入]
       //     统计三个班及格人数，每个班有5名同学

       //Tasking:
       //先 计算 一个班，再算多个班
       // 1. 3个班，每个班5名同学，两层循环，以班为单位接收结果并计算相关参数
       // 先按班循环，3个班，3次循环；每个班，5名同学，循环5次
       // 为每个班总分，设置一个变量，接收并计算总分，最后计算平均分
       // 为每个班统计及人数 
       double classOneScore = 0;
       double classTwoScore = 0;
       double classThreeScore = 0;
       
       int classOnePassedCount = 0;
       int classTwoPassedCount = 0;
       int classThreePassedCount = 0;

       final double passedScore = 60.0;

       Scanner scoreInput = new Scanner(System.in);
       for(int studyClass = 1; studyClass <= 3; studyClass++){
           System.out.println("-------开始输入 " + studyClass + " 班学生成绩---------");
           
           for(int student = 1; student <= 5; student++){
               System.out.println("-------请输入 " + studyClass + " 班,第 " + student + " 个学生成绩---------");
               double score = scoreInput.nextDouble();
               
               if(studyClass == 1){
                   classOneScore += score;
                   if(score >= passedScore) {
                       classOnePassedCount++;
                   }
               }

               if(studyClass == 2){
                   classTwoScore += score;
                   if(score >= passedScore) {
                       classTwoPassedCount++;
                   }
               }

               if(studyClass == 3){
                   classThreeScore += score;
                   if(score >= passedScore) {
                       classThreePassedCount++;
                   }
               }
           }
       } 

       double classOneAverageScore = classOneScore / 5;
       double classTwoAverageScore = classTwoScore / 5;
       double classThreeAverageScore = classThreeScore / 5;
       double allClassAverageScore = (classOneScore + classTwoScore + classThreeScore) / 15;
       System.out.println("1班平均分为：" + classOneAverageScore);
       System.out.println("2班平均分为：" + classTwoAverageScore);
       System.out.println("3班平均分为：" + classThreeAverageScore);
       System.out.println("所有班级平均分为：" + allClassAverageScore);
       System.out.println("1班及格人数为：" + classOnePassedCount);
       System.out.println("2班及格人数为：" + classTwoPassedCount);
       System.out.println("3班及格人数为：" + classThreePassedCount);

    }
}