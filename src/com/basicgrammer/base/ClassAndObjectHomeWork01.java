package com.basicgrammer.base;

public class ClassAndObjectHomeWork01{
    public static void main(String[] args){
        //需求：编写类A01，定义方法max，实现求某个double数组的最大值，并返回
        //功能性需求；非功能性需求
        A01 a = new A01();

        double[] doubleArr =  {1.2,3.3,45.2,2.5,1.8};
        Double max = a.max(doubleArr);
        if(max != null){
            System.out.print("数组：[");
            for(int i = 0;i < doubleArr.length;i++){
                System.out.print(doubleArr[i] + "\t");
            }
            System.out.println("],中的最大值为：" + max);
        }else{
            System.out.println("数组输入有误！");
        }
    }
}

class A01{
    public Double max(double[] doubleArr) {
        Double max = 0.0;
        //非功能性需求-健壮性
        if(doubleArr != null && doubleArr.length > 0){            
            for(int i = 0;i < doubleArr.length;i++){
                if(doubleArr[i] > max){
                    max = doubleArr[i];
                }
            }
        }else {
            max = null;
        }
        return max;
    }
}