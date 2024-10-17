# 查看是否安装了mysql

```shell
rpm -qa | grep mysql
```



# 下载mysql安装包

```shell
# 使用wget通过url路径下载
# el7对应centos7，如果是centos8选择el8，mysql57是5.7版本
wget http://dev.mysql.com/get/mysql57-community-release-el7-10.noarch.rpm
```



# 安装mysql包

> 我安装在/opt目录下

```shell
yum -y install mysql57-community-release-el7-10.noarch.rpm
```



# 安装mysql

```shell
yum -y install mysql-community-server
```

> 如果报GPG错误，需要禁掉GPG验证检查

![image-20231113094453249](D:\text1\linux\assets\image-20231113094453249.png)

```shell
yum -y install mysql-community-server --nogpgcheck
```



# 启动mysql服务

```shell
systemctl start mysqld.service
```



# 查看mysql状态

```shell
service mysqld status
```

![image-20231113094803920](D:\text1\linux\assets\image-20231113094803920.png)



# 查看初始密码

```shell
grep 'password' /var/log/mysqld.log
```

![image-20231113095134157](D:\text1\linux\assets\image-20231113095134157.png)



# 连接mysql

```shell
mysql -u root -p
```

> 输入初始密码登录



# 设置密码

> 使用初始化密码登录后，执行sql语句会报错

![image-20231113095608026](D:\text1\linux\assets\image-20231113095608026.png)

> 这是因为你没有设置密码，需要先设置密码

```mysql
set password = password('123456');
```

> 但是报错：

![image-20231113113930760](D:\text1\linux\assets\image-20231113113930760.png)

> 这表示密码不符合规定，查看密码策略的定义规则

```mysql
show variables like 'validate_password%'
```

![image-20231113114156689](D:\text1\linux\assets\image-20231113114156689.png)

> 1. validate_password_check_user_name：是否检查密码中是否包含用户的名称，OFF关闭
> 2. validate_password_dictionary_file：指定一个密码字典文件的路径，用于检查密码是否出现在字典中，为空，表示没有指定字典文件路径
> 3. validate_password_length：指定密码的最小长度，8表示最小8位
> 4. validate_password_mixed_case_count：指定密码中必须包含的不同大小写字母的数量，1表示要求密码中至少包含1个大小写字母
> 5. validate_password_number_count：指定密码中必须包含的数字的数量，1表示要求密码中至少包含1个数字
> 6. validate_password_policy：指定密码策略的级别，MEDIUM，表示密码策略级别为中等强度，LOW是低等
> 7. validate_password_special_char_count：指定密码中必须包含的特殊字符的数量，1表示要求密码中至少包含1个特殊字符

```mysql
# 设置密码最小长度改为6
set global validate_password_legnth = 6;
# 设置密码策略级别为LOW
set global validate_password_policy = LOW;
# 设置密码不包含大小写字母
set global validate_password_mixed_case_count = 0;
# 设置密码不包含特殊字符
set global validate_password_special_char_count = 0
```

> 设置密码策略规则后，再次修改密码成功

![image-20231113120229602](D:\text1\linux\assets\image-20231113120229602.png)



# 远程连接

> 如果远程连接失败，可以将user表中User=root的这一行的Host字段的值改成通配符%

```mysql
update user set Host = '%' where User = 'root'; 
# 刷新
flush privileges;
```

![image-20231113134037893](D:\text1\linux\assets\image-20231113134037893.png)

> 远程连接成功

![image-20231113134108476](D:\text1\linux\assets\image-20231113134108476.png)
