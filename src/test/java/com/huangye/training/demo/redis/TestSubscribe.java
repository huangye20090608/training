package com.huangye.training.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by huangye on 2017/9/13.
 */
public class TestSubscribe {

    public static void main(String args[]){
        Jedis jedis = new Jedis("localhost");
        RedisMsgPubSubListener listener = new RedisMsgPubSubListener();
        jedis.subscribe(listener, "redisChatTest");
    }
}
