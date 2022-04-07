package com.datastructalgorithm.sort;

/**
 * @author pi
 * @date 2022/04/06 23:22:26
 **/
public class SelectionSort {

    public int findSmallestElement(int[] arrays) {
        int initialElementIndex = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < arrays[initialElementIndex]) {
                initialElementIndex = i;
            }
        }
        return initialElementIndex;
    }

    public int[] selectionSort(int[] array) {
        int originArrayLength = array.length;
        int[] result = new int[originArrayLength];
        for (int i = 0; i < originArrayLength; i++) {
            int smallestElementIndex = findSmallestElement(array);
            result[i] = array[smallestElementIndex];
            array = copyRemainElementsToNewArray(array, smallestElementIndex);

        }
        return result;
    }

    private int[] copyRemainElementsToNewArray(int[] array, int smallestElementIndex) {
        int[] newArray = new int[array.length - 1];
        System.out.println("array" + array.length);
        System.out.println("newArray" + newArray.length);
        if (smallestElementIndex == 0) {
            for (int j = 1; j < array.length; j++) {
                newArray[j - 1] = array[j];
            }
        }

        if (smallestElementIndex == array.length - 1) {
            for (int j = 0; j < array.length - 1; j++) {
                newArray[j] = array[j];
            }
        }
        if (smallestElementIndex > 0 && smallestElementIndex < array.length - 1) {
            for (int j = 0; j < array.length; j++) {
                if (j == smallestElementIndex) {
                    continue;
                }
                if (j < array.length - 1) {
                    newArray[j] = array[j];
                }
                if (j == array.length - 1) {
                    newArray[j - 1] = array[array.length - 1];
                }
            }

        }
        return newArray;
    }
}
