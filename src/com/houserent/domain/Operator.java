package com.houserent.domain;

/**
 * @author pi
 * @date 2021/03/26 17:25:30
 **/
public class Operator {
    private House[] rentHousesInfo = new House[0];

    public void addRentHouse(House house) {
        House[] newHouses = new House[rentHousesInfo.length + 1];
        for (int i = 0; i < rentHousesInfo.length; i++) {
            newHouses[i] = rentHousesInfo[i];
        }
        newHouses[newHouses.length - 1] = house;
        rentHousesInfo = newHouses;
    }

    public House findRentHouse(String id) {
        House result = null;
        for (int i = 0; i < rentHousesInfo.length; i++) {
            if (rentHousesInfo[i].getId().equals(id)) {
                result = rentHousesInfo[i];
            }
        }
        return result;
    }

    public House deleteRentHouse(String id) {
        House deletedHouse = null;
        int deletedHouseIndex = 0;
        for (int i = 0; i < rentHousesInfo.length; i++) {
            if (rentHousesInfo[i].getId().equals(id)) {
                deletedHouse = rentHousesInfo[i];
                deletedHouseIndex = i;
            }
        }
        //找到对应编号的房屋记录
        if (deletedHouse != null) {
            House[] newHouses = new House[rentHousesInfo.length - 1];
            if (deletedHouseIndex < rentHousesInfo.length - 1) {
                for (int i = 0; i < deletedHouseIndex; i++) {
                    if (!rentHousesInfo[i].getId().equals(id)) {
                        newHouses[i] = rentHousesInfo[i];
                    }
                }
                for (int i = deletedHouseIndex; i < rentHousesInfo.length - 1; i++) {
                    newHouses[i] = rentHousesInfo[i + 1];
                }
            }

            if (deletedHouseIndex == rentHousesInfo.length - 1) {
                for (int i = 0; i < rentHousesInfo.length - 1; i++) {
                    if (!rentHousesInfo[i].getId().equals(id)) {
                        newHouses[i] = rentHousesInfo[i];
                    }
                }
            }
            rentHousesInfo = newHouses;
        }
        return deletedHouse;
    }

    public void modifyRentHouse() {
    }

    public House[] showRentHouseList() {
        return this.rentHousesInfo;
    }

    public void quitSystem() {
    }
}
