# 字符串转换成数字

> parseInt()（读作pers int），会将字符串的字面值转换成数字，如果字面值不是数字，则转换成NaN

```JS
console.log(parseInt('12'));
console.log(parseInt('12A45'));
console.log(parseInt('A45'));
```

![image-20231208154733784](D:\text1\前端\assets\image-20231208154733784.png)

> parseInt()会从第一个字符开始匹配，如果此时匹配到一个字符串，那么就会结束匹配，这就是为什么'12A45'解析出来的值是12，如果第一个字符就是字符串那么解析值为NaN



# 其他类型转换为boolean

> - 0和NaN转换为false，其他数字为true
> - 空字符串转换为false，其他字符串为true
> - Null和undefined都是false

```js
if(0){
	console.log('0转换为fales');
}
if(NaN){
	console.log('NaN转换为fales');
}
if(-1){
	console.log('-1转换为true');
}
```

> 结果只输出'-1转换为true'

![image-20231208155936159](D:\text1\前端\assets\image-20231208155936159.png)

```js
if(!0){
	console.log('0转换为fales');
}
if(!NaN){
	console.log('NaN转换为fales');
}
if(-1){
	console.log('-1转换为true');
}
```

![image-20231208160009928](D:\text1\前端\assets\image-20231208160009928.png)

```js
if(''){
	console.log("''转换为fales");
}
if('hello'){
	console.log("'hello'NaN转换为true");
}
```

![image-20231208160150415](D:\text1\前端\assets\image-20231208160150415.png)

> ''是false，但是' '空格不是false

```js
if(' '){
	console.log("' '转换为true");
}
```

![image-20231208160655596](D:\text1\前端\assets\image-20231208160655596.png)

```js
if(!null){
	console.log("null转换为fales");
}
if(!undefined){
	console.log("undefined转换为fales");
}
```

![image-20231208160326722](D:\text1\前端\assets\image-20231208160326722.png)