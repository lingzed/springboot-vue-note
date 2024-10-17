# string

> String类型是二进制安全的，即redis的String可以包含任何数据，如图片，序列化的对象等，一个redis中字符串value最多可以是512M.



# 存储方式

![image-20230919193211882](C:\Users\asus\Desktop\text1\reids\assets\image-20230919193211882.png)

> JSON保存:
>
> set user "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}"
>
> 在redis中双引号通常用于界定字符串，包括JSON字符串。在这种情况下，为了将整个JSON字符串传递给set命令，需要对内部的双引号进行转义，以确保它们被正确解析为字符串。



# 存储/获取

> 保存数据，相当于MySQL中的insert  into语句。
>
> set  key   value
>
> 获取数据，相当于MySQL中的select语句。
>
> get key
>
> 多获取
>
> mget key

```shell
set  hello  world123
get  hello
# 获取hello的haha的值
mget hello haha
```

![image-20230919193858617](C:\Users\asus\Desktop\text1\reids\assets\image-20230919193858617.png) 



# 修改

> 修改String数据，相当于MySQL中的update。
>
> 修改key的整个值
>
> set key 新value
>
> 修改指定索引值
>
> setrange  key   index  value

```shell
#表示修改key是hello的value值中下标为1处的字符为a
setrange  hello  1  a  
```

![image-20230919200553913](C:\Users\asus\Desktop\text1\reids\assets\image-20230919200553913.png) 



# 删除

> 删除数据，相当于MySQL中的delete语句。
>
> del  keys   一次可以删除一个或多个。

```shell
del hello
```

![image-20230919194200240](C:\Users\asus\Desktop\text1\reids\assets\image-20230919194200240.png) 



# 查看所有key

> 查看所有key
>
> keys  *  

```shell
keys  *
```



# 获取范围内的值

> 获取指定范围的字符串值
>
> getrange  key  start  end
>
> start 开始,end结束,左右闭合区间

```shell
getrange  hello  1  3
```

![image-20230919201015530](C:\Users\asus\Desktop\text1\reids\assets\image-20230919201015530.png) 



# 获取多个key的值

> 一次获取多个key的值
>
> mget  key1  key2   key3...

```shell
mget  hello  haha  hehe
```

![image-20230919201125485](C:\Users\asus\Desktop\text1\reids\assets\image-20230919201125485.png) 



# 设置多个key的值

> 一次设置多个key的值:
>
> mset  key1  value1   key2   value2  ......  keyN  valueN

```shell
mset  tx  tx_weixin  ali  ali_dd  huawei  hw_mate60
```

![image-20230919201212203](C:\Users\asus\Desktop\text1\reids\assets\image-20230919201212203.png) 



# 自增自减

> 自增: incr
>
> 自减: decr
>
> 自增、自减value要是数值类型，如果自增或自减一个不存在的key那么redis会将key的值初始化为0，自增后为1，自减后为-1。这样处理后该key就存在了.

```shell
#对hellonum这个key的值自增1
incr  hellonum  
#对hellonum这个key的值自减1
decr  hellonum  
```

![image-20230919201819110](C:\Users\asus\Desktop\text1\reids\assets\image-20230919201819110.png) 



# 递增/递减指定长度

## 指定整数

> 递增指定的整数长度:
>
> incrby   key  value
>
> 递减指定的整数长度:
>
> decrby  key  value

```shell
#对hellonum这个key的值递增3,即值加3
incrby  hellonum  3 
#对hellonum这个key的值递减3,即值减3
decrby  hellonum  3 
```

![image-20230919202049142](C:\Users\asus\Desktop\text1\reids\assets\image-20230919202049142.png) 



## 指定浮点数

>递增指定的浮点长度:
>
>incrbyfloat   key  value
>
>递减指定的浮点长度(<font  color=blue>递减时给的是负数</font>):
>
>incrbyfloat   key   -value

```shell
#对hellonum这个key的值递增3.6,即在hellonum这个key的值的基础上加3.6
incrbyfloat  hellonum  3.6 
 #对hellonum这个key的值递减-1.1,即在hellonum这个key的值的基础上减1.1
incrbyfloat  hellonum  -1.1
```

![image-20230919202217577](C:\Users\asus\Desktop\text1\reids\assets\image-20230919202217577.png) 



# 追加字符串

> 追加字符串:
>
> append  key   value

```shell
#在hello的value基础上追加一个redis字符串。
append  hello   redis
```

![image-20230919202312856](C:\Users\asus\Desktop\text1\reids\assets\image-20230919202312856.png) 



# 获取字符串长度

> 获取指定key的value字符串的长度:
>
> strlen  key

```shell
#获取hello这个key对应value字符串的长度
strlen hello  
```

