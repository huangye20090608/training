package com.huangye.training.demo.Comparable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangye on 2017/9/1.
 */
public class FanXingClass {

    public static void main(String args[]){
        List<Integer> list= new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Integer si1 = list.get(0);
        Integer s1 = new Integer(12);
        Integer s2 = 12;
        int s3 = 12;
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s1 == s2);
    }
}
