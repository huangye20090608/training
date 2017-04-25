package com.huangye.training.demo.basic;

/**
 * Created by huangye on 2017/4/10.
 */

class MyObject {

    protected  void test(){
        System.out.println("MyObject-test");
    }

}

public class ProtectedDemo {

    public static void main(String args[]) throws CloneNotSupportedException {
        MyObject obj = new MyObject();
        //obj.clone(); // Compile error.
        obj.test();// Compile
    }
}
