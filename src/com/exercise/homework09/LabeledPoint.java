package com.exercise.homework09;

/**
 * @author pi
 * @date 2021/03/26 10:42:48
 **/
public class LabeledPoint extends Point{
    private String label;

    public LabeledPoint(String label,double x, double y) {
        super(x, y);
        this.label = label;
    }
}
