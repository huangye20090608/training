package com.huangye.training.demo.Serach;

/**
 * Created by huangye on 2017/8/26.
 */
public class BucketSort {

    private int[] buckets;
    private int[] array;

    BucketSort(int[] arrays, int range) {
        buckets = new int[range];
        array = arrays;
    }

    public void sort() {
        if (null != array && array.length > 0) {
            for (int arrayValue : array) {
                buckets[arrayValue]++;
            }
        }
    }

    public void println() {
        if (null != array && array.length > 0) {
            for (int i = buckets.length - 1; i > -1; i--) {
                for (int j = 0; j < buckets[i]; j++) {
                    System.out.println(i);
                }
            }
        }
    }


    public static void main(String args[]) {
        int[] sortArray = {1, 4, 6, 3, 5, 9, 7, 8, 2, 5};
        BucketSort bucketSort = new BucketSort(sortArray, 10);
        bucketSort.sort();
        bucketSort.println();

    }
}
