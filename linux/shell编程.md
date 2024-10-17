# shell

linux的内核无法直接访问，需要借助shell才能访问linux的内核

![image-20230704181227565](D:\text1\linux\assets\image-20230704181227565.png) 

# 编写shell脚本

```
vi /opt/shell/f1.sh
#!/bin/bash
echo 恭喜成功编写第一个shell脚本!

#!/bin/bash		意思是告诉系统代码用/bin/bash来运行，/bin/bash				自身就是一种shell
echo			打印
```

新建的shell任何用户都没有可执行的权限

![image-20230704182249190](D:\text1\linux\assets\image-20230704182249190.png) 

```
chmod a+x f1.sh
```

```
执行方式1
./f1.sh		执行文件，要找到这个文件./就是当前目录下这个文件
```

![image-20230704182532837](D:\text1\linux\assets\image-20230704182532837.png) 

```
执行方式2
/bin/bash f1.sh
```

![image-20230704182805670](D:\text1\linux\assets\image-20230704182805670.png) 

```
执行方式3
配置环境变量，将.配置到PATH中，再执行f1.sh
```

![image-20230704183043240](D:\text1\linux\assets\image-20230704183043240.png) 

![image-20230704183121582](D:\text1\linux\assets\image-20230704183121582.png) 

# shell参数

```
$0		表示执行的文件名
$1		第1个参数
$2		第2个参数
.
$n		第n个参数

$#		参数个数
$*		*匹配所有参数
```

![image-20230704183644055](D:\text1\linux\assets\image-20230704183644055.png) 

运行时携带参数会打印出来

![image-20230704183907515](D:\text1\linux\assets\image-20230704183907515.png)  

====

![image-20230704184322390](D:\text1\linux\assets\image-20230704184322390.png) 

====

![image-20230704184434757](D:\text1\linux\assets\image-20230704184434757.png) 

# shell变量

## 变量命名

```
变量名=值	=不能空格，变量名只能字母、数字、_、$且首字符不能是数字
```

![image-20230704195519983](D:\text1\linux\assets\image-20230704195519983.png) 

===

![image-20230704195532945](D:\text1\linux\assets\image-20230704195532945.png) 

## 只读变量

```
readonly 变量名	指定变量为只读，不可修改，否则报错
```

![image-20230704195900209](D:\text1\linux\assets\image-20230704195900209.png) 

===

![image-20230704195921736](D:\text1\linux\assets\image-20230704195921736.png) 

## 删除变量

```
unset 变量名
```

![image-20230704200501606](D:\text1\linux\assets\image-20230704200501606.png) 

===

![image-20230704200529975](D:\text1\linux\assets\image-20230704200529975.png) 

## 变量类型

```
局部变量		在shell中定义的变量，只有在shell中访问
环境变量		在/etc/profile中定义的变量，比如：JAVA_HOME，所				有程序都能访问
shell变量		 由shell程序设置的特殊变量 
```

## 字符串引号  

```
不加引号	对变量无影响		
加单引号	会原样输出''内的内容，不会输出变量
加双引号	对变量无影响
```

![image-20230705142619785](D:\text1\linux\assets\image-20230705142619785.png) 

## 获取字符串长度

```
${#字符串长度}
```

![image-20230705145209051](D:\text1\linux\assets\image-20230705145209051.png) 

## 提取子字符串

```
${字符串变量:start:len}		从start开始，提取len长度的字符，索引							 从0开始
```

![image-20230705145528973](D:\text1\linux\assets\image-20230705145528973.png) 

# 流程控制结构

## if

```
#!/bin/bash
if [ 分支条件 ]		if和[]间有空格，[]作业两边也有空格
then
语句块
fi				   fi是结束语，必须写

写在一行
if [ 分支条件 ]; then 语句块; fi
```

![image-20230705151015157](D:\text1\linux\assets\image-20230705151015157.png) 

## if elif

```
#!/bin/bash
if [ 分支条件 ]
	then
	语句块
elif [ 分支条件 ]
	then
	语句块
	.
	.
else
	then
	语句块
fi
```

![image-20230705152750458](D:\text1\linux\assets\image-20230705152750458.png) 

## for循环

```
for var in item1 item2...		var是循环变量，item是数组
do								do开头
	...
done							done结尾
```

![image-20230705153428034](D:\text1\linux\assets\image-20230705153428034.png) 

## while循环

```
while 循环条件
do
	循环体
done
```

![image-20230705154310793](D:\text1\linux\assets\image-20230705154310793.png) 

# 运算符

## 算术

```
原生的shell不支持简单的算术运算，必须借助于：awk或者expr
expr是一款表达式运算工具
```

```
使用expr时，必须加反引号``，如`expr 2 + 2`，乘法符号*是一个特殊字符，需要加转译符\

加		+
减		-
乘		\*
除		/
余		%
等		==
不等 	   !=
```

![image-20230705160048717](D:\text1\linux\assets\image-20230705160048717.png) 

## 比较

```
比较运算符只支持数字不支持字符串，除非字符串的值是数字
是否=		-eq
是否!=	-ne
>		 -gt
<		 -lt
>=		 -ge
<=		 -le

```

## 布尔运算

```
!	非运算
-o	或运算
-a	与运算
```

## 逻辑运算

```
&&	and运算
||	or运算
```

