# 下载

> 在/usr/local/下创建一个nodejs目录

```shell
mkdir /usr/local/nodejs
# 在nodejs目录下下载
wget https://nodejs.org/dist/v12.14.0/node-v12.14.0-darwin-x64.tar.gz
```



# 解压

```shell
tar -zxvf node-v12.14.0-darwin-x64.tar.gz
# 改名
mv node-v12.14.0-darwin-x64/* nodejs
```



# 建立软连接

> 此时的bin文件夹中已经存在node以及npm，如果进入到对应文件的中执行命令行一点问题都没有，不过不是全局的，所以通过建立软链接的方式将这个设置为全局

```shell
ln -s /usr/local/nodejs/bin/node /usr/local/bin
ln -s /usr/local/nodejs/bin/npm /usr/local/bin
```



# 查看版本号

```shell
node -v
npm -v
```

