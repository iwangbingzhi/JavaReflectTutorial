package com.enumdemo;



/**
 * @Description:
 * @Author 王炳智
 * @Date 2016/5/20 10:06
 */
public class Demo2 {
    public static void main(String[] args) {
        test2();
    }
    public static void test() {
        print1(Grade1.A);
    }

    public static void print1(Grade1 g) {
        String value = g.chinaValue();
        System.out.println(value);
    }
    public static void test2(){
        System.out.println(Grade1.A.name());
        System.out.println(Grade1.A.ordinal());

        String s = "B";
        Grade1 g = Grade1.valueOf(s);
        System.out.println(g);

       Grade1 gs[] = Grade1.values();  //返回枚举的所有枚举值
       for(Grade1 g1 : gs){
           System.out.println(g1);
       }
    }

}
//带抽象方法的枚举  枚举构造函数必须是私有的
enum Grade1{
    A("100-90"){
        public String chinaValue(){
            return "优";
        }
    }
    , B("89-80"){
        public String chinaValue(){
            return "良";
        }
    }
    , C("79-70"){
        public String chinaValue(){
            return "一般";
        }
    }
    , D("69-60"){
        public String chinaValue(){
            return "差";
        }
    }
    , E("59-0"){
        public String chinaValue(){
            return "不及格";
        }
    };

    private String value;

    private Grade1(String value) {
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public abstract String chinaValue();
}


