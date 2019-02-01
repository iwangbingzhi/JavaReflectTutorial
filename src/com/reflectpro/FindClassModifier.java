package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Modifier;

//获取Class对象的修饰符
public class FindClassModifier {
    @Test
    public void findModifier(){
        System.out.println(TestModifier.class.getModifiers());
        System.out.println(Modifier.toString(TestModifier.class.getModifiers()));
        System.out.println(Modifier.isPublic(TestModifier.class.getModifiers()));
        System.out.println(Modifier.isAbstract(TestModifier.class.getModifiers()));
        System.out.println(Modifier.isPrivate(TestModifier.class.getModifiers()));
    }
}
