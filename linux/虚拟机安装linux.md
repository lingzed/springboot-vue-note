# 安装步骤

> 创建新虚拟机

![image-20231109105744296](D:\text1\linux\assets\image-20231109105744296.png)

> 选择自定义

![image-20231109105809873](D:\text1\linux\assets\image-20231109105809873.png)

> 下一步

![image-20231109105835549](D:\text1\linux\assets\image-20231109105835549.png)

> 选择稍后安装

![image-20231109105902682](D:\text1\linux\assets\image-20231109105902682.png)

> 选择安装Linux系统，并选择版本CentOS7(根据实际情况选择版本)

![image-20231109110024673](D:\text1\linux\assets\image-20231109110024673.png)

> 取名，选择安装的路径

![image-20231109110230814](D:\text1\linux\assets\image-20231109110230814.png)

> 处理器和总核数依据自身情况选择

![image-20231109110410488](D:\text1\linux\assets\image-20231109110410488.png)

> 分配内存，一般2G完全够用，视情况而定

![image-20231109110553680](D:\text1\linux\assets\image-20231109110553680.png)

> 默认NAT

![image-20231109110628927](D:\text1\linux\assets\image-20231109110628927.png)

> 默认

![image-20231109110656927](D:\text1\linux\assets\image-20231109110656927.png)

> 默认

![image-20231109110710469](D:\text1\linux\assets\image-20231109110710469.png)

> 创建新虚拟磁盘

![image-20231109111248751](D:\text1\linux\assets\image-20231109111248751.png)

> 将虚拟磁盘拆分成多文件，磁盘大小视情况而定，这里设置30G不代表真机的磁盘空间就少30G

![image-20231109111540655](D:\text1\linux\assets\image-20231109111540655.png)

> 默认

![image-20231109111608151](D:\text1\linux\assets\image-20231109111608151.png)

> 自定义硬件

![image-20231109111646830](D:\text1\linux\assets\image-20231109111646830.png)

> 移除打印机和显示器

![image-20231109111736329](D:\text1\linux\assets\image-20231109111736329.png)

> 选择镜像文件

![image-20231109112933020](D:\text1\linux\assets\image-20231109112933020.png)

> 完成

![image-20231109113033760](D:\text1\linux\assets\image-20231109113033760.png)

> 开机

![image-20231109113513218](D:\text1\linux\assets\image-20231109113513218.png)

> 选择Install CentOS 7

![image-20231109113614349](D:\text1\linux\assets\image-20231109113614349.png)

> 选择中文

![image-20231109113816435](D:\text1\linux\assets\image-20231109113816435.png)

> 安装方式改为最小安装(大佬选择)，视情况而定

![image-20231109113954244](D:\text1\linux\assets\image-20231109113954244.png)

> 不启用KDUMP，启用会占内存

![image-20231109114042368](D:\text1\linux\assets\image-20231109114042368.png)

> 安装位置，选择我要分配分区

![image-20231109114222966](D:\text1\linux\assets\image-20231109114222966.png)

> 选择标准分区

![image-20231109114304005](D:\text1\linux\assets\image-20231109114304005.png)

> 添加/boot分区，一般分配200M

> boot是引导分区，作用是系统启动，在boot分区存放着grub，内核文件等

![image-20231109114602899](D:\text1\linux\assets\image-20231109114602899.png)

> 添加swap分区，一般2G

> swap是交换分区，内存扩展分区，交换分区给多大？ 一般做多：8G，16G，如果系统使用到了swap分区，就直接添加物理内存或排查一下服务器有没有被黑

![image-20231109114734163](D:\text1\linux\assets\image-20231109114734163.png)

> 添加/分区，一般10G

![image-20231109114936707](D:\text1\linux\assets\image-20231109114936707.png)

> 开始安装，设置root的密码

![image-20231109115043065](D:\text1\linux\assets\image-20231109115043065.png)



# 关闭测通道缓存

![image-20231109133321486](D:\text1\linux\assets\image-20231109133321486.png)

> 虚拟机右键编辑，在【选项】>【高级】中关闭

![image-20231109133647584](D:\text1\linux\assets\image-20231109133647584.png)



# 安装工具

> wget，下载工具，类似于迅雷，可以通过HTTP，HTTPS，FTP协议进行下载，也就是直接通过url地址下载

```shell
yum install -y wget
```

> net-tools，网络工具

```shell
yum install -y net-tools
```

> vim编辑器

```shell
yum install -y vim-enhanced
```



# 关闭selinux

> selinux是安全增强型linux，涵盖庞大复杂的linux安全相关知识和概念，很多程序员嫌麻烦就关闭了，除了安全性降低没有什么隐患。

> selinux的坏处：
>
> 1. selinux虽然提高了安全性，但是占用过多内存
> 2. selinux对文件的权限和访问有严格控制，可能影响一些程序的正常运行
> 3. 某些版本中，selinux会影响自身系统的一些功能的运行

```shell
vim /etc/selinux/config
```

> 将SELINUX=enforcing改为SELINUX=disabled，然后重启

```shell
# 查看selinux的状态，值为Disabled表示关闭，为Enforcing表示开启
sestatus
```



# iso文件

> iso是一个镜像文件，通常是光盘或 DVD 的镜像文件，一个iso文件可以在虚拟机中创建多个不同的linux系统。这很好理解，在现实中我们也会拿着光盘在多台电脑上安装操作系统，iso镜像文件就类似于这个光盘。因此当虚拟机安装好后就是一个独立的实例，删除iso文件是不会影响到虚拟机的正常运行的。