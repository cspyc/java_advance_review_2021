package com.houserent.util;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author pi
 * @date 2021/03/26 17:27:11
 **/
public class Utility {

    private static final Scanner inputScanner = new Scanner(System.in);

    /**
     * 读取字符串内容
     *
     * @param limit        限制字符长度
     * @param defaultValue 默认值
     * @return 返回读取到的值
     */
    public static String readInputString(int limit, String defaultValue) {
        String str = readKeyBoardInput(limit, true, false);
        return "".equals(str) ? defaultValue : str;
    }

    /**
     * 读取字符串内容
     *
     * @return 读取的内容
     */
    public static String readInputString() {
        String str = readKeyBoardInput(-1, false, false);
        return str;
    }

    /**
     * 读取数字类型的输入，可设置默认值
     *
     * @param limit        限制长度
     * @param defaultValue 默认值
     * @return 读取的内容
     */
    public static String readInputDoubleString(int limit, String defaultValue) {
        String numStr = readKeyBoardInput(limit, false, true);
        return "".equals(numStr) ? defaultValue : numStr;
    }

    /**
     * 读取数字类型的输入
     *
     * @param limit 限制长度
     * @return 读取的内容
     */
    public static String readInputDoubleString(int limit) {
        String numStr = readKeyBoardInput(limit, false, true);
        return numStr;
    }

    /**
     * 读取键盘输入信息
     *
     * @param limit                  限制字符串长度 -1表示不限制
     * @param isPermittedBlankReturn 是否允许返回空字符串
     * @param isReadNumber           是否读取数字类型字符串
     * @return 读取的字符串
     */
    private static String readKeyBoardInput(int limit, boolean isPermittedBlankReturn, boolean isReadNumber) {
        String line = "";

        //判断是否有下一行输入
        while (inputScanner.hasNextLine()) {
            //读取这一行
            line = inputScanner.nextLine();

            if (line.length() == 0) {
                if (isPermittedBlankReturn) {
                    return line;
                } else {
                    //如果不接受返回空字符串，那么进行下次循环，必须要输入内容
                    System.out.println("输入不能为空，请重新输入：");
                    continue;
                }
            }

            //如果用户输入的内容长度大于limit，就提示重写输入
            //如果用户输入的内容 >0 <limit，就接受
            if (!checkInputLength(line, limit)) {
                System.out.println("输入数据的长度错误(必须输入" + limit + "位以内)，请重新输入：");
                continue;
            }

            //如果是读取数字类型的字符串，需要判断输入是否全部为数字
            if (isReadNumber) {
                if (!checkIsNumber(line)) {
                    System.out.println("输入的不是数字，请重新输入：");
                    continue;
                }
            }
            break;
        }
        return line;
    }

    /**
     * 判断输入的字符串是否为数字，且限制长度
     *
     * @param beCheckNumber 被检测的数字字符串
     * @return 提示
     */
    public static boolean checkIsNumber(String beCheckNumber) {
        if (beCheckNumber == null || "".equals(beCheckNumber)) {
            return false;
        }
        //必须是数字
        boolean isNumber = Pattern.matches("[0-9]+", beCheckNumber);
        if (!isNumber) {
            return false;
        }
        return true;
    }

    /**
     * 检查输入字符的长度
     *
     * @param beCheckInput 被检测的字符串
     * @param limitNum     限制长度 -1 表示不限制
     * @return
     */
    private static boolean checkInputLength(String beCheckInput, int limitNum) {
        if (beCheckInput == null) {
            return false;
        }
        if (limitNum != -1 && (beCheckInput.length() > limitNum || beCheckInput.length() < 1)) {
            return false;
        }
        return true;
    }

    public static char readConfirmSelection(){
        System.out.println("请输入您的选择(Y/N)");
        char c;
        //无限循环
        for(;;){
            String str = readKeyBoardInput(1,false,false).toUpperCase();
            c = str.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else{
                System.out.println("输入错误，请重新输入：");
            }
        }
        return c;
    }
}
