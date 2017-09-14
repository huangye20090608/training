package com.huangye.training.demo.basic;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huangye on 2017/7/31.
 */
public class TestDemo {

    public static void main(String args[]) {

        //ThreadPoolExecutor

//        String s1 = "Programming";
//        String s2 = new String("Programming");
////        String s2 = new String("Programming");
////        String s3 = "Program" + "ming";
////        System.out.println(s1 == s2);
////        System.out.println(s1 == s3);
////        System.out.println(s1 == s1.intern());
//
//        for(int i = 0;i<s1.length();i++){
//            System.out.print(s1.charAt(i));
//
//        }

//        String str = new String("123");
////        String a="123";String b="123";
////        System.out.println(a == b);
////        System.out.println(a == str.intern());
//
//        String S1 = "abc";
//         String S2 = "a";
//        String S3 = "a" + "bc";
//        String S4 = S2 + "bc" ;
//
//        System.out.println(S1 == S3);
//        System.out.println(S1 == S4);
//
//        System.out.println(S1 == S2 + "bc");

//
//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        String str1 = new String("SEU")+ new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");

//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);

////        Integer integer2 = new Integer("126");
////        System.out.println(integer1.equals(integer2));
////        System.out.println(integer1 == integer2);
////        System.out.println(Integer.valueOf("126") == Integer.valueOf("126"));
////        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
//
//        Long ong1 = 127L;
//        Long ong2 = new Long("127");
//        System.out.println(ong1.equals(ong2));
////        System.out.println(Long.valueOf("126") == Long.valueOf("126"));
////        System.out.println(Long.valueOf("128") == Long.valueOf("128"));
//
//        Map<String,String> map = new HashMap<String,String>();

//        Integer i01 = 128;
//        int i02 = 128;
//        Integer i03 =Integer.valueOf(128);
//
//        Integer i04 = new Integer(128);
//
//        System.out.println(i01== i02);
//
//        System.out.println(i01== i03);
//
//        System.out.println(i03== i04);
//
//        System.out.println(i02== i04);
//
//        System.out.println(i01== i04);

//        String s = new String("abc");
//        String s1 = "abcdf";
//        String s5 = "df";
//        String s4 = "abc"+s5;
//        String s2 = new String("abc");
//
//        System.out.println(s1 == s4);
        //System.out.println(encodeURI("https://m-b2bp2bj.jcloud.com/m/login.html"));
//        System.out.println(s == s.intern());
//        System.out.println(s1 == s1.intern());
//        System.out.println(s1.intern() == s2.intern());


//        String hello = "hello";
//        String hel = "hel";
//        String lo = "lo";
//        System.out.println(hello == "hel" + "lo");
//        System.out.println(hello == "hel" + lo);


    }
    public static String encodeURI(String str){
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }

    public static String decodeURI(String str){
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }
}
