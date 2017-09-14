package com.huangye.training.demo.basic;

/**
 * Created by huangye on 2017/9/1.
 */
public class QuickSort {

    public static void main(String agrs[]) {
        int[] src = null;
        if(null != src){
            quickSort(src, 0, src.length - 1);
            for (int s : src) {
                System.out.println(s);
            }
        }
    }

    public static void quickSort(int[] src, int i, int j) {
        if (i < j) {
            int key = src[i];
            int left = i;
            int right = j;
            while (left < right) {
                while (left < right && src[right] >= key) {
                    right--;
                }
                if (left < right) {
                    src[left] = src[right];
                    left++;
                }
                while (left < right && src[left] <= key) {
                    left++;
                }
                if (left < right) {
                    src[right] = src[left];
                    right--;
                }
                src[left] = key;
            }
            quickSort(src, i, left - 1);
            quickSort(src, left + 1, j);
        }

    }
}
