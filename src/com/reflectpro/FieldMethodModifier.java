package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Modifier;

//获取属性的修饰符
public class FieldMethodModifier {
    @Test
    public void fieldMethodModifier() throws NoSuchFieldException, NoSuchMethodException {
        Class<Son> sonClass = Son.class;
        //获取 private String d;
        System.out.println(Modifier.toString(sonClass.getDeclaredField("d").getModifiers()));

        //获取protected float e;
        System.out.println(Modifier.toString(sonClass.getDeclaredField("e").getModifiers()));

        //获取方法的修饰符
        System.out.println(Modifier.toString(Son.class.getDeclaredMethod("add", int.class, int.class).getModifiers()));

        //获取构造方法的修饰符
        System.out.println(Modifier.toString(Son.class.getDeclaredConstructor(int.class, String.class).getModifiers()));


    }
}
