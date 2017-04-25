package com.huangye.training.demo.Thread;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangye on 2017/4/11.
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Long> platformId = new ThreadLocal<Long>();
    private static ThreadLocal<Long> domainGroupId = new ThreadLocal<Long>();

    public static void setPlatformId(Long pid) {
        platformId.set(pid);
    }

    public static Long getPlatformId() {
        return platformId.get();
    }

    public static Long getDomainGroupId() {
        return domainGroupId.get();
    }

    public static void setDomainGroupId(Long dgid) {
        domainGroupId.set(dgid);
    }

    public static void main(String agrs[]){

        //platformId.remove();
        //ThreadLocalDemo.setPlatformId(123456781L);
        //System.out.print(ThreadLocalDemo.getPlatformId());
        Object obj = new Object();
        List<Long> list = new ArrayList<Long>();
        list = null;
//        WeakReference wr = new WeakReference(obj);
//
//        obj = null;//等待一段时间，obj对象就会被垃圾回收
//        if(wr.get() == null){
//            System.out.println("obj 已经被清除了"+wr.get());
//        }else{
//            System.out.println("obj尚未被清除"+wr.get());
//        }
    }
}
