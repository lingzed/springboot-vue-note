# 下载maven

> maven是一款绿色程序，无需安装，在官网下载后解压即可。注意，存储路径不带中文。
>
> 接下来分别介绍maven的三个目录：bin、conf、lib。

![image-20240221165710785](D:\text1\2.maven\assets\image-20240221165710785.png)



> bin目录中存放的是可执行文件也就是maven的指令，比如执行编译或打包等操作时就需要运行maven执行即mvn。

![image-20240221165906882](D:\text1\2.maven\assets\image-20240221165906882.png)



> conf目录存放maven的配置文件，配置maven的本地仓库和私服就需要在settings.xml文件中配置。

![image-20240221170034570](D:\text1\2.maven\assets\image-20240221170034570.png)

> lib目录存放maven依赖的jar包资源，因为maven是由java语言编写的。

![image-20240221170135986](D:\text1\2.maven\assets\image-20240221170135986.png)



# 配置本地仓库

> 修改conf/settings.xml中的<localRepository>标签，改成本地仓库的路径，如下图：

![image-20240221212456881](D:\text1\2.maven\assets\image-20240221212456881.png)



# 配置远程仓库

> 国内有很多私服，比如阿里云、淘宝等，此处配置阿里云的远程仓库。配置远程仓库需要修改<mirrors>标签，为其添加如下子标签：

```xml
<mirrors>
    <mirror>
        <id>alimaven</id>
        <name>aliyun maven</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
        <mirrorOf>central</mirrorOf>
    </mirror>
</mirrors>
```



# 配置环境变量

> 如果需要maven在任意目录下都能执行指令，就需要配置环境变量。配置环境变量MAVEN_HOME，MAVEN_HOME是maven的解压目录，并将其bin目录加入Path环境变量中。

![image-20240221214023483](D:\text1\2.maven\assets\image-20240221214023483.png)

![image-20240221213832020](D:\text1\2.maven\assets\image-20240221213832020.png)

> 测试，在cmd中执行mvn -v如果能看见mvn的版本号则安装成功。

![image-20240221214338829](D:\text1\2.maven\assets\image-20240221214338829.png)