# 处理交换文件

当vi编辑器非正常退出时会生成交换文件

第1个会话使用vi编辑f1，直接结束会话1是非正常退出

![image-20230704153347677](C:\Users\asus\Desktop\assets\image-20230704153347677.png) 

再次打开f1，生成交换文件.f1.swp

![image-20230704153659560](C:\Users\asus\Desktop\assets\image-20230704153659560.png)  

# 解决

.f1.swp是一个隐藏文件，用a将隐藏文件显示出来，删除这个隐藏文件即可

![image-20230704153902124](C:\Users\asus\Desktop\assets\image-20230704153902124.png) 

