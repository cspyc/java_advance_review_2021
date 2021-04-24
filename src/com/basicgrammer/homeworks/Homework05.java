package com.basicgrammer.homeworks;

/**
 * @author Pi
 * @date 2021-04-13 14:43
 */
public class Homework05 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.common();
        tang.passRiver();
        tang.climbFireMounton();

    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("一般骑马.....");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("轮船过河......");
    }
}

class Airplane implements Vehicles{

    @Override
    public void work() {
        System.out.println("飞机飞行.....");
    }
}

class VehicleFactory {
    private static Horse horse = new Horse();

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Airplane getAirPlane(){
        return new Airplane();
    }

    private VehicleFactory(){}
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }


    public void passRiver() {
        //判断当前vehicle属性是否存在
        //vehicles instanceof Boat 判断 当前的vehicles是不是Boat
        //(1) vehicles = null : vehicles instanceof Boat => false
        //(2) vehicles = Horse : vehicles instanceof Boat => false
        //(3) vehicles = Boat : vehicles instanceof Boat => true
        if (!(vehicles instanceof Boat)) {
            vehicles = VehicleFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        if (!(vehicles instanceof Horse)) {
            //这里使用的是多态
            vehicles = VehicleFactory.getHorse();
        }
        //使用接口调用
        vehicles.work();
    }

    public void climbFireMounton(){
        if(!(vehicles instanceof Airplane)){
            vehicles = VehicleFactory.getAirPlane();
        }

        vehicles.work();
    }
}
