# 安装依赖包

> 一键安装四个依赖

```shell
yum -y install gcc zlib zlib-devel pcre-devel openssl openssl-devel
```



# 下载并解压安装包

> 进入/usr/local下创建nginx目录，进入该目录下载并解压tar包

```shell
cd /usr/local
mkdir nginx
cd nginx
//下载tar包
wget http://nginx.org/download/nginx-1.13.7.tar.gz
tar -xvf nginx-1.13.7.tar.gz
```



# 安装nginx

```shell
//进入目录
cd nginx-1.13.7
//执行命令 考虑到后续安装ssl证书 添加两个模块
./configure --with-http_stub_status_module --with-http_ssl_module
//执行make命令
make
//执行make install命令
make install
```



# 启动nginx服务

```shell
/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
```



# 配置nginx.conf

```shell
# 打开配置文件
vi /usr/local/nginx/conf/nginx.conf
```

> 将端口号改成8089(随便挑个端口)，因为可能apeache占用80端口，apeache端口尽量不要修改，我们选择修改nginx端口。
>
> 将localhost修改为你服务器的公网ip地址。

![image-20231129142352639](D:\text1\linux\assets\image-20231129142352639.png)



# 重启nginx

```shell
/usr/local/nginx/sbin/nginx -s reload
```



# 查看nginx进程

> 查看nginx进程是否启动

```shell
ps -ef | grep nginx
```

![image-20231129142819066](D:\text1\linux\assets\image-20231129142819066.png)



# 开放nginx端口

```shell
# 添加8090例外端口
firewall-cmd --permanent --zone=public --add-port=8090/tcp
# 重启防火墙让端口生效
fireall-cmd --reload
```



# 远程访问成功

![image-20231129144134978](D:\text1\linux\assets\image-20231129144134978.png)



# nginx常用命令

```shell
# 启动
/usr/local/nginx/sbin/./nginx
# 关闭
/usr/local/nginx/sbin/./nginx -s stop 
# 重启,重启需要在nginx启动才能运行
/usr/local/nginx/sbin/./nginx -s reload 
```