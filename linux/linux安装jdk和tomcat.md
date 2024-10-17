# winSCP

winSCP是一个工具，主机和虚拟机之间可以互相传输数据，但是很繁琐，winSCP可以简单的实现主机和虚拟机之间传输数据

输入虚拟机的IP，用户名和密码。

![image-20230703174726542](D:\text1\linux\assets\image-20230703174726542.png)  

保存用户名和密码后登录

![image-20230703175050702](D:\text1\linux\assets\image-20230703175050702.png) 

传输到虚拟机的文件保存在opt中，定位到opt目录

![image-20230703175342286](D:\text1\linux\assets\image-20230703175342286.png) 

将主机的文件选中并拖到虚拟机窗口中，实现文件传输

![image-20230703175541034](D:\text1\linux\assets\image-20230703175541034.png) 

上传成功

![image-20230703175653812](D:\text1\linux\assets\image-20230703175653812.png)

# 安装jdk

## 1、解压jdk

```
jdk-8u192-linux-x64.tar.gz
tar		表示打包程序为tar
gz		表示压缩程序为gzip

解压：tar -xzvf jdk-8u192-linux-x64.tar.gz
tar		打包程序
-x		拆包
-z		解压程序gzip
-v		显示解压过程，可省略
-f		指定解压的文件
```

![image-20230703182641750](D:\text1\linux\assets\image-20230703182641750.png) 

## 2、改名

使用mv移动，如果不指定移动的路径默认在当前路径移动

```
mv jdk1.8.0_192 jdk8
```

将jdk1.8.0_192在当前目录移动为jdk8，实际上就是改名

![image-20230703182943502](D:\text1\linux\assets\image-20230703182943502.png) 

## 3、移动

移动到/user/local/soft目录，/user/local下没有soft目录，需要新建一个，以后的软件都放在这个目录下

```
#父级目录存在，不需要加-p
mkdir /usr/local/soft
```

![image-20230703183248106](D:\text1\linux\assets\image-20230703183248106.png) 

移动

```
mv jdk8 /usr/local/soft/
```

![image-20230703183649258](D:\text1\linux\assets\image-20230703183649258.png) 

## 4、配置环境变量

配置文件：/etc/profile

编辑这个文件，定位到末尾行插入

#jdk的路径

```
export JAVA_HOME=/usr/local/soft/jdk8		
export PATH=$JAVA_HOME/bin:$PATH
```

![image-20230703191744304](D:\text1\linux\assets\image-20230703191744304-1689727231112-1.png) 

## 5、文件生效

```
source /etc/profile
```

## 6、验证

```
java -version
```

出现java版本信息说明成功

![image-20230703191852625](D:\text1\linux\assets\image-20230703191852625.png)  

# 安装tomcat

tomcat是开发Java web的一种容器，以后用Java开发的网站可以部署在tomcat上。

$\textcolor{red}{安装tomcat前置条件：Java安装好and环境变量配置好}$

## 1、解压

```
tar -xzf apache-tomcat-9.0.39.tar.gz
```

![image-20230704104214735](D:\text1\linux\assets\image-20230704104214735.png) 

## 2、移动并改名

将改名和移动两步操作合并，把解压后的文件移动到soft目录下

```
mv apache-tomcat-9.0.39 /usr/local/soft/tomcat9
```

![image-20230704104814063](D:\text1\linux\assets\image-20230704104814063.png) 

## 3、启动和关闭

进入tomcat/bin目录下

![image-20230704105422123](D:\text1\linux\assets\image-20230704105422123.png) 

```shell
startup.sh		#启动tomcat的脚本
shutdown.sh		#关闭tomcat的脚本
```

启动命令：

```
./startup.sh
```

![image-20230704105709523](D:\text1\linux\assets\image-20230704105709523.png) 

关闭命令：

```
./shutdown.sh
```

## 4、win主机远程访问tomcat

在浏览器中输入主机IP以及端口号8080访问

```
http://192.168.138.3:8080
```

浏览器显示访问超时，这是因为虚拟机的防火墙把8080端口给墙了

![image-20230704111626880](D:\text1\linux\assets\image-20230704111626880.png) 

```
systomctl status firewalld		查看防火墙状态
systemctl stop firewalld		关闭防火墙
systemctl start firewalld		启动防火墙
firewall-cmd --list-ports		查看防火墙例外端口列表
firewall-cmd --permanent --zone=public --add-port=端口号/tcp							添加例外端口号
firewall-cmd --reload			重新加载防火墙
```

防火墙运行时显示running

![image-20230704112351682](D:\text1\linux\assets\image-20230704112351682.png) 

关闭时显示dead

![image-20230704112432386](D:\text1\linux\assets\image-20230704112432386.png) 

关闭防火墙后再次访问

![image-20230704112515721](D:\text1\linux\assets\image-20230704112515721.png) 

在开启防火墙时添加例外端口号为这个端口放开，也可以实现访问

查看例外端口号没有8080端口

![image-20230704113349645](D:\text1\linux\assets\image-20230704113349645.png) 

添加

![image-20230704113438147](D:\text1\linux\assets\image-20230704113438147.png) 

再次查看没有看见8080端口是因为没有重载，重载后看见8080端口

![image-20230704113751123](D:\text1\linux\assets\image-20230704113751123.png)  

再次访问成功

![image-20230704113728447](D:\text1\linux\assets\image-20230704113728447.png) 