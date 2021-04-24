package com.basicgrammer.innerclass;

/**
 * @author Pi
 * @date 2021-04-12 17:40
 */
public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了.....");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了......");
            }
        });
    }
}

interface Bell{
    void ring();
}

class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}
