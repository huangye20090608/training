package com.huangye.training.demo.Thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by huangye on 2017/9/6.
 */
public class ArrayBlockingQueueClass {
    public static void main(String args[]) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(2);
//        System.out.println(blockingQueue.offer("q1"));//offer 非阻塞
//        System.out.println(blockingQueue.offer("q2"));//put 阻塞
//        System.out.println(blockingQueue.take());//poll非阻塞
//        System.out.println(blockingQueue.take());//take 阻塞
        Thread t1 = new Thread(new BlockingConsumer(blockingQueue));
        Thread t2 = new Thread(new BlockingConsumer(blockingQueue));
        Thread t3 = new Thread(new BlockingProduct(blockingQueue));
        Thread t4 = new Thread(new BlockingProduct(blockingQueue));
        t3.start();
        t4.start();
        t1.start();
        t2.start();


    }
}
