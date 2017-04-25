package com.huangye.training.demo.DesignPattern.bridging.bridgingDemo;

/**
 * Created by huangye on 2017/4/18.
 */
public class MessageEmail implements MessageImplementor {

    public void send(String message, String toUser) {
        System.out.println("使用邮件短消息的方法，发送消息'"+message+"'给"+toUser);
    }
}
