package com.huangye.training.demo.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by huangye on 2017/9/2.
 */
public class ExecutorCompletionService {

    // 线程池
    private static java.util.concurrent.ExecutorCompletionService<List<Integer>> completionService = null;
    private static final int availableProcessors = Runtime.getRuntime().availableProcessors();
    static {
        if (completionService == null) {
            ExecutorService pool = Executors.newFixedThreadPool(availableProcessors);
            completionService = new java.util.concurrent.ExecutorCompletionService<List<Integer>>(pool);
        }
    }
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        List<Integer> itemCustomizedSkuList = new ArrayList<Integer>();// 定制sku集合
        for (int i = 1; i <= availableProcessors; i++) {
            completionService.submit(new TaskWithCustomizedInsertResult());
        }
        // 多线程结果合并
        for (int j = 0; j < availableProcessors; j++) {
            Future<List<Integer>> future = completionService.take();
            itemCustomizedSkuList.addAll(future.get());
        }
    }
}
