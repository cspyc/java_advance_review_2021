package com.basicgrammer.exception_;

import java.util.Scanner;

/**
 * @author Pi
 * @date 2021-04-14 10:38
 */
public class ExceptionDetail {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        boolean notHasInputNumber = true;
        do {
            try {
                String inputNum = scanner.next();
                int num = Integer.parseInt(inputNum);
                notHasInputNumber = false;
                System.out.println("已经输入正确的整数！");
            } catch (NumberFormatException e) {
                System.out.println("请输入一个正确格式的整数:");
            }
        }while (notHasInputNumber);
    }
}
