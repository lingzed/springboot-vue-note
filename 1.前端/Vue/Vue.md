# MVVM模型

> Vue使用MVVM的模型，M指Model(模型)，V指View(视图)，VM指ViewModel(视图模型)，Vue使用这套模型实现双向绑定，无论改变那一边的数据另一边的数据都能改变

![image-20231218115204221](E:\text1\1.1.前端\Vue\assets\image-20231218115204221.png)



# Vue2资源引入

```html
<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
```



# 创建Vue核心对象

> 创建Vue对象，传入一个对象作为参数，这个对象必须要有el属性，表示由Vue对象控制的DOM元素，类似于js的选择器，定义数据模型，data，它是一个对象data中给定数据

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body>
	<div id="app">
		<!-- v-model是双向绑定，绑定了数据模型中的数据就会展示在该input中 -->
		<input type="text" v-model="msg">
		<!-- 插值表达式{{}} 能将数据模型中的数据展示在页面 -->
		{{ msg }}
	</div>
</body>
<script>
new Vue({
	// Vue控制的元素，#根据id选择
	el: "#app",
	// 数据模型，是一个对象，给定数据
	data: {
		msg: "hello world"
	}
})
</script>
</html>
```

![动画 (1)](E:\text1\1.1.前端\Vue\assets\动画 (1).gif)

> 这里容易出现理解错误，就是将{{}}和input框理解为双向绑定，事实上input是跟数据模型中的msg属性进行的绑定，而{{}}是获取msg的值，由于input和msg进行了双绑，那么改变input的值msg的值就会跟着改变，{{}}再去获取msg的值就是改变之后的，呈现出的效果就是input的值改变，{{}}也跟着变，好像是{{}}和input之间绑定，实际上不是并非如此，反过来改变msg的值也是一样的道理，实现的逻辑是这样的：

![image-20231218141914211](E:\text1\1.1.前端\Vue\assets\image-20231218141914211.png)



# {{ }}表达式

> 插值表达式，用于展示数据：{{ 表达式 }}
>
> - 内容可以是	
>   - 变量
>   - 三元运算符
>   - 函数调用
>   - 算术运算



# Vue常用指令

> 在HTML上使用的带有v-前缀的特殊属性都是Vue中的指令

|   指令    |                       作用                        |
| :-------: | :-----------------------------------------------: |
|  v-bind   |    为HTML标签绑定属性值，如设置href，css样式等    |
|  v-model  |           在表单元素上创建双向绑定数据            |
|   v-on    |                为HTML标签绑定事件                 |
|   v-if    |   条件性控制某元素渲染，true渲染，false不渲染 ①   |
| v-else-if |                        同①                        |
|  v-else   |                        同①                        |
|  v-show   | 根据条件展示某元素，修改display值来显示或隐藏元素 |
|   v-for   |      列表渲染，遍历容器的元素或者对象的属性       |

## v-bind

> v-bind为HTML标签绑定属性值

```html
<!-- 绑定标签属性 -->
<a v-bind:href='/path/to/url'>点击</a>
<!-- v-bind可以省略 -->
<a :href='/path/to/url'>点击</a>
```

> 为标签属性绑定数据模型，可以实现动态绑定数据
>
> **v-bind:标签属性名="数据模型属性名"**
>
> **:标签属性名="数据模型属性名"**

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body>
	<div id="app">
        <!-- 属性href绑定数据模型url，当url发生改变，href也会跟着改变 -->
		<a v-bind:href="url">点击</a>
        <!-- <a :href="url">点击</a> -->
	</div>
</body>
<script>
new Vue({
	el: "#app",
	data: {
		url: "http://www.baidu.com"
	}
})
</script>
</html>
```

![image-20231218155033767](E:\text1\1.前端\Vue\assets\image-20231218155033767.png)



## v-model

> 在表单元素上创建双向绑定数据，与数据模型双向绑定，双向改变
>
> **v-model="数据模型属性名"**

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body v-on=''>
	<div id="app">
		<input type="text" v-model="url">
		<a :href="url">连接1</a>
	</div>
