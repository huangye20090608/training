package com.huangye.training.demo.Comparable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangye on 2017/7/31.
 */
public class SortComparableDemoMain {
    public static void main(String args[]) throws InterruptedException {


       // System.out.println(Math.min(10,15) + 1);


//        final List Loans = new ArrayList();
//        Loans.add("home loan");  //valid
//        Loans.add("personal loan"); //valid
//        //loans = new Vector();  //not valid
        List<SortComparableDemo> list = new ArrayList<SortComparableDemo>();
        list.add(new SortComparableDemo(12,"huangye1"));
        list.add(new SortComparableDemo(123,"huangye2"));
        list.add(new SortComparableDemo(1234,"huangye3"));
        list.add(new SortComparableDemo(12345,"huangye4"));
        list.add(new SortComparableDemo(123456,"huangye45"));
        Collections.sort(list);

        for(SortComparableDemo sortComparableDemo : list){
            System.out.println(sortComparableDemo.getName());
        }

////        String cur_url = "l?ts=qwe123&returnUrl=/m/wx_phone_check.html&rm=" + System.currentTimeMillis();
////        System.out.println(cur_url.indexOf("ts="));
////        System.out.println(cur_url.indexOf("&returnUrl="));
////        System.out.println(cur_url.substring(cur_url.indexOf("ts=")+3,cur_url.indexOf("&returnUrl=")));
////        System.out.println(cur_url.substring(cur_url.indexOf("&returnUrl=")+11,cur_url.indexOf("&rm=")));
////
////        String cacheObj = "{\"openid\":\"oo__ct5sLIJo89a0s6yZK6makE2U\",\"nickname\":\"黄野\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"\",\"province\":\"北京\",\"country\":\"中国\",\"headimgurl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/LPLYlyQ5GAqtuFwj1nhVPfzR37yHZlILbmuenQcInfhRclUj6yhaG0k9QxItRWuZ7tBs44kibaIoCxgP8nxibcTw\\/0\",\"privilege\":[],\"unionid\":\"o1wKYsxX9Q4SMWNrriTV4cE4DCBw\"} \n" +
////                "2017-08-07 17:05:42,545 [2372648]   INFO - http-bio-8001-exec-6 -          com.jd.b2b.m.controller.WxLoginController - 保存unionId缓存Key:20160114114_wx_perm_1502096742545.value:{unionId=o1wKYsxX9Q4SMWNrriTV4cE4DCBw, userInfo={\"openid\":\"oo__ct5sLIJo89a0s6yZK6makE2U\",\"nickname\":\"黄野\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"\",\"province\":\"北京\",\"country\":\"中国\",\"headimgurl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/LPLYlyQ5GAqtuFwj1nhVPfzR37yHZlILbmuenQcInfhRclUj6yhaG0k9QxItRWuZ7tBs44kibaIoCxgP8nxibcTw\\/0\",\"privilege\":[],\"unionid\":\"o1wKYsxX9Q4SMWNrriTV4cE4DCBw\"}}";
////        JSONObject wxJson = JSON.parseObject(cacheObj);
////        String unionId = wxJson.get("unionId").toString();
////        String userInfo =wxJson.get("userInfo").toString();
////        System.out.println(unionId);
////        JSONObject wxObjJson = new JSONObject();
////        wxObjJson.put("unionId", "123");
////        wxObjJson.put("userInfo","123");
////        System.out.println(wxObjJson.toString());
////        System.out.println(wxObjJson.toJSONString());
//
////        String s1 = "1234567890}";
//////        System.out.println(String.valueOf((Object)null));
//////
////        byte[] bytes = s1.getBytes();
////        //System.out.println(s1.toCharArray());
////
////
////        for(byte b1 : bytes){
////            System.out.println(b1);
////        }
//
//       final String s1 ;
////        System.out.println(s1.indexOf("?_v_="));
//
////        LinkedHashMap<String,String> LinkedHashMap = new LinkedHashMap<String,String>();
//
//        HashMap<String,String> maps = new HashMap<String,String>();
//        maps.size();
////        maps.put("1",null);
////        maps.put(null,"2");
////
////        for(Map.Entry<String,String> entry : maps.entrySet()){
////            System.out.println(entry.getKey() + ":" + entry.getValue());
////        }
//        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();
//        concurrentHashMap.put("1","1");
//        concurrentHashMap.size();
        /*int retries = -1;
        System.out.print(retries++);
        System.out.print(retries++);
        System.out.print(retries++);

        long last = 0L;*/

//        for(int i=0;i<10;i++){
//            last = 3;
//            System.out.println(last);
//        }
//
//        System.out.println(last);



////
//        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
//
//        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
//        linkedBlockingQueue.add("1");
//        linkedBlockingQueue.offer("2");
//        linkedBlockingQueue.offer("3");
//        linkedBlockingQueue.offer("4");
//        linkedBlockingQueue.offer("5");
//        linkedBlockingQueue.put("6");
//       System.out.println(linkedBlockingQueue.remove());
////        System.out.println(linkedBlockingQueue.remove());
////        System.out.println(linkedBlockingQueue.remove());
////        System.out.println(linkedBlockingQueue.remove());
////        System.out.println(linkedBlockingQueue.remove());
//
//        for(String Queue : linkedBlockingQueue){
//            System.out.println(Queue);
//        }
//        linkedBlockingQueue.poll();
//        linkedBlockingQueue.offer("12");
//        System.out.println("===============");
//        for(String Queue : linkedBlockingQueue){
//            System.out.println(Queue);
//        }
////
//        System.out.println("===============");
//        AtomicInteger  atomicInteger = new AtomicInteger(10);
//
//        System.out.println(atomicInteger.getAndDecrement());
//        System.out.println(atomicInteger);
//        System.out.println(atomicInteger.getAndIncrement());
//        System.out.println(atomicInteger);
        //HashMap<String,String> maps = new HashMap<String,String>();

//        final ReentrantLock lock = new ReentrantLock();
//        lock.tryLock();
//        System.out.println(0x7fffffff);
//
//        Thread thread1 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    System.out.println("InterruptedException start");
//                    System.out.println("start:" + Thread.currentThread().isInterrupted());
//                    Thread.sleep(4000);
//                    System.out.println("start-sleep:" + Thread.currentThread().isInterrupted());
//                    //lock.lockInterruptibly();
//                    //boolean result = lock.tryLock(3, TimeUnit.SECONDS);
//                    //System.out.println("InterruptedException,result:" + result);
//                    lock.lock();
//                    //System.out.println("InterruptedException end!!!");
//                } catch (Exception e) {
//                    System.out.println("InterruptedException");
//                    System.out.println("end:" + Thread.currentThread().isInterrupted());
//                }finally {
////                    System.out.println("lock.isLocked():" + lock.isLocked());
////                    if(lock.isLocked()){
////                        lock.unlock();
////                    }
//                }
//            }
//        });
//        thread1.start();
//        Thread.sleep(2000);
//        thread1.interrupt();
//        Thread.sleep(2000);
//        lock.unlock();
//        byte s2 = 123;
//
//        byte s3 = -12;
//
//        //char s4 = -1;
//
//        char s5 = 88;
//
//        System.out.println(s5);
//
//        byte[] bs1 = new byte[]{1,2,3,4,5};
//
//        char[] cs1 = new char[]{1,2,3,4,5};

//        int[] fun ={0,1,2,3,4,5,6};
//        int[] fun1 = new int[3];
//        System.arraycopy(fun,0,fun1,0,3);
//
//        for(int  si1: fun1){
//            System.out.println(si1);
//        }

//        String[] s1 = {"中国","山西","太原","TYUT","zyy","加拿大","不知道哪个州","不知道哪个市","不知道哪个学校","yxf"};
//        String[] s2 = new String[10];
//        System.arraycopy(s1, 0, s2, 0, 10);
//        s2[6] = "假设蒙大拿州";
//        s2[7] = "假设蒙特利尔市";
//        s2[8] = "假设Montreal商学院";
//
//        System.out.println("This is s1");
//        for(int i = 0;i < s1.length ;i++){
//            System.out.print(s1[i] + ",");
//        }
//        System.out.println("\nThis is s2");
//        for(int i = 0;i < s2.length ;i++){
//            System.out.print(s2[i] + ",");
//        }
//
//        String[][] s3 = {{"中国","山西","太原","TYUT","zyy"},{"加拿大","不知道哪个州","不知道哪个市","不知道哪个学校","yxf"}};
//        String[][] s4 = new String[s3.length][s3[0].length];
//        System.arraycopy(s3, 0, s4, 0, s3.length);
//
//        System.out.println("\nThis is original s3");
//        for(int i = 0;i < s3.length ;i++){
//            for(int j = 0; j< s3[0].length ;j++){
//                System.out.print(s3[i][j] + ",");
//            }
//        }
//
//        s4[1][1] = "假设蒙大拿州";
//        s4[1][2] = "假设蒙特利尔市";
//        s4[1][3] = "假设Montreal商学院";
//
//        System.out.println("\nThis is s3 after s4 has changed.");
//        for(int i = 0;i < s3.length ;i++){
//            for(int j = 0; j< s3[0].length ;j++){
//                System.out.print(s3[i][j] + ",");
//            }
//        }
//
//        System.out.println("\nThis is s4");
//        for(int i = 0;i < s4.length ;i++){
//            for(int j = 0; j < s4[0].length ; j++){
//                System.out.print(s4[i][j] + ",");
//            }
//
//        }
    }
}
