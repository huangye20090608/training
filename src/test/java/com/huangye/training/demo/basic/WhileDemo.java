package com.huangye.training.demo.basic;

/**
 * Created by huangye on 2017/4/21.
 */
public class WhileDemo {

    public static void main(String args[]){
        boolean whileD = false;
        int i = 0;
        System.out.println("循环开始");
        while(!whileD){
            if( i == 0){
                System.out.println("continue");
                i++;
                continue;
            }else if (i == 10){
                System.out.println("break");
                break;
            }else{
                System.out.println("循环开始"+i);
            }
            i++;
        }
        System.out.println("循环结束");
    }
}
