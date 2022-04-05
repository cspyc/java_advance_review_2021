package com.basicgrammer.base;

public class ClassAndObjectHomeWork02{
    public static void main(String[] args){
        //需求：编写类A02，定义方法find，实现查找某字符串数组中的元素查找，并返回索引，如果找不到，返回-1
        String[] aText = {"aa","bb","cd","bb","da"};
        A02 a = new A02();
        int[] beFoundIndex = a.find(aText,"bb");

        System.out.println("在字符串数组的如下索引位置，找到 bb:  ");
        for(int i = 0;i < beFoundIndex.length;i++){
            if(beFoundIndex[i] != -1) {
                System.out.print(beFoundIndex[i] + "\t");
            }
        }
    }
}

class A02{

    public int[] find(String[] originArray,String beFoundElement) {
        int[] elementIndexts = new int[originArray.length];
        //初始化保存索引的数组
        for(int i = 0;i < elementIndexts.length;i++) {
            elementIndexts[i] = -1;
        }
        //被找到元素个数计数值
        int isFoundedElementCount = 0;        
        for(int i = 0;i < originArray.length;i++){
            if(beFoundElement != null && beFoundElement.equals(originArray[i])){
                elementIndexts[isFoundedElementCount] = i;
                isFoundedElementCount++;
            }
        }

        return elementIndexts;

    }
}