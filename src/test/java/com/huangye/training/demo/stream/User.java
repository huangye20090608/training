package com.huangye.training.demo.stream;

import java.io.Serializable;

/**
 * Created by huangye on 2017/4/5.
 */
public class User implements Serializable{



    private String name;
    private int age;
    private int sex;

    public User(String name,int age,int sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
