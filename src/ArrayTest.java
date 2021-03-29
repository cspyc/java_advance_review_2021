
/**
 * @author pi
 * @date 2021/03/21 22:28:25
 **/
public class ArrayTest {
    public static void main(String[] args) {
        MyTools mt = new MyTools();
        int[] arr = {10, -1, 8, 0, 34};
        mt.bubbleSort(arr);

        System.out.println("======排序后的arr=====");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
//创建一个类MyTools，编写一个方法，可以完成对int数组冒泡排序的功能
//要求从小到大

class MyTools {

    public int[] bubbleSort(int[] originArray) {
        for (int i = 0; i < originArray.length - 1; i++) {
            for (int j = 0; j < originArray.length - 1 - i; j++) {
                if (originArray[j] > originArray[j + 1]) {
                    int temp = originArray[j];
                    originArray[j] = originArray[j + 1];
                    originArray[j + 1] = temp;
                }
            }
        }
        return originArray;
    }
}