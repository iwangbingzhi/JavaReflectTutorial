# 反射总结：</br>
---
## 获取Class对象有三种方式：</br>
1.使用对象的 getClass() 方法，如<code>var person = new Person;person.getClass();</code></br>
2.使用 .class，如<code>int.class;Person.class;</code></br>
3.使用 Class.forName()添加Class对象的路径。如<code>Class.forName("com.google.mybatis");</code></br>

</br>
## 获取Class对象的相关信息：</br>
1.getName();获取Class对象全限定类名 比如<code>"com.apple.test"</code></br>
2.getSimpleName();直接获取对象的名字，不包含包名,比如<code>"test"</code></br>
注：如果是数组类型的话，getName()是在前面加上[,
<code>
String[].class.getName();
</code>
返回的就是
<code>[Ljava.lang.String</code>
(其中的L代表的是在java内部的命名规则中的代表类或者接口的形式,如果是int[]则是返回的[I)</br>
而getSimpleName()是在后面加上对应维度的[]</br>
如
<code>
String[][][].class.getSimpleName();
String[][][]
</code></br>
还有一个 getCanonicalName()返回官方名字，如果官方名字不存在就会返回null(局部类和匿名内部类不存在官方名字)</br>

## 获取Class对象的修饰符
getModifiers()</br>
<code>
public class Test{}
Test.class.getModifiers()
</code></br>
此时返回的是一个数（1），在java内部都是通过数字代表着不同的修饰符，此时我们需要通过Modifier.toString()方法把该数值转换成字符串</br>


## 获取Class对象的属性：（英文名叫Field）</br>
<code>getDeclaredField()</code>,可以获取到被private修饰的属性，不能从父类获取属性</br>
<code>getField()</code>，可以获取到非private修饰的属性，如果是当前类中不含有该属性，但是有父类存在的话，会从父类中寻找是否存在该属性</br>
<code>getDeclaredFields() </code>，注意这里多了一个s,该方法的意义在于获取所有的属性，但是不包含从父类继承过来的属性</br>
<code>getFields()</code>，获取自身的所有public修饰的属性，并且包括从父类继承过来的</br>



## 获取Class对象中的函数：（英文名叫Method）</br>
<code>getDeclaredMethod(String name, Class<?>... parameterTypes)</code>,获取到Class对象中的private修饰的方法，不包括父类（第一个参数方法名，第二个参数填写方法的参数，个数是不定的，根据方法的参数个人来确定，并且传入的参数类型都必须是.class类型的）
```
//如下所示
Method methodtest = class1.getDeclaredMethod("test",int.class,float.class);
//如果是方法的参数过多可以采取如下形式
Method methodtest = class1.getDeclaredMethod("test",new Class[]{int.class,float.class});
```
</br>
<code>getMethod(String name, Class<?>... parameterTypes)</code>，获取到Class对象中的非private修饰的方法,包括父类</br>
<code>getDeclaredMethods() throws SecurityException</code>，获取本Class中的所有方法，不包含从父类继承过来的</br>
<code>getMethod(String name, Class<?>... parameterTypes)</code>，获取本Class中的所有Public修饰的方法，包括从父类继承过来的</br>


## 获取Class对象中的构造函数（Constructor）</br>
<code>public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)</code>,获取到被private修饰的构造方法</br>
<code>public Constructor<T> getConstructor(Class<?>... parameterTypes)</code>，获取到被非private修饰的构造方法</br>
<code>public Constructor<?>[] getDeclaredConstructors() throws SecurityException</code>，获取到所有的构造方法</br>
<code>public Constructor<?>[] getConstructors() throws SecurityException</code> ，获取到被public修饰的构造方法</br>
Constructor 不能从父类继承，所以就没有办法通过 getConstructor() 获取到父类的 Constructor。</br>

## Class属性的操作</br>
<code>getGenericType()</code>，获取泛型属性类型</br>
<code>getType()</code>，获取属性类型</br>
<code>getModifiers()</code>获取属性的修饰符</br>
<code>public Object get(Object obj)</code>获得属性的值，参数填写要获取值的对象（该方法有一系列的值在此不多多列举，可以参考官方文档）</br>
<code>public void set(Object obj, Object value);</code>设置属性的值，第一个参数填写设置值的对象，第二个值填写要设置的值</br>
【注:】
如果访问的值是private的，通过get获取值的时候会报错<code>java.lang.IllegalAccessException: Class com.xxx.xxx.xxx can not access a member of class com.xx.xx.x with modifiers "private"</code></br>
此时只需要添加该代码，boolean值设置为true,即可解决<code>setAccessible(true);</code></br>

## Class中方法：</br>
<code>getName()</code> 获取方法名</br>
<code>public Parameter[] getParameters()</code>获取到方法的参数</br>
<code>public String getName()</code>获取参数名字</br>
<code>public Class<?> getType()</code>获取参数类型</br>
<code>public int getModifiers()</code>获取参数的修饰符</br>
<code>public Class<?>[] getParameterTypes()</code> 获取所有的参数类型</br>
<code>public Type[] getGenericParameterTypes()</code> 获取所有的参数类型，包括泛型</br>
代码操作如下所示</br>
```
        Class<Car> carClass = Car.class;
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method m: declaredMethods) {
            System.out.println("方法名字："+m.getName());
            Parameter[] parameters = m.getParameters();
            for (Parameter p:parameters) {
                System.out.println("参数名字："+p.getName()+"参数类型："+p.getType());
            }
            Class[] parameterTypes = m.getParameterTypes();
            System.out.println("方法参数类型————————");
            for (Class type:parameterTypes) {
                System.out.println(" "+type.getName());
            }
```
### 获取返回值：</br>
`public Class<?> getReturnType()`获取返回值类型</br>
`public Type getGenericReturnType()`获取返回值类型包括泛型</br>
```
        Class<Car> carClass = Car.class;
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method m:declaredMethods) {
            System.out.println("方法的返回值类型："+m.getReturnType());
            System.out.println("方法的泛型返回值类型："+m.getGenericReturnType());
```
```
        方法的返回值类型：class java.lang.String
        方法的泛型返回值类型：class java.lang.String
        方法的返回值类型：class java.lang.String
        方法的泛型返回值类型：class java.lang.String
        方法的返回值类型：void
        方法的泛型返回值类型：void
```

`public int getModifiers();`获取方法修饰符</br>
`public Class<?>[] getExceptionTypes()` 获取异常类型</br>
`public Type[] getGenericExceptionTypes()`获取泛型异常类型</br>

## 方法的调用:</br>
`public Object invoke(Object obj, Object... args) `</br>
该方法可以执行你通过反射得到的Class对象的方法，第一个Object参数是传入要调用方法的初始化之后的对象，第二个参数传入调用该方法所需要用到的的实际参数，静态方法中第一个参数为空，如果调用的方法不需要传入参数，那么直接为null;
```
        //测试静态方法的执行
        Method testStatic = testMethodClass.getMethod("testStatic", null);
        try {
            testStatic.invoke(null, null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
```
```
        public class TestMethod {
              private int add (int a,int b ) {
                  return a + b;
              }
              
              

        TestMethod testMethod = new TestMethod();
        //测试有参方法的执行
        Method add = testMethodClass.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        int result = 0;
        try {
            result = (int) add.invoke(testMethod, 1, 2);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("add方法执行的结果result="+result);
```
。。。。。。。。。。。。。。。。。。。。。。。。。。。。。休息休息一下，未完待续！！

本文档一部分内容来自于 https://blog.csdn.net/briblue/article/details/74616922    </br>


