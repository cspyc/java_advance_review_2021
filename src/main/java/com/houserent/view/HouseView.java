package com.houserent.view;

import com.houserent.domain.House;
import com.houserent.service.HouseService;
import com.houserent.util.Utility;

import java.util.Scanner;

/**
 * @author pi
 * @date 2021/03/26 17:27:20
 **/
public class HouseView {
    private HouseService houseService = new HouseService();

    private void formatMenu() {
        System.out.println("------------房屋出租系统-------------");
        System.out.println("1\t新增房源");
        System.out.println("2\t查找房屋");
        System.out.println("3\t删除房屋");
        System.out.println("4\t修改房屋信息");
        System.out.println("5\t房屋列表");
        System.out.println("6\t退出系统");
        System.out.println("请选择(1-6):");
    }

    public void showRentHouseMenu() {

        boolean menuLoop = true;
        do {
            formatMenu();
            String menuChoice = Utility.readInputString();
            switch (menuChoice) {
                case "1":
                    addRentHouseMenu();
                    break;
                case "2":
                    findRentHouseMenu();
                    break;
                case "3":
                    deleteRentHouseMenu();
                    break;
                case "4":
                    modifyRentHouseMenu();
                    break;
                case "5":
                    queryRentHouseListMenu();
                    break;
                case "6":
                    menuLoop = quitSystemMenu();
                    break;
                default:
                    break;
            }
        } while (menuLoop);

        System.out.println("退出系统成功！");
    }


    /**
     * 添加房屋
     */
    private void addRentHouseMenu() {
        System.out.println("----------------添加房源----------------");
        this.addRentHouseInfo();
    }

    private void addRentHouseInfo() {
        System.out.print("编号：\t");
        String id = Utility.readInputString();
        System.out.print("姓名：\t");
        String name = Utility.readInputString();
        System.out.print("电话：\t");
        String phoneNumber = Utility.readInputDoubleString(5);
        System.out.print("地址：\t");
        String address = Utility.readInputString();
        System.out.print("月租：\t");
        String rentFare = Utility.readInputDoubleString(-1);
        System.out.print("出租状态(未出租/已出租)：\t");
        String rentStatus = Utility.readInputString();

        houseService.addRentHouse(id, name, phoneNumber, address, new Double(rentFare), rentStatus);
    }

    /**
     * 查找房屋
     */
    private void findRentHouseMenu() {
        System.out.println("----------------查找房屋-----------------");
        System.out.print("请输入您需要查找的房屋编号：");
        findRentHouseInfo();
    }

    private void findRentHouseInfo() {
        String id = Utility.readInputString();

        String result = houseService.findRentHouse(id);
        System.out.println(result);
    }

    /**
     * 删除房屋信息
     */
    private void deleteRentHouseMenu() {

        System.out.println("----------------删除房屋-----------------");
        System.out.print("请选择您要删除的房源编号(-1退出):");

        String deleteId = Utility.readInputString();
        if ("-1".equals(deleteId)) {
            return;
        }
        //如果输入Y/N以外的数据，需要循环提示，直到输入正确的值
        System.out.println("确认是否删除(Y/N):请谨慎选择：\n");
        char isDeleteInput = Utility.readConfirmSelection();
        if (isDeleteInput == 'Y') {
            System.out.println(houseService.deleteRentHouseById(deleteId));
        }
    }

    /**
     * 修改房屋信息
     */
    private void modifyRentHouseMenu() {
        System.out.println("---------------修改房屋信息----------------");
        System.out.print("请输入您需要修改的房屋编号：");

        String inputHouseId = Utility.readInputString();
        House house = houseService.findRentHouseEntity(inputHouseId);
        if (house == null) {
            System.out.println("--------------------没有该找到该房屋信息,请确认输入的编号是否正确----------------------");
        }

        if (house != null) {
            System.out.print("姓名(" + house.getOwner() + "):");
            String name = Utility.readInputString(-1, house.getOwner());

            System.out.print("电话(" + house.getPhoneNumber() + "):");
            String phoneNumber = Utility.readInputDoubleString(5, house.getPhoneNumber());

            System.out.print("地址(" + house.getAddress() + "):");
            String address = Utility.readInputString(-1, house.getAddress());

            System.out.print("月租(" + house.getRentFare() + "):");
            String rentFare = Utility.readInputDoubleString(-1, house.getRentFare().toString());

            System.out.print("状态(" + house.getRentStatus() + "):");
            String rentStatus = Utility.readInputString(-1, house.getRentStatus());

            house.setOwner(name);
            house.setAddress(address);
            house.setPhoneNumber(phoneNumber);
            house.setRentFare(new Double(rentFare));
            house.setRentStatus(rentStatus);

            System.out.println("--------------------修改成功----------------------");
        }
    }

    /**
     * 房屋列表
     */
    private void queryRentHouseListMenu() {
        System.out.println("----------------房屋列表-----------------");
        System.out.println("编号\t 房主\t 电话\t 地址\t 月租\t 状态(已出租/未出租)");
        System.out.println(houseService.queryRentHouseList());
        System.out.println("---------------房屋列表完成----------------");
    }

    /**
     * 退出系统
     */
    private boolean quitSystemMenu() {
        boolean notQuitSystem = true;
        System.out.print("请确认您的选择(是否退出程序Y/N):");
        char inputSelection = Utility.readConfirmSelection();

        if (inputSelection == 'Y') {
            notQuitSystem = false;
        }
        return notQuitSystem;
    }
}
