package com.huangye.training.demo.reflection;

import com.huangye.training.demo.stream.User;

import java.lang.reflect.*;

/**
 * Created by huangye on 2017/4/5.
 */
public class ReflectionDemo {

    public static void main(String agrs[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Object onj = new Object();
        User user = new User("name",12,12,"jd-huangye-public");
        System.out.println(User.class);
        System.out.println(user.getClass());
        Class classNmae = Class.forName("com.huangye.training.demo.stream.User");
        System.out.println(classNmae);
        //构造方法
        Constructor methodConstructor = classNmae.getDeclaredConstructor(new Class[]{String.class,int.class,int.class,String.class});
        System.out.println(methodConstructor);
        methodConstructor.setAccessible(true);
        User userConstructor = (User) methodConstructor.newInstance("huangye",10,10,"qijianhcao");
        Field Field= classNmae.getDeclaredField("name");
        System.out.println(Field);
        Field.setAccessible(true);
        System.out.println(Field.get(userConstructor));

        User userObject = User.class.newInstance();
        System.out.println(userObject);
        System.out.println(userObject.getNamePublic());
        System.out.println(User.class.getName());
        System.out.println(User.class.getSimpleName());

        System.out.println("==============================");
        printClassInfo(user);

        System.out.println("==============================");
        printFiledInfo(user);


        System.out.println("==============================");
        printConstructInfo(user);

        System.out.println("==============================");
        printInvokeInfo(user);

        Object array = Array.newInstance(String.class, 10); //等价于 new String[10]
        Array.set(array, 0, "Hello");  //等价于array[0] = "Hello"
        Array.set(array, 1, "World");  //等价于array[1] = "World"
        System.out.println(Array.get(array, 0));  //等价于array[0]

    }

    //获取方法信息
    public static void printClassInfo(Object object){
        Class c = object.getClass();
        System.out.println("类的名称："+c.getName());
        /**
         * 一个成员方法就是一个method对象
         * getMethod()所有的 public方法，包括父类继承的 public
         * getDeclaredMethods()获取该类所有的方法，包括private ,但不包括继承的方法。
         */
        Method[] methods=c.getDeclaredMethods();//获取方法c.getMethods()
        //获取所以的方法，包括private ,c.getDeclaredMethods();

        for(int i=0;i<methods.length;i++){
            //得到方法的返回类型
            Class returnType=methods[i].getReturnType();
            System.out.print(returnType.getName());
            //得到方法名：
            System.out.print(methods[i].getName()+"(");

            Class[] parameterTypes=methods[i].getParameterTypes();
            for(Class class1:parameterTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }
    }

    //获取成员变量的信息
    public static void printFiledInfo(Object o) throws NoSuchFieldException, IllegalAccessException {

        Class c = o.getClass();
        /**
         * getFileds()获取public
         * getDeclaredFields()获取所有
         */
        Field[] fileds = c.getDeclaredFields();

        //对所有属性设置访问权限  当类中的成员变量为private时 必须设置此项
        //Field nameField = c.getField("namePrivate");
        Field namePrivateField = c.getDeclaredField("namePrivate");//私有变量使用该方法
        namePrivateField.setAccessible(true);//禁止jdk的访问控制检查的能力，提升性能
        System.out.println("namePrivateField:"+namePrivateField);
        System.out.println("namePrivateFieldValue:"+namePrivateField.get(o));

//        for(Field f:fileds){
//            //获取成员变量的类型
//            Class filedType=f.getType();
//            System.out.println(filedType.getName()+" "+f.getName());
//        }



        Field namePublic = c.getField("namePublic");
        //namePublic.setAccessible(true);//禁止jdk的访问控制检查的能力，提升性能
        System.out.println("namePublic:"+namePublic);
        System.out.println("namePublicValue:"+namePublic.get(o));
        namePublic.set(o,"qijianchao");
        System.out.println("namePublicValue:"+namePublic.get(o));
    }

    //获取构造函数的信息
    public static void printConstructInfo(Object o){
        Class c = o.getClass();
        Constructor[] constructors = c.getConstructors();//public   getDeclaredConstructors 全部
        for (Constructor con:constructors){
            System.out.print(con.getName()+"(");

            Class[] typeParas=con.getParameterTypes();
            for (Class class1:typeParas){
                System.out.print(class1.getName()+" ,");
            }
            System.out.println(")");
        }
    }


    public static void printInvokeInfo(Object o){
        Class c = o.getClass();
        try {
            Method method = c.getMethod("add",new Class[]{int.class,int.class});
            System.out.println(method);
            //也可以 Method method=c.getMethod("add",int.class,int.class);
            //方法的反射操作
            method.invoke(o,10,10);

            Method method1 = c.getDeclaredMethod("toUpper",String.class);
            method1.setAccessible(true);
            System.out.println(method1);
            method1.invoke(o,"huangye");

            Method method2 = c.getDeclaredMethod("toUpperDemo",String.class);
            method2.setAccessible(true);
            System.out.println(method2);
            method2.invoke(o,"HUANGYE");

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
