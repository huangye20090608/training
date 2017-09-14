package com.huangye.training.demo.Thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by huangye on 2017/9/6.
 */
public class BlockingProduct implements Runnable{

    private ArrayBlockingQueue<String> blockingQueue;

    public BlockingProduct(ArrayBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void run() {
        while(true){
            try {
                blockingQueue.put(Double.valueOf(Math.random()).toString());
                System.out.println("生产者开始工作:" + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