</body>
<script>
new Vue({
	el: "#app",
	data: {
		url: "hello world"
	}
})
</script>
</html>
```

![动画 (1)](E:\text1\1.前端\Vue\assets\动画 (1)-1702887194974-3.gif)

> 注意：<font color='yellow'>通过v-bind和v-model绑定的变量，必须在数据模型中声明</font>



## v-on

> 为HTML标签绑定事件
>
> 格式：**v-on:绑定的事件="事件函数"**
>
> 一旦绑定的事件触发就会执行事件函数，事件函数需要定义在methods属性中，methods是一个对象
>
> 简写：**@绑定的事件 = "事件函数"**

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body v-on=''>
	<div id="app">
        <!-- 事件绑定方式1 -->
		<button v-on:click="handle()">按钮1</button>
		<!-- 事件绑定方式2 -->
		<button @click="handle()">按钮2</button>
	</div>
	
</body>
<script>
new Vue({
	el: "#app",
	methods: {
        // 事件触发执行该handle函数
		handle: () => console.log("hello world")
	}
})
</script>
</html>
```

![动画 (1)](E:\text1\1.前端\Vue\assets\动画 (1)-1702890836722-5.gif)



## v-if-else-if-else

> **v-if = "数据模型属性名 条件"**，
>
> **v-else-if = "数据模型属性名 条件"**，
>
> **v-else**，
>
> 满足条件的元素才会渲染，不满足则不会渲染

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body v-on=''>
	<div id="app">
		<p>
		年龄为{{age}}，判断为<span v-if="age < 40">年轻人</span>
		<span v-else-if="age >= 40 & age < 60">中年人</span>
		<span v-else>老年人</span>
		</p>
	</div>
</body>
<script>
new Vue({
	el: "#app",
	data: {
		age: 20
	},
})
</script>
</html>
```

![image-20231219095957990](E:\text1\1.前端\Vue\assets\image-20231219095957990.png)

![image-20231219100101704](E:\text1\1.前端\Vue\assets\image-20231219100101704.png)

![image-20231219100134191](E:\text1\1.前端\Vue\assets\image-20231219100134191.png)

> 需要提一点，v-if，v-else-if，v-else都是满足条件才渲染，不满足就不渲染，也就是不满足的在html中是不存在的，并不是存在但是被隐藏



## v-show

> **v-show="数据模型属性名 条件"**，满足条件显示元素，不满足隐藏

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body v-on=''>
	<div id="app">
		<p>
		年龄为{{age}}，判断为<span v-show="age < 40">年轻人</span>
		<span v-show="age >= 40 & age < 60">中年人</span>
		<span v-show="age >= 60">老年人</span>
		</p>
	</div>
	
</body>
<script>
new Vue({
	el: "#app",
	data: {
		age: 60
	}
})
</script>
</html>
```

![image-20231219100539101](E:\text1\1.前端\Vue\assets\image-20231219100539101.png)

> 与v-if-else-if-else不同，v-show不满足是隐藏元素，也就是将display设置为none，即元素会存在html中，而v-if不满足直接不渲染元素，即在html中不存在

> v-show

![image-20231219100736873](E:\text1\1.前端\Vue\assets\image-20231219100736873.png)

> v-if-else-if-else

![image-20231219100801586](E:\text1\1.前端\Vue\assets\image-20231219100801586.png)



## v-for

> **v-for="item in items"**，item是被遍历出来的数据，items是被遍历的数组或者对象，item可以被{{}}展示在页面
>
> 如果需要展示索引，那么格式为
>
> **v-for="(item,index) in items"**，index就是索引，{{index}}将索引展示在页面

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body v-on=''>
	<div id="app">
        <li v-for="addr in addrs">{{addr}}</li>
        <li v-for="v in set">{{v}}</li>
        <br>
        <li v-for="(addr,index) in addrs">{{index+1}}{{addr}}</li>
		<li v-for="(v,k) in set">{{k}}:{{v}}</li>
	</div>
	
