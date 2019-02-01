反射总结：</br>
---
获取Class对象有三种方式：</br>
1.使用对象的 getClass() 方法，如<code>var person = new Person;person.getClass();</code></br>
2.使用 .class，如<code>int.class;Person.class;</code></br>
3.使用 Class.forName()添加Class对象的路径。如<code>Class.forName("com.google.mybatis");</code></br>

</br>
获取Class对象的相关信息：</br>
1.getName();获取Class对象全限定类名 比如<code>"com.apple.test"</code></br>
2.getSimpleName();直接获取对象的名字，不包含包名,比如<code>"test"</code></br>
注：如果是数组类型的话，getName()是在前面加上[,
<code>
String[].class.getName();
</code>
返回的就是
<code>[Ljava.lang.String</code>
(其中的L代表的是在java内部的命名规则中的代表类或者接口的形式,如果是int[]则是返回的[I)</br>
而getSimpleName()是在后面加上对应维度的[]
如
<code>
String[][][].class.getSimpleName();
String[][][]
</code></br>
还有一个 getCanonicalName()返回官方名字，如果官方名字不存在就会返回null(局部类和匿名内部类不存在官方名字)

获取Class对象的修饰符
getModifiers()
<code>
public class Test{}
Test.class.getModifiers()
</code></br>
此时返回的是一个数（1），在java内部都是通过数字代表着不同的修饰符，此时我们需要通过Modifier.toString()方法把该数值转换成字符串</br>


获取Class对象的属性：（英文名叫Field）</br>
<code>getDeclaredField()</code>,可以获取到被private修饰的属性，不能从父类获取属性</br>
<code>getField()</code>，可以获取到非private修饰的属性，如果是当前类中不含有该属性，但是有父类存在的话，会从父类中寻找是否存在该属性</br>
<code>getDeclaredFields() </code>，注意这里多了一个s,该方法的意义在于获取所有的属性，但是不包含从父类继承过来的属性</br>
<code>getFields()</code>，获取自身的所有public修饰的属性，并且包括从父类继承过来的</br>



获取Class对象中的函数：（英文名叫Method）</br>
<code>getDeclaredMethod(String name, Class<?>... parameterTypes)</code>,获取到Class对象中的private修饰的方法，不包括父类（第一个参数方法名，第二个参数填写方法的参数）</br>
<code>getMethod(String name, Class<?>... parameterTypes)</code>，获取到Class对象中的非private修饰的方法,包括父类</br>
<code>getDeclaredMethods() throws SecurityException</code>，获取本Class中的所有方法，不包含从父类继承过来的</br>
<code>getMethod(String name, Class<?>... parameterTypes)</code>，获取本Class中的所有Public修饰的方法，包括从父类继承过来的</br>


获取Class对象中的构造函数（Constructor）</br>
<code>public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)</code>,获取到被private修饰的构造方法</br>
<code>public Constructor<T> getConstructor(Class<?>... parameterTypes)</code>，获取到被非private修饰的构造方法</br>
<code>public Constructor<?>[] getDeclaredConstructors() throws SecurityException</code>，获取到所有的构造方法</br>
<code>public Constructor<?>[] getConstructors() throws SecurityException</code> ，获取到被public修饰的构造方法</br>
Constructor 不能从父类继承，所以就没有办法通过 getConstructor() 获取到父类的 Constructor。

Class属性的操作</br>
<code>getGenericType()</code>，获取泛型属性类型</br>
<code>getType()</code>，获取属性类型</br>
<code>getModifiers()</code>获取属性的修饰符</br>

。。。。。。。。。。。。。。。。。。。。。。。。。。。。。休息休息一下，未完待续！！

本文档一部分内容来自于 https://blog.csdn.net/briblue/article/details/74616922    </br>


