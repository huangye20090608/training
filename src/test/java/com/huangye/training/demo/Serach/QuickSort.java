package com.huangye.training.demo.Serach;

/**
 * Created by huangye on 2017/8/26.
 */
public class QuickSort {

    private int[] arrays;

    QuickSort(int[] arrays) {
        this.arrays = arrays;
    }

    public void sortPrintln() {
        for (int array : arrays) {
            System.out.println(array);
        }
    }

    public void sort() {
        quickSort(arrays, 0, arrays.length - 1);
    }

    public void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
    }

    public static void main(String args[]) {
        int[] array = {34, 47, 89, 123, 1, 3, 456, 789, 689, 5, 7, 9};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        quickSort.sortPrintln();
    }

}
