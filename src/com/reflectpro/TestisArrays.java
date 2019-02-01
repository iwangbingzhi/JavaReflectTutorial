package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

//判断类中的属性是否是数组，以及测试数组的类型，通过反射创建一个数组,以及数组的取值和赋值
public class TestisArrays {
    @Test
    public void testArrays() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<ArraysDemo> arraysDemoClass = ArraysDemo.class;
        Field[] declaredFields = arraysDemoClass.getDeclaredFields();
        for (Field f:declaredFields) {
            Class type = f.getType();
            if (type.isArray()){
                System.out.println("数组类型是:"+type.getName());
                System.out.println("数组里面的元素类型是"+type.getComponentType());
            }
        }

        //创建数组并添加元素
        //创建ArraysDemo对象
        ArraysDemo arraysDemo = arraysDemoClass.newInstance();
        Field arrayF = arraysDemoClass.getDeclaredField("a");
        arrayF.setAccessible(true);

        Object o = Array.newInstance(int.class, 3);
        Array.set(o,0,1);
        Array.set(o,1,2);
        Array.set(o,2,3);

        arrayF.set(arraysDemo,o);
        int[] array = arraysDemo.getA();
        for (int i = 0; i < array.length; i++) {
            System.out.println("数组的索引是:"+i+"  数组的值是"+array[i]);

        }
    }
}
