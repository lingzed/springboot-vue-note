> UUID是通用唯一识别码，是一个长度固定的字符串，它是不会重复的。
>
> 获取UUID，可以使用java.util包下的UUID类，它有一个randomUUI()方法，能生成随机的UUID对象，通过toString方法就能获取UUID字符串：

![image-20240429195547663](assets/image-20240429195547663.png)

![image-20240429195614619](assets/image-20240429195614619.png)

> UUID字符串长度是32位，中间使用4个-来分隔，算上横杠一共36位。