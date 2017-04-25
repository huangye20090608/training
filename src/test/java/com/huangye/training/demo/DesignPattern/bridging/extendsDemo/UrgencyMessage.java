package com.huangye.training.demo.DesignPattern.bridging.extendsDemo;

/**
 * Created by huangye on 2017/4/18.
 */
public interface UrgencyMessage extends Message {
    /**
     * 监控指定消息的处理过程
     * @param messageId  被监控的消息编号
     * @return    监控到的消息的处理状态
     */
    public Object watch(String messageId);
}
