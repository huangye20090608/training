package com.huangye.training.demo.DesignPattern.bridging.extendsDemo;

/**
 * Created by huangye on 2017/4/18.
 */
public class CommonMessageSMS implements Message {

    public void send(String message, String toUser) {

        System.out.println("使用系统内短消息的方法，发送消息'"+message+"'给"+toUser);
    }
}
