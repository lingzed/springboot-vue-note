# 依赖配置

> 所谓依赖，就是项目运行时需要的jar包，一个项目可以引入多个依赖。
>
> 配置：
>
> 1. pom.xml中编写<dependencies>标签
> 2. <dependencies>中使用<dependency>引入坐标
> 3. 定义坐标的groupId、artifactId、version
> 4. 刷新是配置生效

![image-20240225113926466](D:\text1\2.maven\assets\image-20240225113926466.png)

> 如果刷新健缺失，【File】>>【Settings】>>【Plugins】，搜索Maven Hellper安装该插件，然后右键pom.xml【Run Maven】>>【Reimport】即可：

![image-20240225115106875](D:\text1\2.maven\assets\image-20240225115106875.png)

> 如果依赖引入成功，那么在项目下可以看见该依赖，如果失败则不会有Dependencies目录，以此可以作为检验依赖是否引入成功的标准：

![image-20240225115306783](D:\text1\2.maven\assets\image-20240225115306783.png)



# 依赖传递

> 事实上logbcak依赖引入后，不止有logback依赖：

![image-20240225134615894](D:\text1\2.maven\assets\image-20240225134615894.png)

> 可以看见，logback依赖下还有两个依赖，这是因为logback的jar包依赖于这两个依赖，在依赖于logback的同时又间接的依赖了这两个依赖，这个特性就是maven的依赖传递。
>
> 依赖是具有传递性的：
>
> - 直接依赖：在当前项目中通过依赖配置建立的依赖关系
> - 间接依赖：被依赖的资源如果依赖了其他资源，当前项目则间接其他资源

![image-20240225135738737](D:\text1\2.maven\assets\image-20240225135738737.png)

> 下面我将细致的展示传递性，准备3个项目：projectA、projectB、projectC。
>
> C项目中依赖commons-io：

![image-20240225140801738](D:\text1\2.maven\assets\image-20240225140801738.png)

> B项目中依赖junit和C项目：

![image-20240225140859013](D:\text1\2.maven\assets\image-20240225140859013.png)

> A项目中依赖B项目和logback：

![image-20240225140936411](D:\text1\2.maven\assets\image-20240225140936411.png)

> 此时A项目直接依赖B项目，并没有依赖C项目，但是由于B项目依赖C项目，通过传递性，A就会间接的依赖于C项目和C下的其他依赖：

![image-20240225141123200](D:\text1\2.maven\assets\image-20240225141123200.png)

> 通过图示更能体现，在pom.xml中【ctrl】+【alt】+【shift】+【u】：

![image-20240225141407669](D:\text1\2.maven\assets\image-20240225141407669.png)



## 排除依赖

> 在依赖传递中如果a依赖b，b依赖c，那么默认情况下a会依赖c的，如果a只想依赖b不想依赖c可以通过排除依赖来实现。
>
> - 排除依赖：主动断开依赖资源、被排除的依赖无需指定版本
>
> 可以通过标签<exclusion>将依赖排除出去，例如A依赖了B，B将junit传递给了A，但是A不想要junit，就可以将junit排除，junit是在依赖B的时候传递的，因此也要在依赖B的地方排除：

![image-20240225142243994](D:\text1\2.maven\assets\image-20240225142243994.png)

> 现在A就不会依赖junit了：

![image-20240225142329248](D:\text1\2.maven\assets\image-20240225142329248.png)



# 依赖范围

> 在pom中配置的依赖，默认情况下可以在任何地方使用，这里的任何地方指的是main目录(主程序范围有效)、test目录(测试程序范围有效)也可以在打包时将这个依赖打包进去。
>
> 在maven中我们可以通过<scope>来控制这个依赖的作用范围，<scope>常见取值如下：

|      scope      | 主程序 | 测试程序 | 打包(运行) |    范例     |
| :-------------: | :----: | :------: | :--------: | :---------: |
| compile（默认） |   Y    |    Y     |     Y      |    log4j    |
|      test       |   -    |    Y     |     -      |    junit    |
|    provided     |   Y    |    Y     |     -      | servlet-api |
|     runtime     |   -    |    Y     |     Y      |  jdbc驱动   |

> - compile：表示这个依赖在主程序中有效、在测试程序中有效也会参与打包，比如log4j或其他多数依赖，默认值时<scope>不用配置
> - test：表示这个依赖只在测试程序有效、主程序无效且不会参与打包，如junit
> - provided：表示这个依赖在主程序中有效、在测试程序中有效但不会参与打包，如servlet-api
> - runtime：表示这个依赖在主程序中无效、在测试程序中有效且不会参与打包，如jdbc驱动
>
> 现在我将logback依赖设置test：

![image-20240225144200346](D:\text1\2.maven\assets\image-20240225144200346.png)

> 在测序下引入依赖会报错：

![image-20240225144534869](D:\text1\2.maven\assets\image-20240225144534869.png)

> 测试程序中则不会报错：

![image-20240225144614412](D:\text1\2.maven\assets\image-20240225144614412.png)

> 将其改回默认，在主程序中就能引用了：

![image-20240225144758503](D:\text1\2.maven\assets\image-20240225144758503.png)



# 生命周期

> maven的声明周期是为了对所有的maven项目构建过程进行抽象和统一。
>
> 事实上maven的生命周期不是一条线，而是有三套相互独立的生命周期：
>
> - clean：清理工作
> - default：核心工作，如：编译、测试、打包、安装、部署等
> - site：生成报告、发布站点等
>
> 每套生命周期都有各自的阶段：

![image-20240225150642913](D:\text1\2.maven\assets\image-20240225150642913.png)

> 看着很多，但只需掌握以下部分：

![image-20240225150825398](D:\text1\2.maven\assets\image-20240225150825398.png)

> 阶段之间是有先后顺序的，先运行前面的阶段，再运行后面的阶段，而后面的阶段是依赖于前面的阶段的。在一套生命周期中运行后面的阶段，前面的阶段也会跟着运行，如，运行packge这个阶段，前面的complile和test也会运行，但这是针对统一套生命周期，不同生命周期之间互不影响。
>
> - clean：移除上一次构建生成的文件
> - complile：编译项目的源代码
> - test：使用合适的单元测试框架运行测试(junit)
> - package：将编译后的文件打包，如：jar、war等
> - install：把打好的包安装到本地仓库

![image-20240225151647849](D:\text1\2.maven\assets\image-20240225151647849.png)

> 跳过test阶段：

![image-20240225153059512](D:\text1\2.maven\assets\image-20240225153059512.png)

> 运行阶段有两种方式，一种是在Maven工具栏选中对应阶段双击即可、一种是在命令行中运行，格式是：mvn 阶段名。