package com.basicgrammer.base;

/*
* 编程实现如下效果
  姓名  年龄    成绩    性别    爱好
  xx    xx      xx      xx  xx 
  要求：
  1. 用变量将姓名，年龄，成绩，性别，爱好存储
  2. 使用+运算符
  3.添加适当注释
  4.添加转义字符，使用一条语句输出 
*/
public class Homework01{
    public static void main(String[] args){
        String name = "Peter";
        int age = 23;
        double score = 87.5;
        char sex = '男';
        String hobby = "play basketball";

        System.out.print("姓名\t年龄\t成绩\t性别\t爱好\n" + name + "\t" + age + "\t" + score + "\t" + hobby);
    }
}