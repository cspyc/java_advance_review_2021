package com.basicgrammer.interface_;

/**
 * @author pi
 * @date 2021/04/11 15:50:15
 **/
public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        for (int i = 0; i < usbs.length; i++) {
            //动态绑定机制，调用实际运行时的对象中对应的方法
            usbs[i].work();
            if (usbs[i] instanceof Phone) {
                Phone phone = (Phone) usbs[i];
                phone.call();
            }
        }
    }
}

interface Usb {
    void work();
}

class Phone implements Usb {

    @Override
    public void work() {
        System.out.println("手机正在工作中.....");
    }

    public void call() {
        System.out.println("手机可以打电话......");
    }
}

class Camera implements Usb {

    @Override
    public void work() {
        System.out.println("相机正在工作中......");
    }
}
