package com.huangye.training.demo.Comparable;

/**
 * Created by huangye on 2017/9/2.
 */
public class Singleton {
    private Singleton(){
    }
    private static class SingletonHolder{
        private static Singleton instacnce = new Singleton();
    }
    public static Singleton getSingleton(){
        return SingletonHolder.instacnce;
    }
}
