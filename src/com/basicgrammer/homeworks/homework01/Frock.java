package com.basicgrammer.homeworks.homework01;

/**
 * @author Pi
 * @date 2021-04-13 14:02
 */
public class Frock {
    private int serialNumber;

    private static int currentNum = 100000;

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
