package com.huangye.training.demo.basic;

/**
 * Created by huangye on 2017/9/4.
 */
public class ClassDemo {

    public static void main(String args[]){
//        int k = 0;
//        System.out.println(k++);//先使用再加
//        System.out.println(k++);//先使用再加
//        System.out.println(++k);//先加在使用
        new ClassDemo2();

        Singleton.INSTANCE.getInstance();
    }
}

class ClassDemo1{

    static{
        System.out.println("ClassDemo1---static");
    }

    {
        System.out.println("ClassDemo1---fei - static");
    }

    ClassDemo1(){
        System.out.println("ClassDemo1");
    }

}

class ClassDemo2 extends ClassDemo1{
    static{
        System.out.println("ClassDemo2---static");
    }

    {
        System.out.println("ClassDemo2---fei - static");
    }

    ClassDemo2(){
        System.out.println("ClassDemo2");
    }
}