![image-20230919202535578](C:\Users\asus\Desktop\text1\reids\assets\image-20230919202535578.png) 



# 模糊查询

> *表示匹配任意位数的字符，也就是>=0
>
> ?表示匹配1位数的字符
>
> keys h*  表示查询以h开头的所有的key
>
> keys h?  表示查询以h开头的两位字符串的key
>
> keys h[a-c]*表示查询以h开头第二位是a到c之间的字符，[a,c]为闭区间，并且不知道总共有多少为字符串
>
> keys h[a-c]?表示查询以h开头第二位是a到c之间的字符，[a,c]为闭区间，并且总共3位字符串，第3位字符串不知道

![redis](C:\Users\asus\Desktop\text1\reids\assets\redis.gif)



# 当前数据库的key数量

> 查看当前数据库总共有多少个key,不包括所有的数据库，默认情况下当前数据库下标为0
>
> dbsize

```shell
dbsize
```



# 切换数据库

> 切换其他数据库:
>
> select  index
>
> 默认情况下数据库有16个。

```shell
#切换到数据库6中
select 6 
```



# 查询key是否存在

> 查询指定的key是否存在，如果存在返回存在的个数，否则返回0
>
> exists  key1 ...  keyN

```shell
#查询hello这个key是否存在。
exists  hello  
#查询hello、haha、hehe这3个key是否存在，如果都存在返回3
exists  hello  haha   hehe  
```

![image-20230919203124190](C:\Users\asus\Desktop\text1\reids\assets\image-20230919203124190.png) 

# 设置并查看key是否存在

> 设置并查看指定key是否存在，如果不存在就进行设置/保存,否则不进行设置/保存，并返回0.
>
> setnx  key   value

```shell
#表示查看hello这个key是否存在,如果存在，不进行设置，返回0，如果不存在，则就将worldredis7保存到数据库
setnx  hello  worldredis7 
```

![image-20230919203235614](C:\Users\asus\Desktop\text1\reids\assets\image-20230919203235614.png) 



# 设置key有效时间

> 设置指定key的有效时间，即key的过期时间,并指定新的值，以秒为单位，如果key，不存在则返回nil,nil表示空的意思。
>
> setex  key   time    newvalue
>
> 假设hello的值是world
>
> setex hello 10 123表示10s内,hello有效且原world被更新为123,10s后hello失效

```shell
#表示设置hello这个key的过期时间是20秒,新的值是newredis7，20秒后hello这个key就过期了，此时再次查询就是nil
setex  hello  20  newredis7 
```

![image-20230916140046829](C:\Users\asus\Desktop\text1\reids\assets\image-20230916140046829.png)



# 查询key有效时长

> 查看某个key还剩多长时间过期:
>
> ttl   key
>
> -1表示没有过期时间(永不过期)，-2表示不存在的key，其他正整数返回的就是剩余过期时间，以秒为单位。

```shell
#表示查看hello这个key的过期时间.
ttl  hello  
```

![image-20230916140427481](C:\Users\asus\Desktop\text1\reids\assets\image-20230916140427481.png)



# 取消key过期时间

> 取消key的过期时间：
>
> persist   key
>
> 取消后，就是永不过期。

```shell
#将hello这个key的过期时间取消
persist  hello  
```

![image-20230916141648608](C:\Users\asus\Desktop\text1\reids\assets\image-20230916141648608.png)



# 查看key数据类型

> 查看key的数据类型:
>
> type  key
>
> type的返回值：string、set、zset(有序set)、hash、list、none(表示 不存在的key)

```shell
#表示查看hello这个key的数据类型
type  hello 
```

![image-20230916142111014](C:\Users\asus\Desktop\text1\reids\assets\image-20230916142111014.png)



# 获取旧同时设置新

> 获取旧数据的同时设置一个新数据:
>
> getset  key   newvalue

```shell
#表示查看hello这个key的旧数据的同时设置一个新数据为newredis
getset  hello  newredis 
```

![image-20230916142326899](C:\Users\asus\Desktop\text1\reids\assets\image-20230916142326899.png)



# 不存在时设置键值对

> set  key  value  nx
>
> nx表示key不存在的时候设置键值对，键存在的时候什么都不做，返回nil.

```shell
#表示如果hello不存在,则设置这个hello键,如果存在则返回nil,由于hello已经存在,则返回了nil
set  hello  hello_value  nx 
```

![image-20230916142742168](C:\Users\asus\Desktop\text1\reids\assets\image-20230916142742168.png)

# 存在时设置键值对

> set  key   value  xx
>
> xx表示key存在的时候设置键值对,会将前面的覆盖掉，键不存在的时候什么也不做，返回nil

```shell
#表示hello36这个key如果存在则会使用newvalue将前面的值覆盖掉，如果不存在，则什么也不做，返回nil
set hello36  newvalue  xx 
```

