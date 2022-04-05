package com.basicgrammer.String_.homework;

/**
 * @author Pi
 * @date 2021-04-17 14:03
 */
public class Homework04 {
    public static void main(String[] args) {
        //需求：输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
        String str = "aaAABBCCd12345";
        countStringCharacters(str);
    }

    private static void countStringCharacters(String str) {
        if (str == null) {
            System.out.println("字符串不能为空");
            return;
        }
        int countLowCase = 0;
        int countUpperCase = 0;
        int countDigit = 0;
        char[] values = str.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char c = values[i];
            if (isLowCase(c)) {
                countLowCase++;
            }
            if (isUpperCase(c)) {
                countUpperCase++;
            }
            if (isDigit(c)) {
                countDigit++;
            }
        }
        System.out.println("共有小写字母：" + countLowCase + "个");
        System.out.println("共有大写字母：" + countUpperCase + "个");
        System.out.println("共有数字：" + countDigit + "个");
    }

    private static boolean isLowCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

    private static boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
