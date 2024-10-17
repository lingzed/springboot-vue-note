# 官网下载安装包

```shell
https://download.redis.io/releases/?_gl=1*1rddups*_ga*MjQzMDA5MDUzLjE2OTQ1MDY0NjM.*_ga_8BKGRQKRPV*MTcwMTM5MzY5NC4zLjEuMTcwMTM5NDUxNC41OS4wLjA.*_gcl_au*MTg5NTI2NTQ5My4xNjk0NTA2NDYz
```

> 选择版本

![image-20231201094935930](D:\text1\linux\assets\image-20231201094935930.png)



# 解压

> winSCP上传到/usr/local/redis目录下，解压

```shell
# -C指定目录
tar -zvxf redis-6.0.5.tar.gz -C /usr/local/redis
```



# 编译

> redis是由c编写的，需要安装gcc，然后编译，如果编译失败是因为gcc版本过低导致的，请升级gcc版本

```shell
# 安装gcc
yum install gcc-c++
# 编译,编译前先进入redis-6.0.5目录
make
```

> gcc版本升级

```shell
# 查看gcc版本
gcc -v
# 升级到9.1
yum -y install centos-release-scl
yum -y install devtoolset-9-gcc devtoolset-9-gcc-c++ devtoolset-9-binutils
scl enable devtoolset-9 bash
# 以上为临时启用，如果要长期使用gcc 9.1的话：
echo "source /opt/rh/devtoolset-9/enable" >>/etc/profile
```



# 安装

```shell
make install
```

![image-20231201095557934](D:\text1\linux\assets\image-20231201095557934.png)



# 备份redis.conf文件

```shell
cp redis.conf redis.conf.blank
```



# 启动redis客户端

```shell
# redis-server在任何路径下都能使用,redis.conf需要在redis目录下使用
redis-server redis.conf
```

![image-20231201095929460](D:\text1\linux\assets\image-20231201095929460.png)



# 连接redis

> 要连接redis需要启动redis客户端

```shell
redis-cli
```

> 连接失败，原因是没有启动redis客户端

![image-20231201112041792](D:\text1\linux\assets\image-20231201112041792.png)

> 在第一个会话窗口启动redis客户端

![image-20231201112147069](D:\text1\linux\assets\image-20231201112147069.png)

> 然后再连接，成功连上

![image-20231201112215249](D:\text1\linux\assets\image-20231201112215249.png)



# 后台启动

> 想要连接redis就需要启动redis的客户端，但是启动redis的客户端会单独占据一个窗口，非常不方便，因此可以配置redis后台启动

```shell
# daemonize设置是否后台启动，默认是no，改为yes
daemonize 
```



# 查看版本

```shell
redis-cli -v
```

> 如果报错:
> <font color='red'>bash: redis-cli: 未找到命令</font>
> 将redis-6.0.5/src/下的redis-cli文件复制到/usr/local/bin目录下

```shell
cp /usr/local/redis/redis-6.0.5/src/redis-cli /usr/local/bin/
```



# 关闭redis

> 通过进程号杀死redis进程，从而关闭redis

```shell
# 查看redis进程列表
ps -ef | grep redis
# 杀死redis进程
kill redis进程id
```



# 远程连接

> 修改redis.conf文件，首先关闭redis，然后将bind的127.0.0.0改为远程连接的IP，如果允许所有IP都能连接redis，那么改为0.0.0.0，然后启动redis，注意**修改配置后需要先关闭再启动使配置生效**，如果是7.0以上的版本，需要将protected-mode改为no

```shell
bind 0.0.0.0 -::1
protected-mode no
```





