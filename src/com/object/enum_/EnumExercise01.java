package com.object.enum_;

/**
 * @author Pi
 * @date 2021-04-12 23:58
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        System.out.println("=======所有星期的信息如下========");
        for (Week week : Week.values()) {
            System.out.println(week);
        }
    }
}

enum Week {
    /**
     * 星期描述
     */
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private String cnName;

    Week(String cnName) {
        this.cnName = cnName;
    }

    @Override
    public String toString() {
        return cnName;
    }
}
