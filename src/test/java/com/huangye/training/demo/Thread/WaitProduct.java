package com.huangye.training.demo.Thread;

import java.util.LinkedList;

/**
 * Created by huangye on 2017/9/6.
 */
public class WaitProduct implements Runnable {
    private LinkedList<String> list;

    public WaitProduct(LinkedList<String> list) {
        this.list = list;
    }

    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() == 3) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者开始工作插入：" + list.add(Double.valueOf(Math.random()).toString()) + ",线程:" + Thread.currentThread().getName());
                list.notifyAll();
            }
        }
    }
}
