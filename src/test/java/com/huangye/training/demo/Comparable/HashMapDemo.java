package com.huangye.training.demo.Comparable;

import org.apache.ibatis.type.IntegerTypeHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by huangye on 2017/9/2.
 */
public class HashMapDemo {

    public static void main(String args[]){
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
        set.remove(p3); //此时remove不掉，造成内存泄漏
        set.add(p3); //重新添加，居然添加成功


        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set)
        {
            System.out.println(person.getAge());
        }
    }

    static class Person{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (!name.equals(person.name)) return false;
            if (!pass.equals(person.pass)) return false;
            return age.equals(person.age);

        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + pass.hashCode();
            result = 31 * result + age.hashCode();
            return result;
        }

        public Person(String name, String pass, Integer age) {
            this.name = name;
            this.pass = pass;
            this.age = age;
        }

        private String name;
        private String pass;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
}
