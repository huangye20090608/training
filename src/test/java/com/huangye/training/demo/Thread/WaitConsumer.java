package com.huangye.training.demo.Thread;

import java.util.LinkedList;

/**
 * Created by huangye on 2017/9/6.
 */
public class WaitConsumer implements Runnable {
    private LinkedList<String> list;

    public WaitConsumer(LinkedList<String> list) {
        this.list = list;
    }

    public void run() {
        while(true){
            synchronized (list){
                while(list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者开始工作取出：" + list.remove()+ ",线程:"+ Thread.currentThread().getName());
                list.notifyAll();
            }
        }

    }
}
