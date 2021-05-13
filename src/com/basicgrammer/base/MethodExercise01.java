package com.basicgrammer.base;

public class MethodExercise01{
    public static void main(String[] args){
        //需求：编写类AA，有一个方法：判断一个数是奇数odd，还是偶数，返回boolean
        //     根据行、列、字符，打印对应行数和列数的字符，比如：行：4，列：4，字符#，则打印相应的效果
        AA a = new AA();
        boolean result = a.isOdd(15);
       // System.out.print("15是奇数：" + result);

        a.printSymbols(8,8,'&');
    }
}

class AA{

    public boolean isOdd(int num) {
        if(num % 2 == 0){
            return false;
        }
        return true;
    }

    public void printSymbols(int row,int column,char symbol){
        for(int i = 0;i < row;i++){
            for(int j = 0;j < column;j++){
                System.out.print(symbol);
            }
            System.out.println("");
        }
    }
}