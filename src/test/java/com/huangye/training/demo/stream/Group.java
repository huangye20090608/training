package com.huangye.training.demo.stream;

import java.io.Serializable;

/**
 * Created by huangye on 2017/4/5.
 */
public class Group implements Serializable {
    private static final long serialVersionUID = 8502988964639718947L;

    private String name;
    private transient Double amount;
    private int age;

    public Group(String name, Double amount, int age) {
        this.name = name;
        this.amount = amount;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
