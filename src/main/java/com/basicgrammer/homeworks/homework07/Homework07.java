package com.basicgrammer.homeworks.homework07;

/**
 * @author Pi
 * @date 2021-04-13 15:42
 */
public class Homework07 {
    public static void main(String[] args) {
        Color color = Color.BLACK;
        switch (color) {
            case BLACK:
                System.out.println("这是黑色");
                break;
            case BLUE :
                System.out.println("这是蓝色");
                color.show();
                break;
            default:
                break;
        }

    }
}