![image-20230916144517268](C:\Users\asus\Desktop\text1\reids\assets\image-20230916144517268.png)



# 获取旧设置新

> set  key   newvalue  get
>
> get表示先获取原来的老值，在将新值newvalue设置进去，即覆盖原来的老值，如果key不存在，也会保存，但是返回一个nil

```shell
#表示获取hello36的老值,并将新值保存进去，如果hello36不存在，也会保存,但是返回nil
set  hello36  redisnew  get 
```

![image-20230916145111406](C:\Users\asus\Desktop\text1\reids\assets\image-20230916145111406.png)



# 设置值指定过期时间(秒)

> set  key  value  ex  time
>
> ex表示多少秒以后过期，即过期时间,此处的key可以不存在，也可以存在。

```shell
#表示将hello63的值设置为newvalue,并指定过期时间为20秒
set  hello63 newvalue ex  20 
```

![image-20230916145753945](C:\Users\asus\Desktop\text1\reids\assets\image-20230916145753945.png)

> set   key    value   ex   time
>
> set   key   value 
>
> 再次设置并且不指定过期时间，此时会清除过期时间。

```shell
#表示保存一个hello键,并设置30秒以后过期
set  hello  helloworld  ex  30 
#再次设置hello,不指定过期时间,此时会清除过期时间，即永不过期
set  hello  newhelloworld   
```

![image-20230919210106218](C:\Users\asus\Desktop\text1\reids\assets\image-20230919210106218.png) 



# 设置值指定过期时间(毫秒)

> set  key  value  px  time
>
> px表示多少毫秒以后过期，即过期时间，此处同样，key可以存在，也可以不存在。

```shell
#表示hello63这个key100毫秒后过期
set hello63  hello123  px  100
```

![image-20230916150314928](C:\Users\asus\Desktop\text1\reids\assets\image-20230916150314928.png)



# 设置新值为旧值过期时间

> keepttl  保持原来过期时间
>
> set  key   value  ex   time
>
> set  key   value  keepttl
>
> keepttl表示会继续保持原来的过期时间。

```shell
#表示设置hello123键过期时间30秒
set  hello123  helloworld123   ex  30 
#表示设置hello123键的新值为world123,并保持原来30秒的过期时间
set  hello123  world123  keepttl  
```

![image-20230916154148855](C:\Users\asus\Desktop\text1\reids\assets\image-20230916154148855.png)



# 设置都成功or都失败

> msetnx   key1   value1   ...  keyN   valueN
>
> 表示事务处理，要么都成功，要么都失败；如果其中一个key存在，另一个key不存在，会造成都失败，如果设置的key都不存在，则都会成功，如果都存在，则都不成功。

```shell
#由于此时hello123和hello321都不存在，此时就会设置保存成功。
msetnx  hello123  world123  hello321  world321 
#由于此时hello123和hello321都存在，此时都失败
msetnx  hello123  w123  hello321  w321 
#由于此时hello123存在，hello111不存在,因此都失败。
msetnx  hello123  w123  hello111  w111 
```

> 例如:

```shell
127.0.0.1:6379> keys *
 1) "xixi"
 2) "haha"
 3) "hello"
 4) "hello36"
 5) "cdsx"
 6) "ali"
 7) "hello7"
 8) "hellonum"
 9) "cdgt"
10) "hih"
11) "hehe"
12) "huawei"
13) "hi"
14) "tx"
127.0.0.1:6379> msetnx hello123 world123 hello321  world321
(integer) 1
127.0.0.1:6379> keys *
 1) "xixi"
 2) "hello123"
 3) "haha"
 4) "hello321"
 5) "hello"
 6) "hello36"
 7) "cdsx"
 8) "ali"
 9) "hello7"
10) "hellonum"
11) "cdgt"
12) "hih"
13) "hehe"
14) "huawei"
15) "hi"
16) "tx"
127.0.0.1:6379> mget hello123 hello321
1) "world123"
2) "world321"
127.0.0.1:6379> msetnx hello123 w123  hello321 w321
(integer) 0
127.0.0.1:6379> mget hello123 hello321
1) "world123"
2) "world321"
127.0.0.1:6379> ttl hello123
(integer) -1
127.0.0.1:6379> msetnx hello123  w123  hello111  w111
(integer) 0
127.0.0.1:6379> keys *
 1) "xixi"
 2) "hello123"
 3) "haha"
 4) "hello321"
 5) "hello"
 6) "hello36"
 7) "cdsx"
 8) "ali"
 9) "hello7"
10) "hellonum"
11) "cdgt"
12) "hih"
13) "hehe"
14) "huawei"
15) "hi"
16) "tx"
127.0.0.1:6379>
```

