package com.basicgrammer.base;

import java.util.Scanner;

public class ArrayReduce{
    public static void main(String[] args){
        //需求：有一个数组{1,2,3,4,5},可以将该数组进行缩减，提示用户是否继续缩减，每次缩减最后哪个元素。当只剩下最后一个元素，提示，不能再缩减。
        // Tasking:
        // 1.静态初始化一个原始数组； int[] a =  {1,2,3,4,5};
        // 2.取出数组最后一个元素，提示是否进行缩减；
        // 3.新建一个原数组容量-1的数组，将剩下的元素放入其中；
        // 4. 从2开始循环
        // 5. 如果只剩下最后一个元素，提示，不能再缩减

        Scanner input =  new Scanner(System.in);
        int[] a = {1,2,3,4,5};
        int lastElement = a[a.length - 1];

        System.out.println("将缩减数组最后一个元素：" + lastElement + " ，是否进行缩减,y/n");
        char isReduce = input.next().charAt(0);
        do{        
            int[] b = new int[a.length - 1];   
            if(isReduce == 'y'){
                if(a.length == 1){
                    System.out.println("只剩下最后一个元素，不能再缩减了！");
                    break;
                }               
                for(int i = 0;i < a.length - 1;i++){
                    b[i] = a[i];
                }

                a = new int[b.length];
                for(int i = 0;i < b.length;i++){
                    a[i] = b[i];
                }   
            }else {
                break;
            }
            
            System.out.println("===========缩减后的数组：");
            for(int i = 0;i < a.length;i++){
                System.out.print(a[i] + " ");
            }

            System.out.println("是否继续缩减，即将缩减的元素为： " + b[b.length - 1] + " ,y/n");
            isReduce = input.next().charAt(0);
        }while(true);

    }
}
