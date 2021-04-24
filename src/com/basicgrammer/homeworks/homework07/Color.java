package com.basicgrammer.homeworks.homework07;

/**
 * @author Pi
 * @date 2021-04-13 15:36
 */
public enum Color implements ColorTemplate {

    /**
     * colors
     */
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private double redValue;
    private double greenValue;
    private double blueValue;

    Color(double redValue, double greenValue, double blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("原色Color{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}');
    }

}
