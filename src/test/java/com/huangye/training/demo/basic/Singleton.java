package com.huangye.training.demo.basic;

/**
 * Created by huangye on 2017/9/4.
 */
public enum  Singleton {
    INSTANCE;
    private String instance;
    private Singleton() {
        instance = new String();
    }
    public String getInstance() {
        return instance;
    }
}
