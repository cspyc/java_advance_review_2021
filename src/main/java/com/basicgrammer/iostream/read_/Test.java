package com.basicgrammer.iostream.read_;

/**
 * @author pi
 * @date 2022/03/29 19:47:12
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        try {
            int a = 2 / 0;
            System.out.println(a);
        } catch (Exception e) {
            throw new Exception("Catch:" + e.getMessage());
        } finally {
            System.out.println("finally");
        }
    }
}
