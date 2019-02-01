package com.reflectpro;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class EnumDemo {
    @Test
    public void testEnum() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<State> stateClass = State.class;
        if (stateClass.isEnum()){
            System.out.println(stateClass.getName()+"是一个枚举");
            //获取所有的枚举常量
            System.out.println("枚举常量有："+ Arrays.asList(stateClass.getEnumConstants()));
            Field[] fields = stateClass.getDeclaredFields();
            for (Field f: fields) {
                if (f.isEnumConstant()){
                    System.out.println(f.getName()+"是一个枚举常量");
                }else {
                    System.out.println(f.getName()+"不是一个枚举常量");
                }
            }
            //对枚举进行取值和设置值
            Class<MeiJu> meiJuClass = MeiJu.class;
            MeiJu meiJu = meiJuClass.newInstance();

            Field f = meiJuClass.getDeclaredField("state");
            f.setAccessible(true);

            State state = (State) f.get(meiJu);
            System.out.println("State="+state);

            f.set(meiJu,state.STOP);
            System.out.println("State="+meiJu.getState());

            f.set(meiJu,state.IDLE);
            System.out.println("State="+meiJu.getState());

            f.set(meiJu,state.test);
            System.out.println("State="+meiJu.getState());
        }
    }
}
