package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class GetMethodParameters {
    @Test
    public void getMethodParameters(){
        Class<Car> carClass = Car.class;
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method m: declaredMethods) {
            System.out.println("方法名字："+m.getName());
            Parameter[] parameters = m.getParameters();
            for (Parameter p:parameters) {
                System.out.println("参数名字："+p.getName()+"参数类型："+p.getType());
            }
            Class[] parameterTypes = m.getParameterTypes();
            System.out.println("方法参数类型————————");
            for (Class type:parameterTypes) {
                System.out.println(" "+type.getName());
            }
            System.out.println(" ");
            Type[] genericParameterTypes = m.getGenericParameterTypes();
            System.out.println("泛型方法类型:");
            for (Type g: genericParameterTypes) {
                System.out.println(" "+g.getTypeName());
            }
        }
    }
}
