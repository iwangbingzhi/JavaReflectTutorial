package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Method;

//获取方法
public class GetMethod {
    @Test
    public void getMethodDemo1() throws NoSuchMethodException {
        //获取到空参数方法
        Method a = TestGetMethod.class
                .getMethod("a", null);
        System.out.println("a="+a);

        Method b = TestGetMethod.class
                .getDeclaredMethod("b",String.class,int.class);
        System.out.println("b="+b);

        //获取到protected修饰的有参数的方法
        Method c = TestGetMethod.class
                .getDeclaredMethod("c",String.class);
        System.out.println("c="+c);

        Method d = TestGetMethod.class
                .getDeclaredMethod("d",null);
        System.out.println("d="+d);


        Method[] methods = TestGetMethod.class.getMethods();
        for (Method m:methods) {
            System.out.println("method:"+m);
        }

        Method[] methods2 = TestGetMethod.class.getDeclaredMethods();
        for (Method m:methods2) {
            System.out.println("DeclaredMethod:"+m);
        }
    }
}
