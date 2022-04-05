package com.basicgrammer.extend;

/**
 * @author pi
 * @date 2021/03/23 09:17:05
 **/
public class ExtendsExercise03 {
    public static void main(String[] args) {
        Pc pc = new Pc("AMD","Kingston-16G","WestData-SSD-512G","Lenovo");
        System.out.println(pc.getDetails());

        NotePad notePad = new NotePad("Intel","Kingston-8G","WestData-HardDisk-1T","black+");
        System.out.println(notePad.getDetails());

    }
}

class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;

    public Computer(String cpu, String memory, String hardDisk) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
    }


    public String getDetails() {
        return "cpu:" + this.cpu + ",memory:" + this.memory + ",hardDisk:" + this.hardDisk;
    }
}

class Pc extends Computer {
    private String brand;

    public Pc(String cpu, String memory, String hardDisk, String brand) {
        super(cpu, memory, hardDisk);
        this.brand = brand;
    }

    @Override
    public String getDetails() {
        return  super.getDetails()
                + "brand :" + this.brand;
    }
}

class NotePad extends Computer {
    private String color;


    public NotePad(String cpu, String memory, String hardDisk, String color) {
        super(cpu, memory, hardDisk);
        this.color = color;
    }

    @Override
    public String getDetails() {
        return  super.getDetails()
                + "color:" + this.color;
    }
}
