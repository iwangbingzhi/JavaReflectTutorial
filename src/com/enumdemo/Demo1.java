package com.enumdemo;


/**
 * @Description:
 * @Author 王炳智
 * @Date 2016/5/20 9:40
 */
//枚举
public class Demo1 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        print(Grade.B);
    }

    public static void print(Grade g) {
        String value = g.getValue();
        System.out.println(value);
    }

}
//如何定义枚举的构造函数，方法和字段去封装更多的信息
    enum Grade {
        A("100-90"), B("89-80"), C("79-70"), D("69-60"), E("59-0");

        private String value;

        private Grade(String value) {
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
