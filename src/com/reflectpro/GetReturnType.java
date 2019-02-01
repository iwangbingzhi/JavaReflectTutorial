package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Method;

public class GetReturnType {
    @Test
    public void getReturnType(){
        Class<Car> carClass = Car.class;
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method m:declaredMethods) {
            System.out.println("方法的返回值类型："+m.getReturnType());
            System.out.println("方法的泛型返回值类型："+m.getGenericReturnType());

        }
    }
}
