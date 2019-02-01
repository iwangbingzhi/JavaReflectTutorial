package com.reflectpro;

import org.junit.Test;

//三种获取Class对象的方式
public class FindClass {

    //通过forName寻找类
    @Test
    public void reflectDemo1(){
        try {
            Class c = Class.forName("com.reflectpro.Car");
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //通过Object.getClass()获取对象
    @Test
    public void reflectDemo2(){
        Car p = new Car();
        Class aClass = p.getClass();
        System.out.println(aClass);
    }
    //通过.class标志获取
    @Test
    public void reflectDemo3(){
        Class aClass = Car.class;
        System.out.println(aClass);

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
    }
    //通过getName()获取Class的名字  返回Class对象的关键字
    @Test
    public void reflectDemo4(){
        Class aClass = Car.class;
        System.out.println(aClass.getName());

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass.getName());

        Class aClass1 = new int[]{}.getClass();
        System.out.println(aClass1.getName());

        Class aClass2 = new Car[]{}.getClass();
        System.out.println(aClass2.getName());

        Class aClass3 = new int[][][]{}.getClass();
        System.out.println(aClass3.getName());

        Class aClass4 = new String[][][]{}.getClass();
        System.out.println(aClass4.getName());
    }
    //通过getSimpleName()获取Class对象名字
    @Test
    public void reflectDemo5(){
        Class innerClass = Outter.Inner.class;

        System.out.println(innerClass.getName());
        System.out.println(innerClass.getSimpleName());

        Class aClass = new Outter.Inner[][][]{}.getClass();
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
    }
    //匿名内部类getSimpleName()返回的是空字符串
    @Test
    public void reflectDemo6(){
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };


        System.out.println(r.getClass().getName());
        System.out.println("r.SimpleName:"+r.getClass().getSimpleName());
    }

/*    getCanonicalName() 返回的也是全限定类名，但是对于内部类，不用 $ 开头，而用 .。
    getCanonicalName() 对于数组类型的 Class，同 simplename 一样直接在后面添加 [] 。
    getCanonicalName() 不同于 simplename 的地方是，不存在 canonicalName 的时候返回 null 而不是空字符串。
    局部类和匿名内部类不存在 canonicalName。
    如果 Class 对象没有 canonicalName 的话就返回 null。
    */
    @Test
    public void reflectDemo7(){
        Class aClass = new Outter.Inner().getClass();
        System.out.println("aClass.name:"+aClass.getName());
        System.out.println("aClass.simplename:"+aClass.getSimpleName());
        System.out.println("aClass.canonicalname:"+aClass.getCanonicalName());
        System.out.println("-------------------------");

        //对于数组类型的class getSimpleName(),getCanonicalName()都是在后面返回[]
        Class aClass2 = new Outter.Inner[][][]{}.getClass();
        System.out.println("aClass2.name:"+aClass2.getName());
        System.out.println("aClass2.simplename:"+aClass2.getSimpleName());
        System.out.println("aClass2.canonicalname:"+aClass2.getCanonicalName());
        System.out.println("-------------------------");

        //匿名类的使用  getSimpleName()返回空字符串  getCanonicalName()返回null
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        System.out.println("r.name:"+r.getClass().getName());
        System.out.println("r.simplename:"+r.getClass().getSimpleName());
        System.out.println("r.canonicalname:"+r.getClass().getCanonicalName());
        System.out.println("-------------------------");


        //局部类
        class local{};
        System.out.println("local.name:" + local.class.getName());
        System.out.println("local.simplename:" + local.class.getSimpleName());
        System.out.println("local.canonicalname:" + local.class.getCanonicalName());
        System.out.println("-------------------------");
    }

}
