package com.basicgrammer.String_;

/**
 * @author Pi
 * @date 2021-04-15 17:04
 */
public class StringDetail {
    public static void main(String[] args) {
        String a = "123";
        System.out.println(a + "-" + a.hashCode());
        ////修改字符串内容，字符串变量直接指向一个新的对象地址
        a = "修改";
        System.out.println(a + "-" + a.hashCode());

    }
}
