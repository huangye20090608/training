package com.huangye.training.demo.Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangye on 2017/4/11.
 */
public class ThreadLocalDemo {

    public static void main(String args[]) throws InterruptedException {
        LinkedList<String> queue = new LinkedList<String>();
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        //生产者
        System.out.println("生产者开始工作------------------");
        Thread thread1 = new Thread(new Producer(queue,lock,notFull,notEmpty));
        thread1.start();
//        Thread thread2 = new Thread(new Producer(queue,lock,notFull,notEmpty));
//        thread2.start();
//        Thread.sleep(1000);
        //消费者
        System.out.println("消费者开始工作----------------------");
        Thread thread3 = new Thread(new Consumer(queue,lock,notFull,notEmpty));
        thread3.start();
        Thread thread4 = new Thread(new Consumer(queue,lock,notFull,notEmpty));
        thread4.start();
        Thread thread5 = new Thread(new Consumer(queue,lock,notFull,notEmpty));
        thread5.start();
    }
}
