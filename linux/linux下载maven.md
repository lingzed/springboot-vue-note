# 下载maven安装包

> 在/usr/local/下创建一个maven目录，在目录中下载安装

```shell
wget https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
```



# 解压缩maven

```shell
tar -zxvf apache-maven-3.3.9-bin.tar.gz
```



# 配置环境变量

```shell
# 修改profile
vim /etc/profile
# 添加maven路径
export MAVNE_HOME=/usr/local/mavne/apache-maven-3.3.9
# 添加bin路径
export PATH=$PATH:$MAVNE_HOME/bin
# 使改动生效
source /etc/profile
```



# 查看是否安装成功

```shell
mvn -version
```

> 如果出现maven的版本，说明安装成功

![image-20231130095442867](D:\text1\linux\assets\image-20231130095442867.png)



# 创建本地仓库

```shell
mkdir -p /usr/local/maven/repository
```



# 配置文件

> 在settings.xml中，配置相应的仓库路径以及国内仓库地址，settings.xml在apache-maven-3.3.9/conf目录下

```shell
vim /usr/local/maven/apache-maven-3.3.9/conf/settings.xml
```

```xml
<mirrors>
    <mirror>
		<id>alimaven</id>
		<name>aliyun maven</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
		<mirrorOf>central</mirrorOf>        
    </mirror>
</mirrors>
```

![image-20231130100949851](D:\text1\linux\assets\image-20231130100949851.png)