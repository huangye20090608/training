package com.huangye.training.demo.Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangye on 2017/8/15.
 */
public class Producer  implements Runnable{

    private LinkedList queue;
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;
    public Producer(LinkedList queue, ReentrantLock lock, Condition notFull, Condition notEmpty) {
        this.queue = queue;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    public void run() {
        lock.lock();
        try {
            while(true){
                System.out.println("生产者开始工作1，queue.size()" + queue.size() + ",线程:"+ Thread.currentThread().getName());
                Thread.sleep(500);
                while(queue.size() == 3){
                    try {
                        notFull.await();//写线程阻塞
                        System.out.println("生产者开始工作1，notFull.await()" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        System.out.println("生产者开始工作1，InterruptedException");
                    }
                }
                System.out.println("生产者开始工作插入：" + queue.add(Double.valueOf(Math.random())) + ",线程:"+ Thread.currentThread().getName());
                notEmpty.signal();//读线程唤醒
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
