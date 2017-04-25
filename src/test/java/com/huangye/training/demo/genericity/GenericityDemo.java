package com.huangye.training.demo.genericity;

import java.util.ArrayList;

/**
 * Created by huangye on 2017/4/6.
 */
public class GenericityDemo {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("a");
        al.add("b");
        accept(al);
    }

    public static void accept(ArrayList<?> al) {
        for (Object o : al)
            System.out.println(o);
    }
}
