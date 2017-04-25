package com.huangye.training.demo.basic;

class MyObject1 {

    protected  void test(){
        System.out.println("MyObject-test");
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class Protected1Demo {

    public static void main(String args[]) throws CloneNotSupportedException {
        MyObject1 obj = new MyObject1();
        obj.clone(); // Compile.
        obj.test();// Compile
    }
}
