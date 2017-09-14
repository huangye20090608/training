package com.huangye.training.demo.basic;

/**
 * Created by huangye on 2017/9/4.
 */
class Super{
    public final static int m;
    static{
        m = 12;
        System.out.println("执行了super类静态语句块");
    }
}

class Father extends Super{
    public static int m = 33;
    static{
        System.out.println("执行了父类静态语句块");
    }
}

class Child extends Father{

    public static int m = 1;
    static{
        System.out.println("执行了子类静态语句块");
    }
}

public class StaticTest{
    public static void main(String[] args){
        System.out.println(Child.m);
    }
}
