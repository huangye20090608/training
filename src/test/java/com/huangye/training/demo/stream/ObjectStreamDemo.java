package com.huangye.training.demo.stream;

import java.io.*;

/**
 * Created by huangye on 2017/4/5.
 */
public class ObjectStreamDemo {


    public static void objectToStream(Object obj,String address) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(address);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static Object streamToObject(String address) throws IOException ,ClassNotFoundException{
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object object = null;
        try {
            fis = new FileInputStream(address);
            ois = new ObjectInputStream(fis);
            object = ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return object;
    }


    public static void main(String agrs[]) throws IOException {

        String name = "E:\\objectStream.txt";
        String name1 = "E:\\objectStream1.txt";

//        Group group = new Group("金额",3000d,123);
//        objectToStream(group,name1);


        try {
            Group obj = (Group)streamToObject(name1);
            System.out.println(obj.getName());
            System.out.println(obj.getAge());
            System.out.println(obj.getAmount());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
