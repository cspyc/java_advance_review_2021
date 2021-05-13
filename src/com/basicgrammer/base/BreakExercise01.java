package com.basicgrammer.base;

import java.util.Scanner;

public class BreakExercise01{
    public static void main(String[] args){
        //需求：实现登录验证，有3次机会，如果用户名为“丁真”，密码“666”,提示登录成功。否则提示还有几次机会(使用 for + break实现)

        Scanner inputLogInfo = new Scanner(System.in);

        int inputLoginInfoChanceNum = 3;
        String logUserName = "丁真";
        String logUserPassWord = "666";

        for(int i = 1;i <= inputLoginInfoChanceNum;i++){
            System.out.println("请输入用户名：");
            String userName = inputLogInfo.next();
            
            System.out.println("请输入密码：");
            String password = inputLogInfo.next();    

            if(logUserName.equals(userName) && logUserPassWord.equals(password)){
                System.out.println("登录成功");
                break;
            }
            if((inputLoginInfoChanceNum - i) != 0){
                System.out.println("登录失败，您还有 " + (inputLoginInfoChanceNum - i) + " 次重试机会");
            }else{
                System.out.println("您已经多次输错用户名或密码，请稍后再重试!");
            }
        }
    }
}