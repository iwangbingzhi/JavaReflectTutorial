package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Field;

public class GetFieldType {

    /*
    public Type getGenericType() {}

    public Class<?> getType() {}
     */
    @Test
    public void getFieldTypeDemo() throws NoSuchFieldException {
        Class<Son> sonClass = Son.class;
            System.out.println("son Type=" + sonClass.getField("cars").getType());
            System.out.println("son Type=" + sonClass.getField("map").getType());

        Field[] fields = sonClass.getFields();
        for (Field f : fields) {
            System.out.println("Field:" + f.getName());
            System.out.println("Field type:" + f.getType());
            System.out.println("Field generic type:" + f.getGenericType());
            System.out.println("--------------");

         Field[] fields2 = sonClass.getDeclaredFields();
         for (Field f2 : fields2) {
             System.out.println("declaredField:" + f2.getName());
             System.out.println("declaredField type:" + f2.getType());
             System.out.println("declaredField generic type:" + f2.getGenericType());
             System.out.println("--------------");
            }
        }
    }
}