</body>
<script>
new Vue({
	el: "#app",
	data: {
		addrs: ["北京","上海","天津","南京","四川","重庆"],
		set: {name:"tom",age:20,gander:"man"}
	},
	methods: {
		handle: () => console.log("hello world")
	}
})
</script>
</html>
```

![image-20231219103251187](E:\text1\1.前端\Vue\assets\image-20231219103251187.png)

> 对于对象，同样能够遍历，遍历集合的键同索引一致，(v,k)，v是值，k是键，与遍历索引的格式类似，第一个参数是遍历出来的值，第二个参数是值的索引或者键

> 这里是一个实例，一个对象数组数据为：

```js
[
    {id: 1, name: "tom", age: 20, gander: "man"},
    {id: 2, name: "lilei", age: 22, gander: "woman"},
]
```

> 然后循环遍历这个数组，我在这里定义了一个:Lid="obj.id"，这其实是v-bind:Lid="obj.id"的简写，将Lid属性跟循环中的obj.id绑定在一起，这样就能获取每个对象的id值，**即v-bind可以绑定v-for中的循环出来的元素**，这样做是为了让每个被循环出来的元素有唯一标识

```html
<li v-for="obj in objArray" :Lid="obj.id">{{obj}}</li>
```

![image-20231219110815477](E:\text1\1.前端\Vue\assets\image-20231219110815477.png)

![image-20231219110838425](E:\text1\1.前端\Vue\assets\image-20231219110838425.png)

> 后端与1.前端数据交互一般采用JSON数据，js的对象与JSON相似，v-for也能遍历JSON数据
>
> 这里我们用一个json数据来模拟后端与1.前端的数据交互，对于多个对象数据在后端中一般定义一个列表，然后将查询的数据添加到列表中，并将列表解析成json字符串然后响应给1.前端

```html
<!DOCTYPE html>
<html>
<head>
	<title>VueDemo</title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
</head>
<body v-on=''>
	<div id="app">
		<table border="1" cellspacing="0" width="800px">
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>价格</th>
			</tr>
			<tr v-for="book in bookJSON" :bookID="book.id" style="text-align: center;">
				<td>{{ book.id }}</td>
				<td>{{ book.bookName }}</td>
				<td>{{ book.price }}</td>
			</tr>
		</table>
	</div>
	
</body>
<script>
var jsonStr = '['+
		'{"id": "001", "bookName": "java开发", "price": 45.0},'+
		'{"id": "002", "bookName": "python开发", "price": 50.0},'+
		'{"id": "003", "bookName": "c++开发", "price": 32.0},'+
		'{"id": "004", "bookName": "计算机科学与技术", "price": 60.0}'+
']';
var josnData = JSON.parse(jsonStr);
new Vue({
	el: "#app",
	data: {
		// Vue的数据模型可以直接接收json数据
		bookJSON: josnData
	},
})
</script>
</html>
```

![image-20231219171821397](E:\text1\1.前端\Vue\assets\image-20231219171821397.png)



# Vue的生命周期

![0cdc4eae375b40e9bcacdc4c29f07187](E:\text1\1.前端\Vue\assets\0cdc4eae375b40e9bcacdc4c29f07187.png)

> Vue的生命周期，从创建到销毁有8个阶段，**每触发一个生命周期的阶段，都会自动执行一个生命周期方法(这个方法称为钩子方法)**

|               钩子               |                          阶段                          |
| :------------------------------: | :----------------------------------------------------: |
|          beforeCreate()          |                 在Vue对象创建之前触发                  |
|            Created()             |                 在Vue对象创建之后触发                  |
|           beforeMount            |             在Vue挂载到指定的元素之前触发              |
| <font color='red'>Mounted</font> | <font color='red'>在Vue挂载到指定的元素之后触发</font> |
|           beforeUpdate           |                在数据模型数据变化前触发                |
|             updated              |       数据模型数据变化后，且展示在元素上之后触发       |
|          beforeDestroy           |                  在Vue对象销毁前触发                   |
|            Destroyed             |                  在Vue对象销毁后触发                   |

> 这其中，Mounted()是后端开发需要重点掌握的，由于其在Vue挂载到数据之后触发，因此可以在这个钩子中执行如开启定时器、发送网络请求、订阅消息、绑定自定义事件等初始化操作，此处的挂载是指，当定义了一个vue对象后使用el属性管理DOM元素，会将vue实例挂载到该元素上，即当创建了一个vue对象并使用el属性接管目标元素后会自动调用mounted()方法