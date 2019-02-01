package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Field;


public class GetFiled {
    /*
    获取指定名字的属性 getDeclaredField()  getField()
     getDeclaredField()获取的是 Class 中被 private 修饰的属性。
     getField() 方法获取的是非私有属性，并且 getField()在当前 Class 获取不到时会向祖先类获取。
    */
    /*
        getDeclaredFields()获取所有的属性，但不包括从父类继承下来的属性
        getFields()获取自身的所有的 public 属性，包括从父类继承下来的。
     */
    @Test
    public void getFiledDemo1() throws Exception {
        //本类没有，从父类获取
        Field a = Son.class.getField("a");
        System.out.println("a=" + a);

        Field d = Son.class.getDeclaredField("d");
        System.out.println("d=" + d);

        //获取public属性，包括继承来的
        Field[] fields1 = Son.class.getFields();
        for (Field f: fields1) {
            System.out.println("fields"+f.getName());
        }

        //获取所有属性，但是不包括继承来的
        Field[] fields2 = Son.class.getDeclaredFields();
        for (Field f: fields2) {
            System.out.print("DeclaredFields:"+f.getName()+"  ");
        }


    }
}
