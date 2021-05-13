package com.tankgame;

import java.util.logging.Level;

/**
 * @author Pi
 * @date 2021-04-23 20:16
 */
public enum TankMoveDirectCode {
    /**
     * 方向
     */
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

    public static TankMoveDirectCode getDirectCodeFromIntNum(int directNum) {
        TankMoveDirectCode result = null;
        switch (directNum) {
            case 0:
                result = UP;
                break;
            case 1:
                result = RIGHT;
                break;
            case 2:
                result = DOWN;
                break;
            case 3:
                result = LEFT;
                break;
            default:
                break;
        }
        return result;
    }
}
