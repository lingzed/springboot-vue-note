# 函数声明1

> js是弱类型语言，所以在定义函数时不需要声明形参的数据类型，同时也不需要声明返回值的数据类型，如果有返回值直接return即可

```js
function add(a,b){
    return a + b;
}
// 调用函数直接函数名+参数
var result = add(10,20);
console.log(result);
```

![image-20231211164049244](D:\text1\1.前端\assets\image-20231211164049244.png)



# 声明方式2

> 函数的第二种声明方式：

```js
// 声明一个变量，变量值是一个函数
var add = function(a,b){
    return a + b;
}
console.log(add(1,3));
```

![image-20231211164309601](D:\text1\1.前端\assets\image-20231211164309601.png)



# 调用时的形参列表

> js中函数调用时的形参可以超出函数声明时定义的形参数量，超出之前的参数依然作为函数的形参，超出之后不作为函数的形参，这样形式调用，函数依然会执行

```js
function add(a,b){
    return a + b;
}
// 调用时传入4个参数
var result = add(1,2,3,4);
// 函数依然执行
console.log(result);
```

![image-20231211164759537](D:\text1\1.前端\assets\image-20231211164759537.png)