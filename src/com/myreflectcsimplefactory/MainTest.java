package com.myreflectcsimplefactory;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//使用反射来实现简单工厂模式
public class MainTest {
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        var carFactory = new CarFactory();
        Class<CarFactory> carFactoryClass = CarFactory.class;
        Method getCar = carFactoryClass.getDeclaredMethod("getCar", String.class);
        Car car = (Car) getCar.invoke(carFactory, "com.myreflectcsimplefactory.BMW");
        String name = car.getName();
        System.out.println("汽车的名字:"+name);
    }
}
