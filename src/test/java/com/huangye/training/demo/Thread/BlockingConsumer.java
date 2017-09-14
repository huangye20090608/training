package com.huangye.training.demo.Thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by huangye on 2017/9/6.
 */
public class BlockingConsumer implements Runnable{

    private ArrayBlockingQueue<String> blockingQueue;

    public BlockingConsumer(ArrayBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while(true){
            try {
                System.out.println("消费者开始工作,value:" + blockingQueue.take() + ",线程：" + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
