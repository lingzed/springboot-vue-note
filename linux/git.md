创建git工作文件的目录，在目录中右键运行git bash here

```
进行全局设置
git config --global user.name 用户名
git config --global user.email 邮箱

本地版本库初始化
git init
```

运行完成后在git目录中会生成一个.git文件

![image-20230707161614311](D:\text1\linux\assets\image-20230707161614311.png) 

工作区：跟.git文件同一级的目录就是工作区

暂存区：提交的代码或文件一般要先放在工作区，然后提交到暂存区，暂存区一般是.git目录下的index中

版本库：文件最终提交的地方

提交文件的流程，将文件放在工作区，然后提交到暂存区，然后再提交到版本库中

# 上传文件

## 本地版本库中

工作区中的文件

![image-20230707163030771](D:\text1\linux\assets\image-20230707163030771.png) 

```
git status		查看状态，未提交到暂存区的文件显示为红色
```

![image-20230707163145257](D:\text1\linux\assets\image-20230707163145257.png) 

```
git add 文件名		提交到暂存区，*通配符匹配所有文件，提交到暂存区的				   文件显示为绿色
```

![image-20230707163330124](D:\text1\linux\assets\image-20230707163330124.png) 

```
git rm --cacher 文件名		从暂存区中删除文件，文件回到工作区中，							  暂存区为用户提供后悔的功能
```

![image-20230707163712829](D:\text1\linux\assets\image-20230707163712829.png) 

```
git commit -m 注释		提交到版本库中，每一次提交都要注释
```

![image-20230707163941412](D:\text1\linux\assets\image-20230707163941412.png) 

## 远程版本库中