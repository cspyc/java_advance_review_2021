package com.basicgrammer.String_.homework;

/**
 * @author Pi
 * @date 2021-04-17 12:20
 */
public class Homework03 {
    public static void main(String[] args) {
        //需求：输入形式为：Han shun Ping的人名，以Ping,Han .S的形式打印出来。其中 .S是中间单词的首字母大写
        //例如：输入： "Willian Jefferson Clinton"，输出形式为：Clinton,Willian.J
        String originName = "Han shun Ping";
        System.out.println(formatName(originName));
    }

    private static String formatName(String name) {
        String result = "";

        if (!(name != null && name.split(" ").length >= 3)) {
            throw new RuntimeException("输入的名字格式不正确！");
        }
        String[] names = name.split(" ");

        result = names[names.length - 1] + "," + names[0] + "." + String.valueOf(names[1].charAt(0)).toUpperCase();


        return result;
    }


}
