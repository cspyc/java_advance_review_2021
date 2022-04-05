package com.houserent.service;

import com.houserent.domain.House;
import com.houserent.domain.Operator;

/**
 * @author pi
 * @date 2021/03/26 17:26:59
 **/
public class HouseService {
    private Operator operator = new Operator();

    public void addRentHouse(String id, String name, String phoneNumber, String address, double rentFare, String rentStatus) {
        House newRentHouse = new House(id, name, phoneNumber, address, rentFare, rentStatus);
        operator.addRentHouse(newRentHouse);
    }

    public String findRentHouse(String id) {
        House house = operator.findRentHouse(id);
        if (house == null) {
            return "--------------------没有该找到该房屋信息----------------------";
        } else {
            return house.toString();
        }
    }

    public House findRentHouseEntity(String id) {
        House house = operator.findRentHouse(id);
        return house;
    }

    public String queryRentHouseList() {
        String result = "";
        House[] houses = operator.showRentHouseList();
        if (houses != null && houses.length > 0) {
            for (int i = 0; i < houses.length; i++) {
                result += houses[i].toString();
            }
        }
        return result;
    }

    public String deleteRentHouseById(String id) {
        House deletedHouse = operator.deleteRentHouse(id);
        if (deletedHouse != null) {
            return "--------------------删除成功----------------------";
        } else {
            return "--------------------没有该找到该房屋信息,请确认输入的编号是否正确----------------------";
        }

    }
}
