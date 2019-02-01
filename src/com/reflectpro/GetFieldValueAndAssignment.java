package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Field;

//对于Field的取值和赋值
public class GetFieldValueAndAssignment {
    @Test
    public void getFieldValueAndAssignment() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car();

        Class<Car> carClass = Car.class;
        Field aInt = carClass.getDeclaredField("a");
        aInt.setAccessible(true);
        //获取值
        int anInt = aInt.getInt(car);
        System.out.println("获取的a="+anInt);

        //设置值
        aInt.setInt(car,5);
        int ia = aInt.getInt(car);
        System.out.println("赋值之后的a="+ia);

    }
}
