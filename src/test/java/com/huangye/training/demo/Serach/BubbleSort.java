package com.huangye.training.demo.Serach;

/**
 * Created by huangye on 2017/8/26.
 */
public class BubbleSort {

    private int[] array;

    BubbleSort(int[] array) {
        this.array = array;
    }

    //从小到大
    public void sort() {
        int length = array.length;
        if (length > 0) {
            //冒泡排序循环次数，所以从1开始，循环次数应该是length-1
            for (int i = 1; i < length; i++) {
                //实际比较的时候，每次循环之后下一次循环次数都减少
                for (int j = 0; j < length - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    //从大到小
    public void descSort() {
        int length = array.length;
        if (length > 0) {
            for (int i = length - 1; i > 0; i--) {
                for (int j = length - 1; j > length - 1 - i; j--) {
                    if (array[j] > array[j - 1]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        }
    }

    public void printlnSort() {
        for (int arrayValue : array) {
            System.out.println(arrayValue);
        }
    }

    public static void main(String args[]) {
        int arrays[] = {3, 5, 1, 2, 56, 23, 78, 123, 456};
        BubbleSort bubbleSort = new BubbleSort(arrays);
        //bubbleSort.descSort();
        bubbleSort.sort();
        bubbleSort.printlnSort();
    }
}
