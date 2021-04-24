package com.basicgrammer.String_.homework;

import java.util.Scanner;

/**
 * @author Pi
 * @date 2021-04-17 11:50
 */
public class Homework02 {
    public static void main(String[] args) {
        //需求：输入用户名，密码，邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
        //要求：1.用户名长度为2或3或4
        //      2.密码长度为6，要求全是数字；
        //      3.邮箱中包含@和.，并且@在.的前面
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = scanner.next();
        System.out.println("请输入密码：");
        String passWord = scanner.next();
        System.out.println("请输入邮箱地址：");
        String email = scanner.next();

        try {
            checkSignUpInfo(userName, passWord, email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkSignUpInfo(String userName, String passWord, String email) {
        if (checkUserName(userName) && checkPassword(passWord) && checkEmailAddress(email)) {
            System.out.println("注册成功");
        } else {
            throw new RuntimeException("注册信息有误，请重新输入");
        }
    }

    private static boolean checkUserName(String userName) {
        boolean isPassed = false;
        if (userName != null) {
            //用户名长度为2或3或4
            int userNameLength = userName.length();
            if (userNameLength > 1 && userNameLength < 5) {
                isPassed = true;
            }
        }
        return isPassed;
    }

    private static boolean checkPassword(String passWord) {
        boolean isPassed = false;
        if (passWord != null) {
            //密码长度为6，要求全是数字；
            int passWordLength = passWord.length();
            if (passWordLength == 6 && allCharIsDigital(passWord)) {
                isPassed = true;
            }
        }
        return isPassed;
    }

    private static boolean allCharIsDigital(String str) {
        boolean result = true;

        if (str != null) {
            char[] values = str.toCharArray();
            for (int i = 0; i < values.length; i++) {
                if (!Character.isDigit(values[i])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean checkEmailAddress(String email) {
        boolean isPassed = false;

        if (email != null) {
            //3.邮箱中包含@和.，并且@在.的前面
            if (email.contains("@") && email.contains(".") && (email.indexOf("@") < email.indexOf("."))) {
                isPassed = true;
            }
        }
        return isPassed;
    }
}
