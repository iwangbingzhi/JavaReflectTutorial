package com.reflectpro;

public class TestConstructor {
    private String self;

    public TestConstructor() {
        self = "wbzhyz";
    }

    @Override
    public String toString() {
        return "TestConstructor{" +
                "self='" + self + '\'' +
                '}';
    }

    public TestConstructor(String self) {
        this.self = self;
    }
}
