package com.huangye.training.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by huangye on 2017/9/13.
 */
public class TestPublish {

    public static void main(String args[]) throws InterruptedException {
        Jedis jedis = new Jedis("localhost");
        jedis.publish("redisChatTest", "我是天才");
        Thread.sleep(5000);
        jedis.publish("redisChatTest", "我牛逼");
        Thread.sleep(5000);
        jedis.publish("redisChatTest", "哈哈");
    }
}
