package com.myreflectcsimplefactory;

import java.lang.reflect.InvocationTargetException;

public class CarFactory {
    public Car getCar(String carname) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName(carname);
        Car c = (Car) aClass.getConstructor().newInstance();
        return c;
    }
}

