# 下载sql server的源文件

```shell
curl -o /etc/yum.repos.d/mssql-server.repo https://packages.microsoft.com/config/rhel/7/mssql-server-2022.repo
```



# 查看repo文件

```shell
cat /etc/yum.repos.d/mssql-server.repo
```



# 安装sqlserver

```shell
yum install -y mssql-server
```



# 执行SQL Server初始化

```shell
/opt/mssql/bin/mssql-conf setup
```



# 查看状态

```shell
systemctl status mssql-server
```

> 出现active表示sqlserver已经安装就绪

![image-20231109170633752](D:\text1\linux\assets\image-20231109170633752.png)



# 安装SQL Server客户端工具

```shell
# 下载客户端工具yum源文件
curl -o /etc/yum.repos.d/msprod.repo https://packages.microsoft.com/config/rhel/7/prod.repo

# 安装sqlserver客户端工具
yum install -y mssql-tools unixODBC-devel
```



# 环境变量

```shell
echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bash_profile
echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc
source ~/.bashrc
which sqlcmd
```



# 登录

```shell
sqlcmd -S localhost -U sa -p

# 测试，出现Microsoft SQL Server 2019即成功
select @@version
go
```



# 远程访问

> 请开放sqlserver的1433端口，或者直接关闭linux的防火墙
