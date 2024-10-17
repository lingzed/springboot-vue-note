# 配置国内下载镜像

> 不管是哪个版本的maven，建议都配置国内的下载镜像，这样拉取国外的jar包或者下载其他资源都比较快，这里用aliyun的镜像。

> 进入maven的目录，找到conf文件夹，里面有一个settings.xml文件，用文本编辑器打开，找到\<mirrors>节点，添加aliyun的镜像。

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

