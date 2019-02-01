package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

//测试反射得到构造方法的操作，创建对象
public class ConstructorNewInstance {
    @Test
    public void constructorDemo() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<TestConstructor> testConstructorClass = TestConstructor.class;

        //创建无参构造的对象
        TestConstructor testConstructor = testConstructorClass.
                getDeclaredConstructor(null).newInstance();
        System.out.println("无参构造："+testConstructor.toString());

        //创建有参构造的对象
        TestConstructor testConstructor1 = testConstructorClass
                .getDeclaredConstructor(String.class).newInstance("ilovehyz");
        System.out.println("有参构造："+testConstructor1.toString());
    }
}
