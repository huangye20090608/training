package com.huangye.training.demo.stream;

import java.io.Serializable;

/**
 * Created by huangye on 2017/4/5.
 */
public class User implements Serializable{


    public String namePublic;
    private String name;
    private int age;
    private int sex;

    private static final String namePrivate = "JD-HAUNGYE";

    public User(String name,int age,int sex,String namePublic){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.namePublic = namePublic;
    }

    public User(){
        System.out.println("wucan!!!!!");
    }

    private User(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void add(int a,int b){
        System.out.println(a+b);
    }

    private void toUpper(String a){
        System.out.println(a.toUpperCase());
    }

    private final void toUpperDemo(String a){
        System.out.println(a.toLowerCase());
    }

    private void test(){
        System.out.println("test");
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

    public String getNamePublic() {
        return namePublic;
    }

    public void setNamePublic(String namePublic) {
        this.namePublic = namePublic;
    }
}
