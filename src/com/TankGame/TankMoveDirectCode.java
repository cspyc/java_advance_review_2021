package com.TankGame;

/**
 * @author Pi
 * @date 2021-04-23 20:16
 */
public enum TankMoveDirectCode {
    UP(0, "向上"),
    RIGHT(1, "向右"),
    DOWN(2, "向下"),
    LEFT(3, "向左");


    private Integer code;
    private String value;

    TankMoveDirectCode(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
