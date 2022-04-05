package com.basicgrammer.base;

import java.util.Scanner;

public class Input{
   public static void main(String[] args){
       //步骤：
       //1.引入Scanner类；
       //2.创建Scanner对象；
       //3.接收用户输入
       Scanner input = new Scanner(System.in);
       System.out.println("请输入名字：");
       String name = input.next();

       System.out.println("请输入年龄：");
       int age = input.nextInt();

       System.out.println("请输入薪水：");
       double salary = input.nextDouble();

       System.out.println("详细信息如下： 姓名：" + name +"，年龄：" + age + ",薪水：" + salary);       

   } 
}