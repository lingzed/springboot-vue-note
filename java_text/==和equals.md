# 对于基本数据类型

基本数据类型中没有equals()方法，只有==。基本数据类型将值直接存入变量中，所以==比较的是值是否相等

```java
public class Test {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int c = 5;
        System.out.println(a==b);   // true
        System.out.println(a==c);   // false
    }
}
```



# 对于引用数据类型

引用数据类型将引用的内存地址存入变量中，而不是将数据内容存入变量。所以==比较的是变量的内存是否指向同一个引用数据，如果是同一个那么相同否则不相等。

```java
public class Test {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        // a和b指向同一个hello，所以相等
        System.out.println(a==b);   // true
        // c是新分配的String堆内存，引用内存地址与a,b不同
        System.out.println(a==c);   // false
    }
}
```



equals()方法是从Object类继承的，默认行为与==相同，也是比较的引用的内存地址。但是，许多Java类（如String、Integer、Double等）重写了equals()方法，使其用于比较内容而不是引用。

```java
public class Test {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        // a和b的内容相同
        System.out.println(a.equals(b));   // true
        // c的引用内存地址与a,b不同，但内容与a,b相同
        System.out.println(a.equals(c));   // true
    }
}
```

