package com.reflectdemo;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author 王炳智
 * @Date 2016/6/12 10:22
 */
//反射字段
public class Test4 {
    public static void main(String[] args) throws Exception {
        test1();
    }
    //反射字段   public String name = "wbz";
    public static void test1() throws Exception{
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Field f = clazz.getField("name");
        //获取字段值
        Object obj =  f.get(p);
        //获取字段类型
        Class type = f.getType();

        if (type.equals(String.class)){
            String svalue = (String) obj;
            System.out.println("svalue:"+svalue);
        }
        //设置字段的值
        f.set(p,"wanglih");
        System.out.println(p.name);
    }
    //反射字段private int password;
    public static void test2() throws Exception{
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Field password = clazz.getDeclaredField("password");
        password.setAccessible(true);
        password.set(p,6666);
        System.out.println(password.get(p));
    }

    //反射字段 private static int age;
    public static void test3() throws Exception{
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println(age.get(p));
    }
}
