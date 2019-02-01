package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Method;

public class FindMethodName {
    @Test
    public void findMethodName(){
        Class<Car> carClass = Car.class;
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method m: declaredMethods) {
            System.out.println("car中的方法名："+m.getName());
        }
    }
}
