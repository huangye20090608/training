package com.huangye.training.demo.exception;

/**
 * Created by huangye on 2017/4/10.
 */
public class AdviceException {

    private static int[] arr = new int[]{1,2,3,4,5};
    private static int SIZE = 10000;

    public static void main(String[] args) {

        long s1 = System.currentTimeMillis();
        for (int i=0; i<SIZE; i++)
            endByRange(arr);
        long e1 = System.currentTimeMillis();
        System.out.println("endByRange time:"+(e1-s1)+"ms" );

        long s2 = System.currentTimeMillis();
        for (int i=0; i<SIZE; i++)
            endByException(arr);
        long e2 = System.currentTimeMillis();
        System.out.println("endByException time:"+(e2-s2)+"ms" );
    }

    // 遍历arr数组: 通过异常的方式
    private static void endByException(int[] arr) {
        try {
            int i=0;
            while (true) {
                arr[i]=0;
                i++;
                //System.out.println("endByRange: arr["+i+"]="+arr[i]);
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    // 遍历arr数组: 通过边界的方式
    private static void endByRange(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            arr[i]=0;
            //System.out.println("endByException: arr["+i+"]="+arr[i]);
        }
    }
}
