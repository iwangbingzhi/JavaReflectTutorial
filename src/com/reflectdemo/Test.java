package com.reflectdemo;

/**
 * @Description:
 * @Author 王炳智
 * @Date 2016/6/12 9:33
 */
/*
* 反射 加载类,获得类的字节码的三种方式
*
*
* */
public class Test {
    public static void main(String[] args) {
      //第一种方式
        try {
            Class clazz = Class.forName("com.reflectdemo.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       /* //第二种方式
        Class clazz1 = new Person().getClass();
        //第三种方式
        Class clazz2 = Person.class;*/
    }
}
