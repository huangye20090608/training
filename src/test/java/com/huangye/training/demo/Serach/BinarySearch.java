package com.huangye.training.demo.Serach;

/**
 * Created by huangye on 2017/8/25.
 */
public class BinarySearch {

    public static void main(String args[]){
        int [] arrays = {1,3,3,3,5,6};
        //int [] arrays = {1,2,3,4,5,6,7,8,9,10};
        System.out.print("index:" + binarySearch005(arrays,3));
    }

    /**
     * 二分查找，找到该值在数组中的下标，否则为-1
     */
    static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            }
            else if (array[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }


    static int binarySearch001(int[] arrays,int key){
        int left = 0;
        int right = arrays.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
           if(arrays[mid] >= key){
               right = mid -1;
            }else{
               left = mid + 1;
            }
        }
        if (left < arrays.length && arrays[left] == key) {
            return left;
        }
        return -1;
    }

    static int binarySearch002(int[] arrays,int key){
        int left = 0;
        int right = arrays.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arrays[mid] <= key){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        if (right >= 0 && arrays[right] == key) {
            return right;
        }
        return -1;
    }


    static int binarySearch003(int arrays[],int key){

        int left  = 0;
        int right = arrays.length-1;

        while(left<=right){
            int mid = (left + right)/2;
            if(arrays[mid] == key){
                return mid;
            }else if(arrays[mid]<key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }


    static int binarySearch004(int arrays[],int key){

        int left  = 0;
        int right = arrays.length-1;

        while(left<=right){
            int mid = (left + right)/2;
            if(arrays[mid]>=key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

            if(left<arrays.length-1 && arrays[left] == key){
                return left;
            }
        }
        return -1;
    }


    static int binarySearch005(int arrays[],int key){

        int left  = 0;
        int right = arrays.length-1;

        while(left<=right){
            int mid = (left + right)/2;
            if(arrays[mid]<=key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            if(right>0 && arrays[right] == key){
                return right;
            }
        }
        return -1;
    }
}
