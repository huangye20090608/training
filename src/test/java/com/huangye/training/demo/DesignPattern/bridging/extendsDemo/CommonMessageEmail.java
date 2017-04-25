package com.huangye.training.demo.DesignPattern.bridging.extendsDemo;

/**
 * Created by huangye on 2017/4/18.
 */
public class CommonMessageEmail implements Message{

    public void send(String message, String toUser) {

        System.out.println("使用邮件短消息的方法，发送消息'"+message+"'给"+toUser);
    }
}
