package com.huangye.training.demo.Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangye on 2017/8/15.
 */
public class Consumer implements Runnable{
    private LinkedList queue;
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;
    public Consumer(LinkedList queue, ReentrantLock lock, Condition notFull, Condition notEmpty) {
        this.queue = queue;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }
    public void run() {
        lock.lock();
        try {
            while(true){
                while(queue.size() == 0){
                    try {
                        System.out.println("消费者开始工作，notEmpty.await()");
                        notEmpty.await();//读线程堵塞
                    } catch (InterruptedException e) {
                        System.out.println("消费者开始工作，InterruptedException()");
                    }
                }
                System.out.println("消费者开始工作取出：" + queue.remove()+ ",线程:"+ Thread.currentThread().getName());
                notFull.signal();//写线程唤醒
            }
        }finally {
            lock.unlock();
        }
    }
}
