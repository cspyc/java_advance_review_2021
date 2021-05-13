package com.basicgrammer.base;

public class ArithmeticOperatorExercise02{
    public static void main(String[] args){
     //1.需求：假如还有59天放假，问：合xx个星期零xx天
     //2.分析 tasking
     // 59天包含多少个星期的天数，及不够组成一个星期的天数
     //3.动手编码 
     int days = 59;
     int week = days / 7;
     int leftDays = days % 7;
     System.out.println("还有 "+ days + " 天放假，合 " + week + " 个星期，零 " + leftDays + " 天");

    //1.需求：定义一个变量，保存华氏温度，华氏温度转换摄氏温度的公式为：5 / 9 * (华氏温度-100)，求出华氏温度对应的摄氏温度
    //2.分析 tasking
    //  定义一个double变量，保存华氏温度；根据公式，求出摄氏温度
    //3.动手编码
    double fahrengheitDegree = 190.0;
    double centigrade = 5.0 / 9.0 * (fahrengheitDegree - 100.0);//考虑数学公式与java的特性  5/9 数学角度： 0.555，java角度：直接转换成int 成为 0
    System.out.println("华氏温度为：" + fahrengheitDegree +" ℉,对应摄氏温度为：" + centigrade + "℃");


    }
}