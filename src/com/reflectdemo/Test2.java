package com.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author 王炳智
 * @Date 2016/6/12 9:33
 */
//反射类的构造函数，创建类的对象
public class Test2 {
    public static void main(String[] args) throws Exception{
        test3();
    }
    //反射构造函数 public Person()
    public static void test1() throws Exception{
        /*Class clazz = Class.forName("com.reflectdemo.Person");
        Constructor constructor = clazz.getConstructor(null); //获取到要反射的是哪个构造函数,只能得到public类型的函数
        Person p = (Person) constructor.newInstance(null); //新建实例
        System.out.println(p.name);*/
        Class aClass = Class.forName("com.reflectdemo.Person");
        Constructor constructor = aClass.getConstructor(null);
        Person p = (Person) constructor.newInstance(null);
        System.out.println(p.name);

    }

    //反射构造函数 public Person(String name)
    public static void test2() throws Exception{
        Class clazz = Class.forName("com.reflectdemo.Person");
        Constructor constructor = clazz.getConstructor(String.class);
        Person p = (Person) constructor.newInstance("wanglihong");
        System.out.println(p.name);
    }
    //反射构造函数 public Person(String name,int password)
    public static void test3() throws Exception {
        Class clazz = Class.forName("com.reflectdemo.Person");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person p = (Person) constructor.newInstance("zhoujielun", 123666);
        System.out.println(p.name);
    }
    //  反射构造函数  private Person(List list)
    public static void test4() throws Exception {
        Class clazz = Class.forName("com.reflectdemo.Person");
        Constructor constructor = clazz.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);  //暴力反射 可以强制访问私有的方法
        Person p = (Person) constructor.newInstance(new ArrayList());
        System.out.println(p.name);
    }
    //以下代码等效于test1
    public static void test5() throws Exception{
        Class clazz = Class.forName("com.reflectdemo.Person");
        Person p = (Person) clazz.newInstance(); //创建对象的另一种方式 但是必须要有空参数的构造函数的存在
        System.out.println(p);
    }
}
