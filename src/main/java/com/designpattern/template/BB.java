package com.designpattern.template;

/**
 * @author pi
 * @date 2021/04/11 13:34:30
 **/
public class BB extends Template {

    @Override
    public void job() {
        long num = 0;
        for (long i = 0; i < 800000; i++) {
            num *= i;
        }
    }
}
