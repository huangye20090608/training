package com.huangye.training.demo.Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huangye on 2017/9/6.
 */
class ListRemoveClass1{
    public int bookings;
    public void book() {
        bookings++;
    }
}

public class ListRemoveClass extends ListRemoveClass1 {
    public void book() {
        bookings--;
    }

    public void book(int size) {
        book();
        super.book();
        bookings += size;
    }

    public static void main(String args[]) {
        ListRemoveClass hotel = new ListRemoveClass();
        hotel.book(2);
        System.out.print(hotel.bookings);
    }

//        String str = "1234567890";
//        char[] descChar = new char[str.length()-1];
//        str.getChars(0,str.length()-1,descChar,0);
//        System.out.println(descChar);
//        for(int i = 0;i<str.length();i++){
//            System.out.println(str.charAt(i));
//        }
//        String str1 = new String("1");
//        String str2 = new String("2");
//        String str3 = new String("3");
//        String str4 = new String("4");
//        String str5 = new String("5");
//        List<String> list = new ArrayList<String>();
//        //List<String> list = new LinkedList<String>();
//        list.add(str1);
//        list.add(str2);
//        list.add(str3);
//        list.add(str4);
//        list.add(str5);
//        System.out.println("list.size()=" + list.size());

        //for (int i = 0; i < list.size(); i++) {
//        for (int i = list.size()-1; i > -1; i--) {
//            list.remove(i);
//            //  i--;
//            //System.out.println(i+" "+list.get(i)+" ");
//        }

//        for (String s1 : list) {
//            System.out.println(s1);
//            list.add("6");
//        }
//        System.out.println("after remove:list.size()=" + list.size());
}
