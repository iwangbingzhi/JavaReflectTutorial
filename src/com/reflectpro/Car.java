package com.reflectpro;

import java.util.HashMap;
import java.util.List;

public class Car {
    private int a = 1;
    private String mBrand = "保时捷帕拉梅拉";

    private Color mColor;

    public enum Color {
        RED,
        WHITE,
        BLACK,
        BLUE,
        YELLOR
    }

    public Car() {

    }


    public Car(String mBrand) {
        this.mBrand = mBrand;
    }


    public void drive() {
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString() {
        return "Car [mBrand=" + mBrand + ", mColor=" + mColor + "]";
    }

    public String getName(String name){
        return name;
    }

    public void test(String[] params,List<String> l, HashMap<String,Integer> map){

    }
}
