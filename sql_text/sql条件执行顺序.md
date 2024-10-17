sql中，条件的执行顺序是not > and > or

一段sql语句：

```mysql
select field from table where a = 1 and b = 2 or c = 3;
```

其结果为：查询a = 1并且b = 2的数据，或者查询c = 3的数据。

通过()来改变逻辑运算的优先级：

```mysql
select field from table where a = 1 and (b = 2 or c = 3);
```

其结果为：查询a = 1并且 (b = 2或c = 3) 的数据。