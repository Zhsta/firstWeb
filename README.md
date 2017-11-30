# 简介
这是一个简单的教务管理系统网站
# 使用技术
IoC容器:spring

web框架:springmvc

orm框架:mybatis

数据源:dbcp2

前端框架:Bootstrap

IDE：Intellij Idea
# 起步
1.初始化项目

1)下载Mysql,创建一个数据库名字为web,导入sql文件

2)下载Tomcat

3)使用Intellij Idea导入项目,之后配置项目启动方式,使用刚才下载好的Tomcat

4)运行
# 使用介绍
首先导入web.sql， 在springmvc中连接好数据库，在注册界面选择注册管理员账户，进行登录。

在管理员账户，创建学生老师以及课程信息

# 表结构设计
![image](https://github.com/Zhsta/firstWeb/raw/master/img/24.gif)
# 功能简介
## 登录和注册面板
检测输入的用户名，密码是否正确，是否存在于黑名单中，以及在开放游客学生和游客老师的注册）
#### 登录界面
![image](https://github.com/Zhsta/firstWeb/raw/master/img/1.png)
#### 注册界面
![image](https://github.com/Zhsta/firstWeb/raw/master/img/2.png)
## 学生面板
查询自己的个人基本信息，选课，退课，查询成绩，查询课程组成
#### 学生面板主页
![image](https://github.com/Zhsta/firstWeb/raw/master/img/3.png)
#### 课程选择页面（可通过管理员账户添加课程）
![image](https://github.com/Zhsta/firstWeb/raw/master/img/4.png)
![image](https://github.com/Zhsta/firstWeb/raw/master/img/5.png)
#### 成绩查询页面，两个下拉菜单有不同的内容
![image](https://github.com/Zhsta/firstWeb/raw/master/img/6.png)
![image](https://github.com/Zhsta/firstWeb/raw/master/img/7.png)
![image](https://github.com/Zhsta/firstWeb/raw/master/img/8.png)
## 老师面板
查询老师的个人基本信息，能看到自己所上的全部课程，能管理选择他的课程的学生（主要分为给该学生打分和强制让学生退课），可以查询选择他的课的学生的一些信
息
#### 老师的个人信息面板，可点击查看
![image](https://github.com/Zhsta/firstWeb/raw/master/img/9.png)
#### 查看自己所教授的课程，并可以通过学生列表查看对应课程的全部学生
![image](https://github.com/Zhsta/firstWeb/raw/master/img/10.png)

由学生列表所进入的面板，如果该学生已经打分则显示成绩，否则显示打分超链,如果输入负数则提示打入正分，但并无上限
![image](https://github.com/Zhsta/firstWeb/raw/master/img/11.png)
![image](https://github.com/Zhsta/firstWeb/raw/master/img/12.png)

点击打分按钮所弹出的打分悬浮框，如果输入的数字不和规定，则报错
![image](https://github.com/Zhsta/firstWeb/raw/master/img/13.png)
![image](https://github.com/Zhsta/firstWeb/raw/master/img/14.png)

最后的搜索学生面板
![image](https://github.com/Zhsta/firstWeb/raw/master/img/15.png)

搜索的学生并未选择此老师的课程时报错
![image](https://github.com/Zhsta/firstWeb/raw/master/img/16.png)

如果学生存在
![image](https://github.com/Zhsta/firstWeb/raw/master/img/17.png)

## 管理员面板
分为学生管理，能添加，删除，更新，查询真正的学生，老师，课程以及黑名单的管理
![image](https://github.com/Zhsta/firstWeb/raw/master/img/18.png)


搜索成功之后的页面，每一个按钮都能点击查看所搜索学生的信息，点击重新搜索则回到上面的搜索页面，账户不存在则不会有任何反应
![image](https://github.com/Zhsta/firstWeb/raw/master/img/19.png)
![image](https://github.com/Zhsta/firstWeb/raw/master/img/20.png)

增添账户页面，在管理员页面添加的老师学生账户才能对基本信息进行操作，开始的注册页面不行
![image](https://github.com/Zhsta/firstWeb/raw/master/img/21.png)

同样可以删除学生账户
![image](https://github.com/Zhsta/firstWeb/raw/master/img/22.png)

更新学生页面分为更新和添加，更新会覆盖以前的属性
![image](https://github.com/Zhsta/firstWeb/raw/master/img/23.png)


其余页面类似
