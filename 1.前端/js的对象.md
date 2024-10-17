# js的对象

> js的对象大致分为三种类型：
>
> 1. 基本对象，种类很多但主要关注这三个：Array(数组对象)、String(字符串对象)、JSON
> 2. BOM，浏览器对象模型，js中对浏览器中的各个组件进行了封装，这部分的对象叫做BOM对象
> 3. DOM，文档对象模型，将HTML中的标签(<>)都封装成了一个对象，这类对象叫做DOM对象



# Array对象

> Array对象在js中用来定义数组

```js
// 方式1
var 变量名 = new Array(元素列表);
// 方式2
var 变量名 = [元素列表];
// 取值
arr[索引];
// 赋值
arr[索引]=值;
```

```js
var arr = new Array(1,2,3,4);
var arr1 = [1,3,5,7,9];
console.log(arr);
console.log(arr1[2]);
```

![image-20231211170300908](D:\text1\1.前端\assets\image-20231211170300908.png)



## 数组长度可变

> js中的数组和java不同，它的长度说可变的

```js
var arr = [1,2,3];
arr[10] = 50;
console.log(arr[10]);
// 空出的位置会用empty显示
console.log(arr);
// 但是获取的值是undefined
console.log(arr[9]);
console.log(arr[8]);
```

![image-20231211171119576](D:\text1\1.前端\assets\image-20231211171119576.png)



## 数组类型可变

> 数组可以同时存储不同类型的数据

```js
var arr = [1,2,3];
arr[1] = 'hello';
console.log(arr);
var arr1 = ['张三',20,[1,2]];
console.log(arr1);
```

![image-20231211171636892](D:\text1\1.前端\assets\image-20231211171636892.png)



## 属性

> Array的常用属性length，获取数组的长度

```js
var arr = [1,2,3,4,5,6,7,8,9];
console.log('arr的长度是'+arr.length);
```

![image-20231211172025171](D:\text1\1.前端\assets\image-20231211172025171.png)

> 遍历数组

```js
for(var i = 0;i<arr.length;i++){
    console.log(arr[i]);
}
```

![image-20231211172258325](D:\text1\1.前端\assets\image-20231211172258325.png)



## 方法

> 介绍数组的常用方法

### forEach()

> 遍历数组中每个<font color='red'>有值</font>的元素(没有值的元素不会遍历)，并调用一次传入的函数

> forEach()<font color='red'>必须传入函数</font>，用来处理遍历的数组元素，每遍历一次，就会对这个元素执行该函数，如果不传入函数就会报错

![image-20231212104746607](D:\text1\1.前端\assets\image-20231212104746607.png)



```js
var arr = [1,2,3];
arr[4] = 5;
arr[5] = 6;
// forEach()的参数函数接收三个参数，分别是数组的元素，元素的索引，数组本身
// forEach()只遍历有值的元素，所以索引为3的元素不会遍历
arr.forEach(function(item,index,arr){
  console.log(item);
  console.log(index);
  console.log(arr);
});
```

![image-20231212105243460](D:\text1\1.前端\assets\image-20231212105243460.png)

> 在日常开发中只会用到第一个参数

```js
var arr = [1,2,3];
arr[4] = 5;
arr[5] = 6;
arr.forEach(function(e){
  console.log(e);
});
```

![image-20231212105439191](D:\text1\1.前端\assets\image-20231212105439191.png)

### 箭头函数

> 函数可以用箭头函数简化，function可以省略，()保留，形参照样写在()中，用=>指向函数体，{}中跟上函数体

> (...) => {...}

```js
// 用箭头函数来简化forEach
var arr = [2,4,6,8,10];
arr.forEach((e) => {console.log(e)});
```

![image-20231212110312546](D:\text1\1.前端\assets\image-20231212110312546.png)

#### 省略()

> 当只有一个参数时，可以省略参数的括号

```js
// 有一个参数
const func = x => {retrun x * 2};
console.log(func(4));
```

![image-20231214101012322](D:\text1\1.前端\assets\image-20231214101012322.png)

#### 省略{}和 return

> 当函数体只有一条返回语句时，可以省略花括号和 return关键字，另外函数体只有一条语句，即使不是返回语句，也可以省略花括号

```js
// 函数体只有一条语句，且该语句是返回语可省略{}和return
const func = x => x * 2;
var num = func(3)
console.log(num);
```

![image-20231214164151956](D:\text1\1.前端\assets\image-20231214164151956.png)

