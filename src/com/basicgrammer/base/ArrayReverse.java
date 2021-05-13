package com.basicgrammer.base;

public class ArrayReverse{
    public static void main(String[] args){
        //需求：把数组的元素内容反转  arr {11,22,33,44,55,66} -> {66,55,44,33,22,11}
       int[] arr1 = {11,22,33,44,55,66};
       int[] arr2 = new int[arr1.length];

       for(int i = arr1.length - 1;i >= 0;i--){
            arr2[(arr1.length-1)-i] = arr1[i];
       } 
       
       for(int i = 0;i < arr2.length;i++){
           System.out.println("反转后的数组元素：" + arr2[i] + " ");
       }
    }
}