package com.huangye.training.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by huangye on 2017/4/7.
 */
public class ReflectionUtil {
    public static void main(String agrs[])throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        //说明泛型类型String和Integer都被擦除掉了，只剩下了原始类型。
        ArrayList<String> arrayList1=new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass()==arrayList2.getClass());

        //这说明了Integer泛型实例在编译之后被擦除了，只保留了原始类型。
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i=0;i<arrayList3.size();i++) {
            System.out.println(arrayList3.get(i));
        }

        //ArrayList<String> arrayList3123=new ArrayList<Object>();//编译错误
        //ArrayList<Object> arrayList4123=new ArrayList<String>();//编译错误


//        ArrayList<Object> arrayList123=new ArrayList<Object>();
//        arrayList123.add(new Object());
//        arrayList123.add(new Object());
//        ArrayList<String> arrayList2123=arrayList123;//编译错误


//        ArrayList<String> arrayList123=new ArrayList<String>();
//        arrayList1.add(new String());
//        arrayList1.add(new String());
//        ArrayList<Object> arrayList2123=arrayList1;//编译错误
    }
}
