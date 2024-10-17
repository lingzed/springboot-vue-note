# array转String

在String的构造方法中，可以接收数组类型的参数，并将该数组中的内容直接转换成字符串，<font color="red">能且仅能接收byte[]和char[]的数组</font>。

```java
// 使用字节数组创建一个字符串，默认使用平台的默认字符编码来进行解码。
String str = new String(byte[] bytes);
```

```java
// 从偏移量offset处开始，取length个字节
String str = new String(byte[] bytes,int offset,int length);
```

```java
// 使用字符数组创建一个字符串
String str = new String(char[] value);
```

```java
// 从偏移量offset处开始，取length个字符
String str = new String(char[] value,int offset,int length)
```



# getByte()

**getBytes()**方法在String类中用于将字符串转换为字节数组。

```java
// 方法签名：
public byte[] getBytes();
// 返回指定字符集的字节数组
public byte[] getBytes(Charset charset)s
```

```java
// 使用默认字符集（通常是UTF-8）将字符串转换为字节数组
String str = "Hello, World!";
byte[] bytes = str.getBytes(); 
```

```java
// 使用其他字符集如UTF-16，将字符串转换为字节数组
String str = "Hello, World!";
byte[] bytes = str.getBytes(StandardCharsets.UTF_16); 
```



# valueOf()

valueOf()是String的一个静态方法，用于将<font color='red'>各种类型</font>的数据转换为字符串类型。

```java
// 将整数42转换为字符串"42"
int number = 42;
String strNumber = String.valueOf(number); 
```

```java
// 将浮点数3.14转换为字符串"3.14"
double value = 3.14;
String strValue = String.valueOf(value); 
```

```java
// 将布尔值true转换为字符串"true"
boolean flag = true;
String strFlag = String.valueOf(flag); 
```

```java
// 将字符数组转换为字符串"Hello"
char[] charArray = {'H', 'e', 'l', 'l', 'o'};
String strFromArray = String.valueOf(charArray); 
```

```java
/**
将字节数组转换为字符串
第一个是ABC(ABC的字符编码是65，66，67)
第二个是[B@1b6d3586
valueOf方法得到的字节数组内存地址的字符串表示，所以处理字节数组
建议使用构造方法
*/
byte[] byteArray = {65, 66, 67};
String str1 = new String(byteArray);
String str2 = String.valueOf(byteArray);
```

```java
/** 
将MyObject对象转换为字符串，valueOf()当参数是Object时，会调用Object的toString()返回对象的内存地址的字符串表示
即:
1、如果对象没有重写toString方法，valueOf将其转换成内存地址的字符串
2、如果对象重写了toString方法，valueOf将其转换成toString重写后返回的字符串
3、如果只是想将对象转换成字符串，建议直接使用toString，因为valueOf(Object obj)底层也是调用toString，如此，还不如直接调用toString
*/ 
MyObj obj = new MyObj();
String strObj = String.valueOf(obj); // 输出com.example.MyObj@2a139a55
```



# String不变

String类是不可变的类，一旦设定了值就不可再改变，如果改变了值，则会在堆空间中重新分出一块内存来存储值，变量会引用新的值的内存地址，原来的值未被修改，保持不变。

![String改变在栈堆中的演示](D:\text1\java_text\assets\String改变在栈堆中的演示.png)



# charAt()

返回指定索引位置的字符。

```java
// 方法签名：
public char charAt(int index)
```

```java
String str = "Hello World";
char ch = str.charAt(0); // 获取索引为0的字符
System.out.println(ch); // 输出结果为 "H"
```



# substring()

截取字串

```java
// 返回从指定索引开始到字符串末尾的子串
public String substring(int beginIndex);

// 返回从开始索引到结束索引（不包括结束索引）的子串
public String substringsubstring(int beginIndex, int endIndex)
```

```java
String str = "Hello, World!";

// 从索引 0 开始截取到末尾，结果为 "Hello, World!"
String sub1 = str.substring(0); 

// 从索引 0 开始截取到索引 5（不包括），结果为 "Hello"
String sub2 = str.substring(0, 5); 

// 从索引 7 开始截取到末尾，结果为 "World!"
String sub3 = str.substring(7); 

// 从索引 7 开始截取到索引 12（不包括），结果为 "World"
String sub4 = str.substring(7, 12); 
```

