package com.huangye.training.demo.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huangye on 2017/4/6.
 */
public class Holder<T> {

    private T a;
    public Holder(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));



        Holder<String> holder2 = new Holder<String>("Generic");
        String s = holder2.get();
        System.out.println(s);
        holder2.set("test");
        System.out.println(holder2.get());
        holder2.set("Generic modify");
        System.out.println(holder2.get());
        //holder2.set(1);//无法编译   参数 1 不是 String 类型

    }
}
