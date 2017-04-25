package com.huangye.training.demo.genericity;

/**
 * Created by huangye on 2017/4/6.
 */

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}


public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f(); //无法编译 找不到符号 f()
    }

    public static void main(String[] args) {
        HasF hasF  = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hasF);
        manipulator.manipulate();

    }
}
