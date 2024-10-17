# 1.什么是maven

> maven是apache旗下的一个开源项目，maven就是一个**<font color='yellow'>管理</font>**和**<font color='yellow'>构建</font>**java项目的工具



# 2.maven的作用

> maven的作用主要体现在三个方面：
>
> 1. 依赖管理
> 2. 统一项目目录结构
> 3. 标准化的项目构建流程



## 2.1.依赖管理

> 通过maven能很方便的管理项目依赖的资源(jar包)，同时还能避免资源版本冲突的问题。
>
> 比如，如果项目中需要logback依赖，那么就需要在网上将logback的相关依赖全部下载下来复制到项目中，才可以使用，如果使用传统的方式手动导入jar包会非常繁琐，而且在大型的项目中通常会涉及到几百上千个jar包，这不利于管理。
>
> 另外，如果在后期需要对某一个jar包进行升级，那么相关依赖也需要升级，在众多jar包中找到相关的依赖并升级是一件很繁琐的事。
>
> 使用maven就能轻松管理jar包的依赖和版本问题，在maven项目中有一个pom.xml文件，这个文件中配置描述信息maven就能自动下载需要的jar包和其他的依赖，当需要升级版本时，改动版本号，jar包和依赖jar包也会对应的升级。

```xml
<dependencys>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <version>2.6.2</version>
    </dependency>
</dependencys>
```



## 2.2.统一的目录结构

> java工程的开发工具非常多，如：eclipse、myeclipse、IDEA等等，每个工具创建的java项目目录结构是不同的，如果我在IDEA上创建的项目需要导入eclipse中，由于目录结构不同就会出现错误。
>
> 而maven创建的项目是统一的目录结构，只要是使用maven创建的项目就能在不同的开发工具之间导入导出。
>
> maven创建的项目基础目录结构如下：

![1](D:\text1\2.maven\assets\1-1708354612763-2.png)

|          目录           |              作用              |
| :---------------------: | :----------------------------: |
|          main           |       存放项目的实际资源       |
|          test           |       存放项目的测试资源       |
|          java           |        存放项目的源代码        |
|        resources        |          存放配置文件          |
| test下的java和resources | 存放测试相关的源代码和配置文件 |
|         pom文件         | maven的核心配置文件(jar包依赖) |



## 2.3.项目构建

> 标准化的项目构建流程，在maven中提供了一套标准跨平台(Windows、Linux、MacOS)的自动化项目构建方式。
>
> 普通的项目流程是：【编译】>>【测试】>>【打包】>>【发布】，在maven中将这个流程进行了标准化，制作了一套标准的构建流程：【清理】>>【编译】>>【测试】>>【打包】>>【发布】。
>
> 我们可以基于maven提供的这些流程指令快速的完成项目的编译、测试、打包、发布等操作。
>
> 以IDEA为例，如果需要对项目进行编译，只需要在右侧边栏找到maven项目然后打开项目找到compile指令双击运行即可对项目进行编译工作。

![1](D:\text1\2.maven\assets\1-1708355223818-4.png)

>并且会将编译后的文件放在target目录下，class目录下就是编译之后的字节码文件。

![1](D:\text1\2.maven\assets\1-1708355466788-6.png)

> 而如果需要打包项目只需要执行package指令、打包好的jar包也会存放在target目录下。

![image-20240219231307197](D:\text1\2.maven\assets\image-20240219231307197.png)



# 3.maven的模型

> maven是基于"项目对象模型"(POM)概念，通过一小段描述信息来管理项目的构建。POM即Project Object Model。
>
> maven的模型概念图如下：

![image-20240220223008838](D:\text1\2.maven\assets\image-20240220223008838.png)

> maven的模型大致分为三部分
>
> 第一部分如下图：

![image-20240220223044103](D:\text1\2.maven\assets\image-20240220223044103.png)

> 这部分是maven构建生命周期的各阶段，通过maven中提供的各种插件就能完成对应的功能。比如，通过编译插件就能对项目进行编译、通过测试插件就能对项目进行测试、通过打包插件进行打包等操作。
>
> 不同的阶段，又会有不同的文件产生，比如编译阶段会生成字节码文件，打包阶段会生成对应的jar包。
>
> 第二部分如下图：

![image-20240220223310225](D:\text1\2.maven\assets\image-20240220223310225.png)

> 这部分就是POM项目对象模型，指的是maven可以在pom.xml文件中配置一小块描述信息来描述这个maven工程。
>
> 如图所示：

![image-20240220223758878](D:\text1\2.maven\assets\image-20240220223758878.png)

> 这块描述信息就是用来描述这个工程的。
>
> artifactId：描述当前项目的名称
>
> groupId：描述当前项目归属的组织
>
> version：描述当前项目的版本
>
> 这个三项信息称为<font color='yellow'>**maven的坐标**</font>，通过一个坐标就能唯一标识和定位项目。
>
> 第三部分如下图：

![image-20240220224544785](D:\text1\2.maven\assets\image-20240220224544785.png)

> 当添加依赖时，在pom文件中添加依赖管理模型(Dependency)，如下图：

![image-20240220224805925](D:\text1\2.maven\assets\image-20240220224805925.png)

> 当添加完成后，maven就会到仓库中去找到对应的依赖，依赖的存储地址与依赖的描述信息有关，如下图：

![image-20240220225244508](D:\text1\2.maven\assets\image-20240220225244508.png)

![image-20240220225300582](D:\text1\2.maven\assets\image-20240220225300582.png)

> 此处的仓库称为本地仓库，也就是存储在个人电脑上的目录，这个目录在安装时可以自己指定的，与之对应的是中央仓库，全球唯一的，中央唱仓库中基本包含了全球对外发布的jar包。
>
> 地址：<a href='https://repol.maven.org/mavne2/'>https://repol.maven.org/mavne2/</a>
>
> maven查找依赖会先在本地仓库查找，如果找到就直接引用，如果找不到，就在中央仓库中去找，找到后引用并下载到本地仓库中，第二次则直接在本地仓库中引用。但是由于中央仓库的服务器在国外，直接从中央仓库下载比较慢，因此诞生出了一个私服，即远程仓库。此时的下载顺序是本地仓库中没有到远程仓库中，远程仓库没有再到中央仓库，如下图：

![image-20240220230900393](D:\text1\2.maven\assets\image-20240220230900393.png)