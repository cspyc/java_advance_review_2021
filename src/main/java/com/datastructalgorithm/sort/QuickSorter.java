package com.datastructalgorithm.sort;

/**
 * @author pi
 * @date 2021/06/29 23:16:52
 **/
public class QuickSorter {

    public Integer[] quickSort(Integer[] originArray, int leftIndex, int rightIndex) {
        int leftTemp = leftIndex;
        int rightTemp = rightIndex;

        //中轴值
        int pivot = originArray[(leftIndex + rightIndex) / 2];
        while (leftTemp < rightTemp) {
            //在pivot中间值的左侧，寻找大于pivot的值，循环，直到找到为止
            while (originArray[leftTemp] < pivot) {
                leftTemp += 1;
            }

            //在pivot中间值的右侧，寻找小于pivot的值，循环，直到找到为止
            while (originArray[rightTemp] > pivot) {
                rightTemp -= 1;
            }

            if (leftTemp >= rightTemp) {
                break;
            }

            //交换
            int tempValue = originArray[leftTemp];
            originArray[leftTemp] = originArray[rightTemp];
            originArray[rightTemp] = tempValue;

            //如果交换完后，发现arr[leftTemp] == pivot值， 相等，--，前移
            if (originArray[leftTemp] == pivot) {
                rightTemp -= 1;
            }

            //如果交换完后，发现arr[rightTemp] == pivot值， 相等，++，后移
            if (originArray[rightTemp] == pivot) {
                leftTemp += 1;
            }
        }

        //如果 leftTemp == rightTemp,必须leftTemp++,right--,否则会栈溢出
        if (leftTemp == rightTemp) {
            leftTemp += 1;
            rightTemp -= 1;
        }
        //向左递归
        if (leftIndex < rightTemp) {
            quickSort(originArray, leftIndex, rightTemp);
        }
        //向右递归
        if (rightIndex > leftTemp) {
            quickSort(originArray, leftTemp, rightIndex);
        }
        return originArray;
    }
}