```js
// 数体只有一条语句，即使不是返回语句，也可以省略花括号
var greet = name => console.log(`Hello, ${name}!`);
greet('John');
```

![image-20231214161143772](D:\text1\1.前端\assets\image-20231214161143772.png)

#### 保留()和{}

> 当函数有多个参数时，需要保留()，当函数体有多条语句时要保留{}，并且可能还需要使用return明确返回值

```js
var sum2 = (x,y) => {
    var sum = x + y;
    return sum*2;
}
var s = sum2(4,10);
console.log(s);
```

![image-20231214165549864](D:\text1\1.前端\assets\image-20231214165549864.png)



### push()

> 在数组的<font color='red'>末尾</font>添加元素

```js
var arr = [1,2,3];
arr.push(4);
console.log(arr);
// 一次性添加多个
arr.push(5,6,7);
console.log(arr);
```

![image-20231212110542838](D:\text1\1.前端\assets\image-20231212110542838.png)



### splice()

> 删除数组的元素，该方法接收两个参数，第一个表示从哪个索引位置开始删除，第二个表示删除几个元素

```js
var arr = [1,2,3,4,5,6,7,8,9,10];
console.log(arr);
// 从索引5开始删除5个元素
arr.splice(5,5);
console.log(arr);
```

![image-20231212110848884](D:\text1\1.前端\assets\image-20231212110848884.png)



# String对象

> 创建String对象有两种方式，创建时不区分""和''

```js
// 方式1
var str = new String('hello');
console.log(str);

// 方式2
var str1 = 'world';
console.log(str1);
```

![image-20231212111659280](D:\text1\1.前端\assets\image-20231212111659280.png)



## 属性

> -常用的属性length，获取字符串的长度

```js
var str = 'world';
console.log(str.length);
```

![image-20231212111829897](D:\text1\1.前端\assets\image-20231212111829897.png)



## 方法

### charAt()

> 返回指定位置的字符

```js
var str = 'hello';
var s = str.charAt(2);
console.log(s);
```

![image-20231212112206606](D:\text1\1.前端\assets\image-20231212112206606.png)



### indexOf()

> 检索字符串，返回子字符所在索引，不存在返回-1

```js
var str = 'hello';
// 子字符串返回第一个字符的索引
var num1 = str.indexOf('el');
var num2 = str.indexOf('le');
var num3 = str.indexOf('o');
console.log(num1);
console.log(num2);
console.log(num3);
```

![image-20231212114828629](D:\text1\1.前端\assets\image-20231212114828629.png)



### trim()

> 去除字符串左右两边的空格，不能取消去除中间的空格

```js
var str1 = ' hello';
var str2 = 'hello ';
var str3 = ' hello world js ';
console.log(str1.trim());
console.log(str2.trim());
console.log(str3.trim());
```

![image-20231212115504750](D:\text1\1.前端\assets\image-20231212115504750.png)



### substring()

> 截取子字符串，传入两个参数，第一个是起始索引，第二个是结束索引，<font color='red'>含头不含尾</font>

```js
var str = ' hello world js ';
var s = str.substring(1,9);
console.log(s);
```

![image-20231212115905613](D:\text1\1.前端\assets\image-20231212115905613.png)



# 自定义对象

> js中自定义对象格式：

```js
var 对象名 = {
    属性名1 : 属性值1,
    属性名2 : 属性值2,
    属性名3 : 属性值3,
    ...
    函数名称 : function(形参列表) {}
    ...
}
// 调用对象属性和函数
对象名.属性名;
对象名.函数名();
```

> 举例user对象

```js
var user = {
    name : 'tom',
    age : 20,
    gander : 'man',
    eat : function(e){
        console.log('正在吃'+e);
    },
    sleep : function(){
        console.log('正在睡觉...')
    }
}
var uName = user.name;
console.log(uName);
user.eat('苹果');
user.sleep();
```

![image-20231212162742708](D:\text1\1.前端\assets\image-20231212162742708.png)

> 对象中的函数可以简写，: function可以省略

```js
var user = {
    name : 'tom',
    age : 20,
    gander : 'man',
    eat(e) {
        console.log('正在吃'+e);
    },
    sleep() {
        console.log('正在睡觉...')
    }
}
var uName = user.name;
console.log(uName);
user.eat('香蕉');
user.sleep();
```

![image-20231212163106595](D:\text1\1.前端\assets\image-20231212163106595.png)



# JSON

