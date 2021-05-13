package com.basicgrammer.base;

public class ClassAndObjectHomeWork04{
    public static void main(String[] args){
        //需求：编写类A03,实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
        int[] a = {1,2,3};
        A03 aObj = new A03();
        int[] newArray = aObj.copyArr(a);
        
        System.out.print("原数组元素：");
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i] + "\t");
        }

        System.out.print("新复制到的数组：");
        for(int i = 0;i <  newArray.length;i++){
            System.out.print(newArray[i] + "\t");
        }
    }
}

class A03{
    public int[] copyArr(int[] originArr) {
        int[] newArr = new int[originArr.length];
        for(int i = 0;i < newArr.length;i++){
            newArr[i] = originArr[i];
        }
        return newArr;
    }
}