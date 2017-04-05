package com.huangye.training.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huangye on 2017/3/29.
 */
public class BeanLifeCycle {

    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring/beans.xml");
        System.out.println("容器初始化成功");

        Person person = factory.getBean("person",Person.class);

        System.out.println(person);

        System.out.println("现在开始关闭容器！");

        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
