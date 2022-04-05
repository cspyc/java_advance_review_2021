package com.designpattern.template;

/**
 * @author pi
 * @date 2021/04/11 13:33:42
 **/
public class AA extends Template{

    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 1000000; i++) {
            num += i;
        }
    }
}