> JSON的格式，与自定义对象类似，要求键值对的形式，键必须使用" "不使用或者使用' '不是正确的JSON格式

```js
{
    "name" : "tom",
    "age" : 20,
    "gander" : "man",
}
```

> 你可以直接声明一个json对象

```js
var user = {"name":'jim',"age":22,"gander":'woman'};
console.log(user.name);
console.log(user.age);
console.log(user.gander);
```

![image-20231212164512029](D:\text1\1.前端\assets\image-20231212164512029.png)

> 但是在实际的开发环境中，通常是将json对象以json字符串的形式在前后端进行传输，那么拿到json字符串后就没办法再像对象那样获取值，因此需要将json字符串解析为json对象，有解析自然能将json对象转换为json字符串

## 解析JSON.parse()

> JSON.parse()方法将json字符串解析为json对象

```js
var jsonStr = '{"name":"jerry","age":18,"addr":["北京","上海","西安"]}';
console.log(typeof jsonStr);
var jsbject = JSON.parse(jsonStr);
console.log(typeof jsbject);
console.log(jsbject.name);
console.log(jsbject.age);
console.log(jsbject.addr);
```

![image-20231212165544448](D:\text1\1.前端\assets\image-20231212165544448.png)

## JSON.stringify()

> JSON.stringify()能将JSON对象转换成json字符串

```js
var jsObject = {
	"username": "zs123",
	"passwd": "123456",
	"status": "admin"
}
var jStr = JSON.stringify(jsObject);
console.log(jStr);
```

![image-20231212171058324](D:\text1\1.前端\assets\image-20231212171058324.png)



# BOM对象

> BOM对象是浏览器对象模型，允许js与浏览器对话，js将浏览器的各个组成部分封装成对象

> BOM对象的组成主要有5个对象

> 1、Window对象，浏览器窗口对象，主要是将浏览器的窗口封装成了对象

> 2、Navigator对象，浏览器对象，主要封装浏览器的应用名称，浏览器的版本，浏览器的内核等信息

> 3、Screen对象，屏幕对象

> 4、History对象，历史对象，主要封装浏览器的历史记录

![image-20231212172027932](D:\text1\1.前端\assets\image-20231212172027932.png)

> 5、Location对象，地址栏对象，也就是url框

![image-20231212172225860](D:\text1\1.前端\assets\image-20231212172225860.png)

> 对应java后端，只需要了解Window和Location对象就够了

## window对象

> 直接写window.就能调用window对象的方法和属性，alert()就是window对象一个方法: window.alert("hello")，平时的写法是alert("hello")因为window是可以省略的

### 属性

> window对象的属性是直接获取其他BOM对象：
>
> - history属性，获取history对象
> - location属性，获取location对象
> - navigator属性，获取navigator对象
> - ......

### 方法

#### alert()

> alert()，弹窗警告框

#### confirm()

> 显示带有一段消息以及确认按钮和取消按钮的对话框

```js
confirm('这是一条消息');
```

![image-20231214093700109](D:\text1\1.前端\assets\image-20231214093700109.png)

> confirm()方法有返回值，点击确认返回true，点击取消返回false

```js
// 一般用在删除数据，根据返回值判断是否删除数据
var bool = confirm("确定删除这条记录吗?");
console.log(bool);
```

![动画 (1)](D:\text1\1.前端\assets\动画 (1).gif)

#### setInterval()

> 按照指定的周期(毫秒)来调用函数或计算表达式，周期性的调用函数或者计算表达式即<font color='red'>会执行很多次</font>，setInterval()接收两个参数，第一个是要执行的函数，第二个是周期

```js
// 以每1秒为周期执行函数
var i = 0;
setInterval(() => console.log('函数执行了'+(++i)+'次'),1000);
```

![动画 (1)](D:\text1\1.前端\assets\动画 (1)-1702602869120-1.gif)

> setInterval() 只能传递<font color='red'>一个</font>额外的参数给执行的函数

```js
var str = "定时器执行";
var i = 0;
// 将str参数传入执行函数
setInterval(s => console.log(s+(++i)+"次"),1000,str);
```

![动画 (1)](D:\text1\1.前端\assets\动画 (1)-1702621542143-7.gif)



#### setTimeout()

> 传入函数和指定时间，指定时间过后执行一次函数，注意setTimeout()只执行<font color='red'>一次</font>函数，而setInterval()执行<font color='red'>很多次</font>

```js
// 3秒后执行1次函数
setTimeout(() => console.log("延迟执行函数"),3000);
```

