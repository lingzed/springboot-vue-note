# 进入docker中redis

## 启动redis容器

```she
docker start redis容器名称
```



## 进入redis容器

```shell
docker exec -it redis容器名称 bash
```



## 进入redis

```shell
#进入redis数据库
redis-cli 
#解决redis中的中文乱码问题，即中文正常显示。
redis-cli  --raw 
```



# redis数据类型

> redis数据类型，基本数据类型有五种，还有五种是复杂的数据类型，总共是有10种数据类型,分别是:
>
> strings,List,set,zset,hash,geo,stream,bitmap,bitfields,pro。



# redis命令注意点

> redis的命令不区分大小写,但是key是区分大小写的
>
> help @类型  可以查询指定类型的帮助信息。