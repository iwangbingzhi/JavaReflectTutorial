package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class GetConstructors {
    /*
    Constructor 不能从父类继承，所以就没有办法通过 getConstructor() 获取到父类的 Constructor。
     */
    @Test
    public void getConstructorDemo1() throws NoSuchMethodException {
        Constructor<Father> constructor = Father.class.getConstructor(null);
        System.out.println("父类空参数构造函数:"+constructor);

        Constructor<Father> constructor2 = Father.class.getConstructor(int.class,int.class);
        System.out.println("父类有参数构造函数:"+constructor);

        Constructor<Son> constructor3 = Son.class.getConstructor(null);
        System.out.println("子类无参数构造函数:"+constructor3);

        Constructor<Son> constructor4 = Son.class.getConstructor(int.class,String.class);
        System.out.println("子类有参数构造函数:"+constructor4);

        Constructor<Son> constructor5 = Son.class.getDeclaredConstructor(int.class,String.class);
        System.out.println("子类有参数构造函数:"+constructor5);

        Constructor<Father> constructor6 = Father.class.getDeclaredConstructor(int.class,int.class);
        System.out.println("父类有参数构造函数:"+constructor6);


    }
}
