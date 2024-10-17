# 1、Maven

## 1.1、Maven简介

> Maven项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和文档的项目管理工具软件。
>
> Maven 除了以程序构建能力为特色之外，还提供高级项目管理工具。由于 Maven 的缺省构建规则有较高的可重用性，所以常常用两三行 Maven 构建脚本就可以构建简单的项目。由于 Maven 的面向项目的方法，许多 Apache Jakarta项目发文时使用 Maven，而且公司项目采用 Maven 的比例在持续增长。

## 1.2、Maven中央仓库

> https://mvnrepository.com/

## 1.3、Maven工程和非Maven工程对比

|          Maven           |         非Maven工程          |
| :----------------------: | :--------------------------: |
| 自动下载自动导入jar文件  |     必须手动导入jar文件      |
| jar文件相互之间兼容性好  |  jar文件相互之间存在不兼容   |
|  删除或修改jar文件方便   |   删除或修改jar文件不方便    |
| 支持多工程复用，方便复用 | 不支持多工程复用，复用不方便 |
|     可以创建父子工程     |      不可以创建父子工程      |

## 1.4、下载Maven

![image-20230808162035732](D:\text1\java_text\assets\image-20230808162035732.png)

## 1.5、配置Maven

> 下载以后，解压，解压时不建议放在中文目录中。

### 1.5.1、修改Maven的配置文件

![image-20230808162333383](D:\text1\java_text\assets\image-20230808162333383.png)

> 打开该文件。

![image-20230808162917604](D:\text1\java_text\assets\image-20230808162917604.png)

配置阿里云中央仓库

> ```xml
> 	<mirror>
> 		  <id>alimaven</id>
> 		  <name>aliyun maven</name>
> 		  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
> 		  <mirrorOf>central</mirrorOf>        
>     	</mirror>
> ```
>
> 以后下载jar依赖文件都会到阿里云下载。

### 1.5.2、配置环境变量

![image-20230808163757205](D:\text1\java_text\assets\image-20230808163757205.png)

![image-20230808163852067](D:\text1\java_text\assets\image-20230808163852067.png)

### 1.5.3、验证环境变量

![image-20230808164139147](D:\text1\java_text\assets\image-20230808164139147.png)

## 1.6、配置IDEA的Maven

![image-20230808164425608](D:\text1\java_text\assets\image-20230808164425608.png)

![image-20230808164655962](D:\text1\java_text\assets\image-20230808164655962.png)

![image-20230808164739576](D:\text1\java_text\assets\image-20230808164739576.png)

![image-20230808164856309](D:\text1\java_text\assets\image-20230808164856309.png)

![image-20230808165029444](D:\text1\java_text\assets\image-20230808165029444.png)

## 1.7、IDEA创建Maven工程

![image-20230808170234570](D:\text1\java_text\assets\image-20230808170234570.png)

![image-20230808170608281](D:\text1\java_text\assets\image-20230808170608281.png)

> 等待加载完成，完整的Maven工程如下图 :
>
> 表示Maven的web工程创建成功.

![image-20230808172727749](D:\text1\java_text\assets\image-20230808172727749.png)

![image-20230808172820604](D:\text1\java_text\assets\image-20230808172820604.png)

> 至此Maven工程基本创建成功。

## 1.8、maven工程结构

web工程结构

![image-20230809085353790](D:\text1\java_text\assets\image-20230809085353790.png)

javase工程结构

![image-20230809090126606](D:\text1\java_text\assets\image-20230809090126606.png)

## 1.9、添加依赖

![image-20230809091447958](D:\text1\java_text\assets\image-20230809091447958.png)

## 1.10、Maven常用命令

> mvn compile 编译源代码
>
> mvn deploy 发布项目
>
> mvn test-compile 编译测试源代码
>
> mvn test 运行应用程序中的单元测试
>
> mvn site 生成项目相关信息的网站
>
> mvn clean 清除项目目录中的生成结果
>
> mvn package 根据项目生成的jar
>
> mvn install 在本地Repository中安装jar
>
> mvntomcat:run 启动tomcat服务
>
> mvn clean package -Dmaven.test.skip=true:清除以前的包后重新打包，跳过测试类

## 1.11、将相关工程添加到本地仓库

![image-20230809093914538](D:\text1\java_text\assets\image-20230809093914538.png)

![image-20230809094147909](D:\text1\java_text\assets\image-20230809094147909.png)

## 1.12、解决JDK版本问题

> 在pom.xml中添加，如下plugin插件，即可解决JDK或jre版本问题.

```xml
<build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <!--Maven编译编译插件-->
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.6.0</version>
        <configuration>
          <!--指定编译的JDK或JRE版本-->
          <source>11</source>
          <target>11</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

## 1.13、添加其他工程依赖

![image-20230809103925424](D:\text1\java_text\assets\image-20230809103925424.png)

![image-20230809104138191](D:\text1\java_text\assets\image-20230809104138191.png)

![image-20230809104241148](D:\text1\java_text\assets\image-20230809104241148.png)

![image-20230809104446006](D:\text1\java_text\assets\image-20230809104446006.png)

![image-20230809104551621](D:\text1\java_text\assets\image-20230809104551621.png)

## 1.14、创建父子Maven工程

### 1.14.1、创建Maven父工程

> 父工程的作用主要用于规范/规定所有工程中统一的依赖文件。

![image-20230809110659273](D:\text1\java_text\assets\image-20230809110659273.png)

### 1.14.2、创建Maven子工程

> 创建Maven的子工程时，可以选择javase工程，也可以选择web工程，和上面创建普通的Maven工程一样，此处省略。

![image-20230809110922251](D:\text1\java_text\assets\image-20230809110922251.png)

![image-20230809111138697](D:\text1\java_text\assets\image-20230809111138697.png)

![image-20230809111251767](D:\text1\java_text\assets\image-20230809111251767.png)

![image-20230809111454909](D:\text1\java_text\assets\image-20230809111454909.png)

![image-20230809112048456](D:\text1\java_text\assets\image-20230809112048456.png)

![image-20230809112703754](D:\text1\java_text\assets\image-20230809112703754.png)

## 1.15、依赖范围

> 每个依赖的使用范围，指定如下:

| **依赖范围** | ***编译时有效*** | ***测试时有效*** | ***运行时有效*** |
| :----------: | :--------------: | :--------------: | :--------------: |
|   compile    |        Y         |        Y         |        Y         |
|     test     |        -         |        Y         |        -         |
|   provided   |        Y         |        Y         |        -         |
|   runtime    |        -         |        Y         |        Y         |
|    system    |        Y         |        Y         |        -         |