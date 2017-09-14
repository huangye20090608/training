package com.huangye.training.demo.Comparable;

/**
 * Created by huangye on 2017/7/31.
 */
public class SortComparableDemo implements Comparable<SortComparableDemo> {
    public int compareTo(SortComparableDemo o) {
        //return this.getAge().compareTo(o.getAge());
        return 1;
    }

    public SortComparableDemo(Integer age, String name) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
