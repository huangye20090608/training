package com.huangye.training.demo.genericity;

import java.util.ArrayList;

/**
 * Created by huangye on 2017/4/6.
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
