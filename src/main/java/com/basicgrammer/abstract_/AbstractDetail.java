package com.basicgrammer.abstract_;

/**
 * @author pi
 * @date 2021/04/11 11:24:53
 **/
public class AbstractDetail {
    public static void main(String[] args) {

    }
}

abstract class A{
    abstract void hi();
}

abstract class B extends A{

}

class C extends A{
    @Override
    void hi() {

    }
}
