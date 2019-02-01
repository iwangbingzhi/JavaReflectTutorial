package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//使用反射中的Invoke方法执行Class对象的方法
public class InvokeDemo {
    @Test
    public void InvokeDemo() throws NoSuchMethodException, IllegalAccessException {
        Class<TestMethod> testMethodClass = TestMethod.class;

        //测试静态方法的执行
        Method testStatic = testMethodClass.getMethod("testStatic", null);
        try {
            testStatic.invoke(null, null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        TestMethod testMethod = new TestMethod();
        //测试有参方法的执行
        Method add = testMethodClass.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        int result = 0;
        try {
            result = (int) add.invoke(testMethod, 1, 2);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("add方法执行的结果result="+result);


        //测试方法的包装错误
        Method testException = testMethodClass.getMethod("testException", null);
        try {
            testException.invoke(testMethod, null);
        } catch (InvocationTargetException e) {
            System.out.println("该方法发生了一些错误，错误的类型是:"+e.getCause().getClass().getName());
            System.out.println("错误的信息是："+e.getCause().getMessage());
        }
    }
}
