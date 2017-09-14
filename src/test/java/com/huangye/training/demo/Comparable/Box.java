package com.huangye.training.demo.Comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huangye on 2017/8/19.
 */
public class Box<T> {

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private T t;

    static class Fruit {}
    static class Apple extends Fruit {}
    static class Orange extends Fruit {}


    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    static class Reader<T> {
        T readExact(List<? extends T> list) {
            return list.get(0);
        }
    }

    public static void main(String args[]){

//        ArrayList<String> arrayList1=new ArrayList<String>();
//        arrayList1.add("abc");
//        System.out.println(arrayList1.get(0) instanceof Object ? 1 : 2 );


        ArrayList<Number> arrayList1 = new ArrayList<Number>();
        arrayList1.add(new Integer(12));
//        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
//        arrayList2.add(123);
//        arrayList2.get(0);
//        System.out.println(arrayList1.getClass()==arrayList2.getClass());
//
//        Integer s1 = 126;
//        int s3  = 126;
//        Integer s2 = new Integer(126);
//        Integer s4 = Integer.valueOf(126);
//
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s4);
//        System.out.println(s2 == s3);
//        Reader<Fruit> fruitReader = new Reader<Fruit>();
//        Fruit f = fruitReader.readExact(apples);
//
//        List<? super Apple> flist = new ArrayList<Fruit>();
//        flist.add(new Apple());

//        List<? super Apple> list = new ArrayList<Apple>();
//        list.add(new Apple());
//
//
//        List<? extends Fruit> lists = new ArrayList<Apple>();
        //lists.add(new Apple());

//        Box<Integer> integerBox = new Box<Integer>();
//        Box<Double> doubleBox = new Box<Double>();
//        Box<String> stringBox = new Box<String>();
//        List<Fruit> fruitList = new ArrayList<Fruit>();
//        fruitList.add(apple);
//        fruitList.add(orange);


        //System.out.println(fruitList.get(0));
//        for(Fruit fruit : fruitList){
//            System.out.println(fruit);
//        }
    }
}
