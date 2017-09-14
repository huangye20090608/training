package com.huangye.training.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by huangye on 2017/9/13.
 */
public class RedisDemo {
    public static void main(String args[]){
        final Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("name"));
        new Thread(){
            public void run(){
                String watch =  jedis.watch("name");
                System.out.println(Thread.currentThread().getName() + "--" + watch);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "--" + jedis.get("name"));
                Transaction multi = jedis.multi();
                System.out.println(Thread.currentThread().getName() + "--" + multi);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                multi.set("name","qijianchao11");
                List<Object> exec = multi.exec();
                System.out.println(Thread.currentThread().getName() + "---" + exec);
                jedis.unwatch();
            }
        }.start();

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jedis.set("name","wangbing22");
                System.out.println(Thread.currentThread().getName() + ":" + jedis.get("name"));
            }
        }.start();


    }
}
