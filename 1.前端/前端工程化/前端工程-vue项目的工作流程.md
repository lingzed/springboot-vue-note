# 导入导出

> import：导入模块
>
> export：将<font color='red'>对象</font>或者<font color='red'>函数</font>导出为模块
>
> 可以将export导出一个模块，在需要使用的地方导入该模块



# index.html

> 首先介绍的是index.html文件，这个文件在项目的public目录下，这个页面是整个前端项目的页面，内部定义了一个div容器，通过vue渲染的最终的虚拟DOM会通过main.js渲染在该div中，可以说整个前端项目都只有这一个页面，只不过是通过不同的路由将不同的DOM渲染在这个页面上，呈现的效果就像是不同的页面



# main.js

> 入口js文件，将根组件挂载到index.html中去，在index.html中默认引入了main.js

![image-20240106201949791](E:\text1\1.前端\前端工程化\assets\image-20240106201949791.png)



# App.vue

> 根组件，内部定义路由，根组件是所有组件的父组件，配合路由控制着整个项目的结构和逻辑

![image-20240106202636150](E:\text1\1.前端\前端工程化\assets\image-20240106202636150.png)



# router

> 路由，内部导入其他组件，并定义这些组件的url，建立组件与路由的映射关系，这样通过url就能访问这些组件

![image-20240106203510909](E:\text1\1.前端\前端工程化\assets\image-20240106203510909.png)

> router中还可以定义重定向属性redirect，用于将路径重定向到指定的组件

```js
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  ...
  // 设置路由的重定义
  ,{
    // 当访问这个路径时
    path: '/abouts',
    // 重定义到staffInfo这个路径
    redirect: '/staffInfo'
  }
]
```



# compoenet

> 组件是.Vue的一个文件，内部定义template根标签，这个标签中写html，style根标签，这个标签中写css，控制整个组件的样式，script根标签中写js，控制整个组件的行为



# 案例

> 接下用一个案例说明：
> 假设一个员工系统有若干功能，其中一个功能是员工列表的crud，那么我们就可以定义一个staffInfo的组件和路由，首先在views目录中创建一个staffInfo.vue

```html
<template>
	<div class='mb10'>
		<button class='btn btn-primary mr10'>增 加</button>
		<button class='btn btn-primary mr10'>删 除</button>
		<button class='btn btn-primary mr10'>修 改</button>
		<button class='btn btn-primary mr10'>批量删除</button>
	</div>
	<table border='1' width="80%">
		<tr>
			<th>#</th>
			<th>id</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</tr>
		<tr v-for='(staff,i) in staffs' :key='staff.id'>
			<td>{{ ++i }}</td>
			<td>{{ staff.id }}</td>
			<td>{{ staff.name }}</td>
			<td>{{ staff.age }}</td>
			<td>{{ staff.gander == 1 ? '男' : '女' }}</td>
		</tr>
	</table>
</template>

<script>
	export default {
		name: 'asAbc',
		data() {
			return {
				staffs: [
					{
						"id": "001",
						"name": "tom",
						"age": 20,
						"gander": 1,
					},
					{
						"id": "002",
						"name": "jim",
						"age": 22,
						"gander": 1,
					},
					{
						"id": "003",
						"name": "hanmeimei",
						"age": 19,
						"gander": 2,
					},
					{
						"id": "004",
						"name": "lilei",
						"age": 23,
						"gander": 1,
					}
				]
			}
		}
	}
</script>

<style>
	.btn {
		padding: 2px 5px;
	}
	.btn-primary {
		background-color: blue;
		color: white;
	}
	.mb10 {
		margin: 0 0 10px
	}
	.mr10 {
		margin-right: 10px
	}
</style>
```

> 这里简单定义了一个职员列表，使用v-for循环数据模型中的数据，与原来的数据模型定义不同，这里是定义data函数，函数返回一个对象，对象中定义数据模型，原来是的方式是直接是data对象，然后在对象中定义数据模型

```js
// 原来定义数据模型的方式
new Vue({
    data: {
        staffs: [...]
    }
})
```

> 导出组件的格式：

```js
export default {
	name: '组件名',
	data() {
        return {
            // 数据模型
        }
	},
    methods: {
		// 定义函数
    },
    ...
}
```

> 然后，在路由中映射该组

```js
...
// 注意这里导入的模块名字可以不跟组件名相同
import aaa from '../views/staffInfo.vue'

const routes = [
  ...
  {
    // 映射路由与组件
    path: "/staffInfo",
    name: "staffInfo",
    component: aaa
  },
  {

  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

```

> 这样在App.vue的路由标签中就可以创建这个组件的路由

```html
<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/myComponent">点这里</router-link> |
    <!--  创建组件的路由 -->
    <router-link to="/staffInfo">员工信息</router-link>
  </nav>
  <router-view/>
</template>
```

> 结果：

![动画 (1)](E:\text1\1.前端\前端工程化\assets\动画 (1).gif)

> 如果我要使用这个组件的标签，那么先导入该组件，然后在components中定义,以HomeView组件为例，我要在这个组件中使用staffInfo.vue

```html
<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <myComponent></myComponent>
	<!-- 像标签一样使用 -->
    <si> </si>
  </div>
</template>

<script>
// @ is an alias to /src
// 引入组件
import si from './staffInfo.vue'

export default {
  name: 'HomeView',
  // 其他导出的组件引入后怎么在template中使用该组件元素？可以在components属性中定义引入的组件
  components: {
    // 属性名和属性值一致，可以只写一个 
    si
  }
}
</script>

```

> 那么当我访问HomeView组件的时候，也会看到staffInfo组件

![动画 (1)](E:\text1\1.前端\前端工程化\assets\动画 (1)-1704552284126-2.gif)

> 项目的流程结构如下：

![image-20240106224428256](E:\text1\1.前端\前端工程化\assets\image-20240106224428256.png)