![动画 (1)](D:\text1\1.前端\assets\动画 (1)-1702603462949-3.gif)



## location对象

> 获取对象方法：window.location，window可以省略



### 属性

> 只需掌握一个：href，这个属性是<font color='red'>获取</font>和<font color='red'>设置</font>地址栏的url

```js
// 获取地址栏的url消息
console.log(location.href);
```

![image-20231215105559511](D:\text1\1.前端\assets\image-20231215105559511.png)

```js
// 先获取当前url，然后再改变url的值并跳转
alert(location.href);
location.href = 'http://www.bilibili.com';
```

![动画 (1)](D:\text1\1.前端\assets\动画 (1)-1702612824587-5.gif)



# DOM对象

> DOM对象组成分成：
>
> - Document：整个文档对象
> - Element：元素(标签)对象
> - Attribute：属性对象
> - Text：文本对象
> - Comment：注释对象

> 举例说明：

> 整个这个html文档(包括其下的所有标签，属性，文本，注释)都是Document对象

```html
<!-- Document对象 -->
<html>
	<head>
		<title>DOM</title>
	</head>
	<body>
		<h1>DOM对象</h1>
		<a href="http://www.baidu.com">
	</body>
</html>
```

> 标签(子标签)比如\<head>就是一个Element对象

```html
<head>
    <title>DOM</title>
</head>
```

> \<a>标签中有href属性，这就是属性对象

```html
href="http://www.baidu.com"
```

> 文本对象，也就是标签中的文本内容部分，这里\<h1>中的"DOM对象"文本内容就是文本对象

```html
<h1>DOM对象</h1>
```

![DOM](D:\text1\1.前端\assets\DOM.png)



## 获取元素对象

> 获取元素对象可以通过id、标签、name和class来获取

```html
<html>
	<head>
		<title>DOM</title>
	</head>
	<body>
		<div>
			<h1 id='bt'>DOM对象</h1>
		</div>
		<div>
			<a href="http://www.baidu.com">点击</a>
		</div>
		<input type="text" name="user" />
		<input type="text" name="pwd" />
        <img src="" alt="" class="img">
		<img src="" alt="" class="img">
	</body>
</html>
```



### byId

> getElementById()，通过id获取对象，获取的是<font color='red'>一个元素对象</font>

```js
var bt = document.getElementById("bt");
alert(bt);
```

![image-20231215154241212](D:\text1\1.前端\assets\image-20231215154241212.png)



### by标签

> getElementByTagName()，通过标签名获取元素，因为一个元素不止一个，所以获取的是<font color='red'>一个元素对象集合</font>

```js
var divs = document.getElementsByTagName("div");
alert(divs);
for(var i = 0;i<divs.length;i++){
	console.log(divs[i]);
}
```

![动画 (1)](D:\text1\1.前端\assets\动画 (1)-1702627422612-10.gif)



### byName

> getElementsByName()，通过元素name属性获取<font color='red'>一个元素对象集合</font>，

```js
var eles = document.getElementsByName("user");
alert(eles);
console.log(eles[0]);
```

![image-20231215161220377](D:\text1\1.前端\assets\image-20231215161220377.png)

![image-20231215161302690](D:\text1\1.前端\assets\image-20231215161302690.png)



### byClass

> getElementsByClass()，根据class获取<font color='red'>一个元素对象集合</font>

```js
var eles = document.getElementsByClass("img");
alert(eles);
console.log(eles[0]);
```

![image-20231215163459812](D:\text1\1.前端\assets\image-20231215163459812.png)

![image-20231215163813749](D:\text1\1.前端\assets\image-20231215163813749.png)

## 属性

> innerHTML，可以<font color='red'>获取</font>和<font color='red'>设置</font>元素的文本内容

```js
// 将h1的内容设置成"a标签"
var bt = document.getElementById("bt");
bt.innerHTML = 'a标签';
```

![image-20231215171544293](D:\text1\1.前端\assets\image-20231215171544293.png)

```js
// 获取h1的文本内容
var bt = document.getElementById("bt");
var text = bt.innerHTML;
console.log(text);
```

![image-20231215171647121](D:\text1\1.前端\assets\image-20231215171647121.png)

> innerHTML<font color='red'>会识别HTML标签</font>

```js
var bt = document.getElementById("bt");
bt.innerHTML = "<font color='red'>DOMObject</font>";
```

![image-20231215172503667](D:\text1\1.前端\assets\image-20231215172503667.png)