package com.basicgrammer.exception_.Homework;

/**
 * @author Pi
 * @date 2021-04-14 21:21
 */
public class Homework01 {
    public static void main(String[] args) {
        Double result = null;
        try {
            String inputNum1 = args[0];
            String inputNum2 = args[1];

            int num1 = Integer.parseInt(inputNum1);
            int num2 = Integer.parseInt(inputNum2);

            result = EcmDef.cal(num1, num2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + "----- 请输入正确个数(2个)参数！");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + "----- 请输入正确格式的整数");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + "----- 请注意EcmDef.cal方法中的计算元素是否合理");
        }

        if (result != null) {
            System.out.println("计算结果是：" + result);
        }


    }
}

class EcmDef {
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
