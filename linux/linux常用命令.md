```linux
claer		清屏
pwd			显示当前光标所在路径
cd			切换目录
```

# 显示文件列表

```
ls			 显示指定目录下的文件列表
ll或ls -l	显示指定目录下详细的文件列表
-a			 显示所有文件，包括隐藏文件
```

# 创建文件

```
touch 文件名    创建文件
stat 文件名     查看文件属性
```

# 创建目录

```
mkdir 目录名                 创建目录
mkdir -p 目录1/目录2/目录3    创建多级目录
#若父级目录存在，不需要加-p
mkdir 目录1/目录2/目录3
```

# 显示文件内容

```
cat 文件名      	显示文件内容
head 文件名     	从头显示文件内容
head -n 文件名  	从头显示前n行内容
tail 文件名     	从尾显示文件内容
tail -n 文件名  	从尾显示后n行内容
cat 文件名|more    分屏显示，只能前进翻页，空格翻页
cat 文件名|less    分屏显示，前后翻页，空格前翻，p后翻
grep              全局正则表达式显示，将匹配内容的显示出来
如：grep GATEWAY /etc/sysconfig/network-scripts/ifcfg-ens33
将ifcfg-ens33中含有GATEWAY的行显示
```

# 删除

```
rm 文件名       删除文件，会提问，不能删除目录
rm -f 文件名    强制删除文件，不会提问，不能删除目录
rmdir 目录名    删除目录，只能删除空目录
rm -rf 目录名   删除一切目录，无警告，不可恢复，慎用
```

# 用户

```linux
useradd 用户名  新建用户
passwd 用户名   更改用户密码
su 用户名       终端切换用户

终端信息：
[root@localhost opt]#
root			表示当前用户
@localhost		用户所在主机
opt				当前用户所在的路径
#				表示当前用户是超级管理员

切换tom用户
[root@localhost /]# su tom
[tom@localhost /]$ 
$					表示当前用户是普通用户
su 回车				切换到root，需要输入root密码
```

# 文件添加内容

```
vi/vim					编辑文件内容
echo 内容                打印出内容
echo 内容 > 文件		  将内容重定向到文件中，会覆盖
echo 内容 >> 文件		  将内容重定向到文件中，会追加
cat  文件1 > 文件2        将文件1中的内容重定向到文件2
```

# 查找

```
find查找效率慢
#通过文件名查找
find 查找的路径 -name 文件名 

#通过最近访问文件的时间查找，-是多少分钟之前，+是多少分钟之后
find 查找的路径 -amin -|+分钟 文件名 

#通过最近更改文件的时间查找，-是多少分钟之前，+是多少分钟之后
find 查找的路径 -cmin -|+分钟 文件名 

whereis			查找2进制文件

which			PATH中有的查找

locate			查询文件数据库，效率比find高，但是文件数据库不是自动				实时更新，且默认未安装
安装locat
yum install -y mlocate
更新文件数据库
updatedb
```

# 防火墙

```shell
# 查看防火墙状态
systemctl status firewalld		
# 关闭防火墙
systemctl stop firewalld		
# 启动防火墙
systemctl start firewalld		
# 查看防火墙例外端口列表
firewall-cmd --list-ports		
# 添加例外端口号，添加后需要重启防火墙以生效
firewall-cmd --permanent --zone=public --add-port=端口号/tcp					
# 重新加载防火墙
firewall-cmd --reload			
```

# 打包

```shell
tar		打包命令，扩展名.tar
-c		打包
-f		指定文件名
-x		拆包
实例 tar -cf aa.tar f1 f2
将f1和f2打包成aa.tar，若为*则打包当前目录下所有文件
```

打包

![image-20230704144613435](D:\text1\linux\assets\image-20230704144613435.png) 

拆包

![image-20230704145101912](D:\text1\linux\assets\image-20230704145101912.png) 

# 压缩

```
gzip		压缩程序，扩展名.gz
-d			解压
实例 gzip f1 f2，单独压缩，不是压缩在一起
```

压缩

![image-20230704145822903](D:\text1\linux\assets\image-20230704145822903.png) 

解压

![image-20230704145853350](D:\text1\linux\assets\image-20230704145853350.png) 

# 打包压缩

```
jdk-8u192-linux-x64.tar.gz
tar		表示打包程序为tar
gz		表示压缩程序为gzip

拆包解压：tar -xzvf jdk-8u192-linux-x64.tar.gz
tar		打包程序
-x		拆包
-z		解压程序gzip
-v		显示解压过程，可省略
-f		指定解压的文件

打包压缩：tar -czf my.tar.gz f1 f2
*		当前目录下所有文件
-c		创建打包文件
-z		使用gzip压缩算法进行压缩
-f		指定打包文件名
```

打包压缩

![image-20230704150654419](D:\text1\linux\assets\image-20230704150654419.png) 

拆包解压

![image-20230704151106049](D:\text1\linux\assets\image-20230704151106049.png) 

# yum

```
rpm是红帽公司发行版linux用来管理linux套件的程序，简单来讲就是安装程序但是rpm安装程序过于繁琐。比如安装一个程序需要3个依赖，使用rpm安装必须把3个依赖找齐缺一不可，yum是在rpm的基础上进行升级，安装程序时只需安装依赖a，yum会根据a的依赖关系自动将这个程序的所有依赖找齐
```

```shell
yum install -y 软件包
-y			跳过提问，全部选yes
```

# root修改用户权限

```shell
chmod o+w /opt

chmod		修改命令
u			拥有者用户
g			同组用户
a			所有用户
o			其他用户
+			赋予
-			清除
r			读权限
w			写权限
x			执行权限

10进制修改
chmod 767 /opt
赋予拥有者用户读、写执行权限，赋予同组用户读、写、不可执行权限，赋予其他用户读、写、执行权限
---		0	无任何权限
r--		4	读
rw-		6	读，写
rwx		7	读，写，执行
-w-		2	写
-wx		3	写，执行
--x		1	执行
r-x		5	读，执行
```

