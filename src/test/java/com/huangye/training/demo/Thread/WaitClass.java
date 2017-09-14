package com.huangye.training.demo.Thread;

import java.util.LinkedList;

/**
 * Created by huangye on 2017/9/6.
 */
public class WaitClass {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        Thread t1 = new Thread(new WaitProduct(list));
        Thread t2 = new Thread(new WaitProduct(list));
        Thread t3 = new Thread(new WaitConsumer(list));
        Thread t4 = new Thread(new WaitConsumer(list));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
