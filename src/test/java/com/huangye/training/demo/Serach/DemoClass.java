package com.huangye.training.demo.Serach;

/**
 * Created by huangye on 2017/8/26.
 */
public class DemoClass {

    public static void main(String args[]){
        String str666 = new String("qwe") + new String("123456789");
        str666.intern();
        String str777 = "qwe123456789";
        System.out.println(str666 == str777);//#7  true


        String str444 = new String("str123456789");
        str444.intern();
        String str111 = "str123456789";
        System.out.println(str444 == str111);//#7  false

        Integer s1 = 12;
        int s2 = 12;
        Integer s3 = new Integer(12);

        System.out.println(s1 == s2);//#7  false
        System.out.println(s2 == s3);//#7  false

    }
}
