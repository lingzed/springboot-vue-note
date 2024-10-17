# 1、字节流

一般以Stream结尾是字节流，字节流适合处理2进制文件，如：图片、视频



## 1.1、读

> FileInputStream是读文本内容的类，这里的input是指文本内容向java程序输入，所以是输入流，也是读文本内容，并非向文件写入内容



### 1.1.1、方法1：

```java
/**
获取文本,输入指定路径，\分隔符需要\转义符转义
*/
File file = new File("D:\\iodemo\\homework.txt");
// 实例化FileInputStream对象，将文本传入
FileInputStream fis = new FileInputStream(file);

/**
读取文本内容，因为字节流的文本形式是字节(byte)
所以获取的文本内容是byte型的
声明byte[]数组保存获取的文本内容,长度设置1024
*/
byte[] bt = new byte[1024];
// read()方法将文本内容读取保存入bt数组
fis.read(bt);
// 将数组转换成String类型，这样打印出的文本内容才是String类型
String str = new String(bt);
// 打印出文本内容，此处直接打印数组不会输出数组的内存地址
System.out.println(str);
```

![image-20230722193149138](D:\text1\java_text\assets\image-20230722193149138.png) 



### 1.1.2、方法2:

```java
File file = new File("D:\\iodemo\\homework.txt");
FileInputStream fis = new FileInputStream(file);

/**
直接将指定文件的数据读取到byte数组中，readAllBytes()方法
jdk9新加的特性，解决因byte[]过长而显示冗余的数据
*/
byte[] bt = fis.readAllBytes();
String str = new String(bt);
System.out.println(str);
```

![image-20230722193217707](D:\text1\java_text\assets\image-20230722193217707.png) 



## 1.2、写

>FileOutputStream是写文本内容的类，这里的output是指java程序输出内容到文本内容中，所以是输出流，也是写文本内容，并非读文件内容

```java
File file = new File("D:\\iodemo\\homework.txt");
// 实例化FileOutputStream对象，将文本传入
// 可以传入true参数防止文本写入覆盖
//FileOutputStream fos = new FileOutputStream(file,true);
FileOutputStream fos = new FileOutputStream(file);
// 写入数据，用String变量保存
String str = "sdifogpkplfkflg";
/**
字节流保存字节，所以将String转换成byte[]
getByte()将String转换成byte[]
*/ 
byte[] bt = str.getByte();
// write()将byte[]数组内容写入文件
fos.write(bt);
```



# 2、字符流

一般以reader或writer结尾是字符流。字符流更适合处理文本文件。

## 2.1、读

> FileReader()

```java
// 实例化FileReader对象
FileReader fr = new FileReader("D:\\iodemo\\homework.txt");
// 声明char[]用于保存读取的文本内容
char[] c = new char[256];
// read()方法读取数据，传入char[]，讲数据存入数组中
fr.read(c);
// valueOf()将char[]转换成字符串
String str = String.valueOf(c);
// 打印
System.out.println(str);
```



## 2.2、写

> FileWriter

```java
// 实例化FileWriter对象
// 可以传入true参数防止文本写入覆盖
// FileWriter fw = new FileWriter(filename,true);
FileWriter fw = new FileWriter("D:\\iodemo\\homework.txt");
// write()将内容写入缓存区
fw.write("HelloWorld");
// flush()将缓存区中的内容冲入文本中
fw.flush();
```



# 3、转换

InputStreamReader和InputStreamWriter是转换流，是字节流和字符流之间的桥梁，可以将字节流转换成字符流。



## 3.1、字节读--->字符读

```java
File file = new File("D:\\iodemo\\homework.txt");
FileInputStream fis = new FileInputStream(file);
// InputStreamReader将字节读换行成字节写
InputStreamReader isr = new InputStreamReader(fis);
// 转换后字节流读对象变成字符流读对象，可以使用字符流读的方法
```



## 3.2、字节写--->字符写

```java
File file = new File("D:\\iodemo\\homework.txt");
FileOutputStream fos = new FileOutputStream(file);
// InputStreamReader将字节读换行成字节写
OutputStreamWriter osw = new OutputWriter(fos);
// 转换后字节流写对象变成字符流写对象，可以使用字符流写的方法
```



# 4、区别

使用字节流，需要提前创建File对象，而使用字符流则不需要创建File对象，直接在字符流的构造方法中指定文件路径即可。

```java
// 提前创建file对象
File file = new File("D:\\iodemo\\homework.txt");

//然后将file对象传入字节流的构造方法中
FileInputStream fis = new FileInputStream(file);
FileOutputStream fos = new FileOutputStream(file);
```

```java
// 字符流不需要创建File对象，直接在构造方法中指定文件路径
FileWriter fw = new FileWriter("D:\\iodemo\\homework.txt");
FileReader fr = new FileReader("D:\\iodemo\\homework.txt");
```

字节流读取或写入都是byte类型数据，所以读取数据时需要用byte类型的容器接收，打印读取的数据，要将byte转换成String。写入数据时，也要讲字符串转换成byte写入。

字符流处理的是字符，读取数据时使用char类型的容器接收，打印时将char转换成String。写入时不需要转换类型。