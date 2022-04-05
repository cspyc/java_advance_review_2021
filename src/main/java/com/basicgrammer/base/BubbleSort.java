package com.basicgrammer.base;

public class BubbleSort{
    public static void main(String[] args){
       //需求：原始数组 {1,22,43,11,5,57,3}  使用冒泡排序，从后往前，小数从后往前冒
       
       //Tasking:
       // 1.创建数组 a;
       // 2.第一轮排序，a[length - 1]开始
       //    第一次排序，a[length - 1] 与 a[length - 2] 3与57， 3 < 57,交换位置
       //    第二次排序，a[length - 2] 与 a[length - 3] 3与5,  3 < 5,交换位置
       //   ...
       //    第6次排序，a[length - 6] 与 a[length -7]
       // 第二轮排序 a[length - 1]开始
       //  第1次排序， a[length - 1] 与 a[length - 2] 
      // ...
      //   第 5 次排序 a[length - 5] 与 a[length - 6] 
      // 第 6 轮排序

      int[] a = {1,43,11,22,5};
      for(int j = 0; j < a.length - 1;j++){
        for(int i = a.length - 1;i > j;i--){
            if(a[i] < a[i-1]){
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }
     

      //输出排序后的结果
       System.out.println("========第 " + (j+1) +" 轮排序后的结果：");
       for(int i = 0;i < a.length;i++){           
            System.out.println(a[i] + "\t");
        }

      }
         
       
    }
}