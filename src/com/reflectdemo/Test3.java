package com.reflectdemo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author 王炳智
 * @Date 2016/6/12 9:58
 */
//反射类的方法
public class Test3 {
    public static void main(String[] args) throws Exception {
        test6();
    }

    //反射类的方法：public void method1()
    public static void test() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Method method = clazz.getMethod("method1", null);
        method.invoke(p, null);  //要获取方法肯定要创建对象

    }

    //反射类的方法：public void method1(String name)
    public static void test2() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Method method = clazz.getMethod("method1", String.class, int.class);
        method.invoke(p, "wbz", 21);  //要获取方法肯定要创建对象
    }

    //反射类的方法：public Class[] method1(String name,int[] password)
  /*  public static void test3() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Method method = clazz.getMethod("method1", String.class,int[].class);
        Class cs[] = (Class[])method.invoke(p,"aaaa",new int[](1,23));
        System.out.println(cs[0]);
    }*/

    //反射类的方法：private void method1(InputStream in)
    public static void test4() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");

        Method method = clazz.getDeclaredMethod("method1", InputStream.class); //private
        method.setAccessible(true);
        method.invoke(p, new FileInputStream("e:\\1.txt"));  //如果此处设置一个不存在的文档，则会出错
    }

    //反射类的方法：public static void method1(InputStream in)
    public static void test5() throws Exception {
        Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Method method = clazz.getMethod("method1", int.class);
        method.invoke(p,66);  //静态不需要对象
    }
    //反射类的方法：public static void main (String[] args)
    public static void test6() throws Exception{
        //Person p = new Person();
        Class clazz = Class.forName("com.reflectdemo.Person");
        Method methon = clazz.getMethod("main", String[].class);
        methon.invoke(null,new Object[]{new String[]{"aa","bb"}});
        //methon.invoke(null,(Object) new String[]{"aa","bb"});
        }
}