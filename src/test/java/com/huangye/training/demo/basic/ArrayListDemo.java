package com.huangye.training.demo.basic;

import java.util.*;

/**
 * Created by huangye on 2017/4/10.
 */
public class ArrayListDemo {

    public static void main(String args[]) {

        //Hashtable
        //HashMap
        List<String> list=new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        // List中允许元素重复
        for(int i=0;i<list.size();i++)
            System.out.print(" "+list.get(i));// A B C A
        // 去除重复的元素且保持原有元素的顺序
        List list2=new ArrayListDemo().function(list);

        System.out.println("----------");

        for(int i=0;i<list2.size();i++)
            System.out.print(" "+list2.get(i));// A B C

    }
    public <e> List<e> function (List<e> list) {
        return new ArrayList<e>(new LinkedHashSet<e>(list));
    }
}
