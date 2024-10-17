一个项目在a电脑上完成能成功运行，当用户用自己的电脑运行时，如果用户电脑的环境如软件版本，数据库版本不同
就可能造成项目出现bug，解决方法说将运行成功的环境一起部署，这样用户在访问时使用的环境就是正确的环境
docker就是这样一个容器

从镜像中运行容器，以tomcat镜像为例，要运行tomcat容器，首先要拉取tomcat的镜像，然后从tomcat镜像中运行tomcat容器，每一个容器实际上是一个小型的操作系统，tomcat容器就是一个小型的liunx系统，安装了java和tomcat，因为tomcat要运行必须要先安装java。

从镜像中运行容器，每个容器实际上是一个微型操作系统，这个操作系统中安装这个容器运行需要的程序

![image-20230708180334327](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708180334327.png) 

使用docker前需要在超级管理员下系统启动docker，才能进行后续操作

# 系统启动docker

```
systemctl start docker
```

# 查看镜像内部信息

```
docker inspect 容器名
```

# 从镜像运行容器

```
docker run -d -p 端口映射 --name 容器名 镜像名
run		运行容器
-d		后台运行
-p		端口映射
--name	容器名
```

![image-20230708180923007](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708180923007.png) 

容器中小型linux采用的是仅主机的网络模式，也就是说只有虚拟机可以访问这个容器，而主机不能访问，想要访问这个容器就需要端口映射

# 显示容器

```
docker ps		显示正在运行的容器
docker ps -a	显示所有容器，包括不运行的
```

![image-20230708181331689](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708181331689.png) 

容器的id取前12位，是否在运行，容器的名称，创建时间等都可以看见

# 启动/停止容器

```
docker start 容器名		启动容器
docker stop 容器名			停止容器
```

# 查看容器

```
docker images 
```

# 登录容器的操作系统

```
docker exec -it 容器名 bash
exec		执行
-i			交互式
-t			指定终端
bash		终端脚本
```

进入容器的操作系统后显示容器的id前12位

![image-20230708200913414](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708200913414.png) 

在tomcat的目录中的webapps目录，web程序就部署在这个里面

![image-20230708201021954](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708201021954.png) 

主机访问tomcat容器，通过映射的8081端口访问http://192.168.138.3:8081

![image-20230708181742224](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708181742224.png) 

虽然显示404，但实际上是访问成功的只是这个容器里没有东西。以后搭建了一个网站然后部署到tomcat容器上时再访问就能显示东西了。查看webapps目录就知道，这个目录说明也没有所有才会显示404

![image-20230708201152392](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708201152392.png) 

# 部署页面

做一个实验，将一个网页部署到tomcat容器中然后访问这个页面

![image-20230708182807059](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708182807059.png) 

![image-20230708182927791](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708182927791.png) 

将这个hello拷贝到tomcat容器的webapps目录中

```
docker cp hello tomcat10:/usr/local/tomcat/webapps
```

![image-20230708201853433](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708201853433.png) 

![image-20230708201920321](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708201920321.png) 

再次访问映射的端口地址IP，这里要注意web程序在hello文件中，所以访问时要加上这个文件。http://192.168.138.3.8081/hello

![image-20230708202350243](C:\Users\asus\Desktop\新建文件夹\assets\image-20230708202350243.png) 

# 退出容器

```
exit
```

# 运行mysql容器

多了一个给mysql密码

```
docker -d -p 3306:3306 --name mysql8 -e MYSQL_ROOT_PASSWORD=123456 mysql
-e		环境配置
```

# 远程连接mysql容器

如果主机上已经安装了mysql，需要停止(可以再修改为手动启动)因为主机上的mysql端口也是3306，会和mysql容器的端口冲突。

![image-20230709180424725](C:\Users\asus\Desktop\新建文件夹\assets\image-20230709180424725.png) 

下载sqlyog，sqlyog是第三方图形界面跟navicat差不多。打开，选择新建连接，连接到虚拟机同通过3306端口访问mysql容器，选择测试连接，如果显示成功，选择连接

![image-20230709181417159](C:\Users\asus\Desktop\新建文件夹\assets\image-20230709181417159.png) 

连接成功

![image-20230709181841146](C:\Users\asus\Desktop\新建文件夹\assets\image-20230709181841146.png) 
