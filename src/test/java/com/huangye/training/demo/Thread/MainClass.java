package com.huangye.training.demo.Thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangye on 2017/9/12.
 */
public class MainClass {
    public static  void main(String args[]){
        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("a","a-value");
        maps.put("b",123L);
        maps.put("c",new String("123"));
        maps.put("d",new Long(1234L));
        System.out.println(maps);


        List<Object> list = new ArrayList<Object>();
        list.add("1");
        list.add("2");
        List<String> child = new ArrayList<String>();
        child.add("2.1");
        child.add("2.2");
        list.add(child);
        list.add("3");
        list.add("4");
        System.out.println(list);
//        for(Map.Entry map : maps.entrySet()){
//            System.out.println(map.getKey() + ":" + map.getValue());
//        }
    }
}
