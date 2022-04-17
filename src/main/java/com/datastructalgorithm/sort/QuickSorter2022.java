package com.datastructalgorithm.sort;

/**
 * @author pi
 * @date 2022/04/17 17:05:38
 **/
public class QuickSorter2022 {

    public Integer[] quickSort(Integer[] toBeOrderedArray) {
        //快速排序，使用Divided & conquer D&C 分而治之，迭代：找到基准条件、迭代条件

        //基准条件
        int arrayLength = toBeOrderedArray.length;
        if (arrayLength == 0 || arrayLength == 1) {
            return toBeOrderedArray;
        }

        //迭代条件：找到基准值 pivot,以pivot为界，将数组分为两组，找到比pivot值小和比pivot值大的数，分成两个数组
        int pivotIndex = Math.floorDiv(toBeOrderedArray.length, 2);
        Integer pivotValue = toBeOrderedArray[pivotIndex];

        //找到比pivot value小的值，与比pivot value大的值
        Integer[] greaterThanPivot = new Integer[toBeOrderedArray.length];
        Integer[] smallerThanPivot = new Integer[toBeOrderedArray.length];

        //给数组初始化值
        for (int i = 0; i < toBeOrderedArray.length; i++) {
            greaterThanPivot[i] = null;
            smallerThanPivot[i] = null;
        }
        for (int i = 0; i < toBeOrderedArray.length; i++) {
            if (toBeOrderedArray[i] > pivotValue) {
                greaterThanPivot[i] = toBeOrderedArray[i];
            }

            if (toBeOrderedArray[i] < pivotValue) {
                smallerThanPivot[i] = toBeOrderedArray[i];
            }
        }

        //取有效值，生成新数组
        int validGreaterCount = 0;
        int validSmallerCount = 0;
        for (int i = 0; i < toBeOrderedArray.length; i++) {
            if (greaterThanPivot[i] != null) {
                validGreaterCount++;
            }

            if (smallerThanPivot[i] != null) {
                validSmallerCount++;
            }
        }
        Integer[] validGreaterThanPivot = new Integer[validGreaterCount];
        Integer[] validSmallerThanPivot = new Integer[validSmallerCount];
        int validGreaterThanPivotIndex = 0;
        int validSmallerThanPivotIndex = 0;
        for (int i = 0; i < toBeOrderedArray.length; i++) {
            if (greaterThanPivot[i] != null) {
                validGreaterThanPivot[validGreaterThanPivotIndex] = greaterThanPivot[i];
                validGreaterThanPivotIndex++;
            }

            if (smallerThanPivot[i] != null) {
                validSmallerThanPivot[validSmallerThanPivotIndex] = smallerThanPivot[i];
                validSmallerThanPivotIndex++;
            }
        }

        Integer[] result = new Integer[toBeOrderedArray.length];
        Integer[] smallerThanPivotResult = quickSort(validSmallerThanPivot);
        Integer[] greaterThanPivotResult = quickSort(validGreaterThanPivot);
        for (int i = 0; i < smallerThanPivotResult.length; i++) {
            result[i] = smallerThanPivotResult[i];
        }
        result[smallerThanPivotResult.length] = pivotValue;

        int greaterResultLoop = smallerThanPivotResult.length + 1;
        if (greaterThanPivotResult.length > 0) {
            for (int i = 0; i < greaterThanPivotResult.length; i++) {
                result[greaterResultLoop] = greaterThanPivotResult[i];
                greaterResultLoop++;
            }
        }
        return result;
    }
}