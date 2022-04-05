package com.basicgrammer.String_.homework;

/**
 * @author Pi
 * @date 2021-04-17 11:17
 */
public class Homework01 {
    public static void main(String[] args) {
        //需求：将字符串中指定部分进行反转。比如：将"a bcde f" 反转为 "a edcb f"
        String originStr = "abcdef";
        String reversedStr = reverse(originStr, 1, 4);
        System.out.println(originStr + "============" +
                "" + reversedStr);

        System.out.println("===========使用reverse02============");

        try {
            String reversedStr02 = reverse02(originStr, 1, 5);
            System.out.println(originStr + "--------------" + reversedStr02);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end) {
        String subStr = str.substring(start, end + 1);
        StringBuilder reverseStr = new StringBuilder(subStr);
        reverseStr.reverse();

        StringBuilder result = new StringBuilder(str);
        result.replace(start, end + 1, reverseStr.toString());

        return result.toString();
    }

    public static String reverse02(String str, int start, int end) {
        //需要对索引参数进行验证，以提升代码健壮性

        if (!(str != null && start < end && end < str.length())) {
            throw new RuntimeException("输入的参数不正确！");
        }
        //使用char[]数组进行翻转
        char[] values = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
        return new String(values);
    }
}
