package com.basicgrammer.iostream.standard;

import java.util.Scanner;

/**
 * @author Pi
 * @date 2021-05-10 13:13
 */
public class InputAndOutput {
    public static void main(String[] args) {
        //System.in  System类中的 public final static InputStream in = null;
        //System.in 编译类型  InputStream
        //System.in 运行类型  BufferedInputStream
        //表示的是标准输入 键盘
        System.out.println(System.in.getClass());

        //System.in  System类中的 public final static PrintStream out = null;
        //编译类型  PrintStream
        //运行类型  PrintStream
        //表示标准输出 显示器
        System.out.println(System.out.getClass());

        //从键盘中获取输入内容
        Scanner scanner = new Scanner(System.in);
    }
}
