package com.huangye.training.demo.reflection;

/**
 * Created by huangye on 2017/4/7.
 */
public class Pair<T> {
    private T value;

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
