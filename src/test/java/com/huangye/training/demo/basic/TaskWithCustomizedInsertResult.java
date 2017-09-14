package com.huangye.training.demo.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by huangye on 2017/9/2.
 */
public class TaskWithCustomizedInsertResult implements Callable<List<Integer>> {

    TaskWithCustomizedInsertResult(){

    }

    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.valueOf("1"));
        return list;
    }
}
