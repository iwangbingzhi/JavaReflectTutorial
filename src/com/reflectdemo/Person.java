package com.reflectdemo;

import java.io.InputStream;
import java.util.List;

/**
 * @Title: Person.java
 * @Description:
 * @Author 王炳智
 * @Date 2016/6/12 09:23
 */
public class Person {
    public String name = "wbz";
    private int password = 123456789;
    private static int age = 20;


    public Person() {
        System.out.println("person");
    }
    public Person(String name){
        System.out.println("person"+"="+ name);
    }
    public Person(String name,int password){
        System.out.println(name +","+ password);
    }
    private Person(List list){
        System.out.println("list");
    }
    public void method1(){
        System.out.println("method1 run......");
    }
    public void method1(String name,int password){
        System.out.println(name +":"+ password);
    }
  /*  public Class[] method1(String name,int[] password){
        return new Class[](String.class);
    }*/
    private void method1(InputStream in){
        System.out.println(in);
    }
    public static void method1(int num){
        System.out.println(num);
    }

    public static void main(String[] args) {
        System.out.println("main!!!!!!!!!!");
    }
}


