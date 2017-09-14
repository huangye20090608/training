package com.huangye.training.demo.Comparable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huangye on 2017/8/18.
 */
public class MainClass {
    private MainClass(){
        System.out.println("MainClass构造方法");
    };
    //非懒加载
//    private static MainClass mainClass = new MainClass();
//    public static MainClass getMainClass(){
//        return  mainClass;
//    }

    //懒加载
//    private static MainClass mainClass = null;
//    public static synchronized MainClass getMainClass(){
//        if(null != mainClass){
//            mainClass = new MainClass();
//        }
//        return  mainClass;
//    }

    private static class SingletonHolder{
        private static final MainClass INSTANCE = new MainClass();
    }

    public final static MainClass getMainClass(){
        return SingletonHolder.INSTANCE;
    }


    public static int testStatic(){
        //final static int i = 0;
        //System.out.println(i++);
        System.out.println("123");
        return 1;
    }

    public static void main(String[] args){
        //MainClass test = new MainClass();
        //test.testStatic();
       // MainClass MainClass = getMainClass();
        //org.apache.commons.beanutils.BeanUtils.copyProperties();
//        Person p = new Person(23, "zhang");
//        Person p1 = p;
////        Person p1 = null;
////        try {
////            p1 = (Person) p.clone();
////        } catch (CloneNotSupportedException e) {
////            e.printStackTrace();
////        }
//
//        String result = p.getName() == p1.getName()
//                ? "clone是浅拷贝的" : "clone是深拷贝的";
//
//        System.out.println(result);

        List list = new ArrayList();
        list.add("123");
        list.add(456);
        //ClassCastException
        for(Object obj : list){
            System.out.println((String)obj);
        }
    }
}
