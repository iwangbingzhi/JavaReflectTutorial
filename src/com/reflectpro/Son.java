package com.reflectpro;

import java.util.HashMap;
import java.util.List;

public class Son extends Father {
    int c;
    private String d;
    protected float e;
    public List<Car> cars;
    public HashMap<Integer,String> map;

    public void add(int x,int y){
        int i = x + y;
        System.out.println(i);
    }

    public Son(int c, String d) {
        this.c = c;
        this.d = d;
    }

    public Son() {
    }
}
