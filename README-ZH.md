# Projekt\_Ohrigei

[EN](https://github.com/Iwakawa-Tech/Projekt_Ohrigei/blob/develop/README.md)|[简体中文](https://github.com/Iwakawa-Tech/Projekt_Ohrigei/blob/develop/README-ZH.md)

* 此项目基于Spring Boot框架构建。
* 此项目尝试解决学生组织举办会议的低效率问题。
* 此项目采用Java/Groovy为主要的开发语言。

## 如何使用

* 第一步 : `git clone git@github.com:Iwakawa\-Tech/Projekt\_Ohrigei.git.`
* 第二步 : 在IDEA中运行项目
* 第三步 : 运行位于SQL文件夹下的sql文件


## 项目结构


* 所有的Java/Groovy文件均放置在`src\main\java\edu.dlufl.ohrigei`下。
* 基于MVC模式，后端文件夹用途如下：

        1.config文件夹用于存储配置相关文件，如Spring Security所需的config文件。
        2.controller文件夹下存储controller，在此文件夹下分别有AdminController、UserController文件夹，
          以及IndexController和TestController（用于实验新功能）。
        3.dao文件夹用于存储各种dao文件，负责与mybatis xml文件交互。
        4.model文件夹用于存储各种实体类的文件。
        5.service文件夹用于存储各种Service文件，文件夹下又分为adminService和userService文件夹。
        6.util文件夹用于存储各种工具类。  
*  所有的前端相关的文件以及mybatis xml文件和sql文件均存放在`src\main\resources` 下。
*  `resources`下的文件夹用途如下：

        1.mapping文件夹用于存储全部Mybatis xml文件。
        2.sql文件夹用于存储数据库导出的sql文件，该文件应与最新的数据库保持一致。
        3.static文件夹用于存储全部的静态资源，如css文件，font文件，js文件等。
          应根据文件性质的不同放置于不同的文件夹下
        4.templates文件夹用于存储html文件，当前在templeates文件夹下将文件分为四类。
            I.属于应由管理员访问的html文件放置于admin文件夹下。
            II.属于全部用户均可访问或是尚处于开发调试阶段的html文件应放置于allUser文件夹下。
            III.属于错误处理页面的应放置于error文件夹下。
            IV.属于应由用户访问的html文件应放于user文件夹下。



## 命名规则


* 原则上本项目所有命名均需遵守`camelCase`命名规范。
* 应保证文件名/方法名由可理解的英文单词组成，需明确表明该文件/方法的用途等。
* 所有位于`controller/dao/service/mapping`文件夹下的文件，文件结尾应当与对应文件夹名称保持一致。
* `util`文件夹下的工具类文件名应当明确表示该工具类所能提供的功能。
* 处于开发调试阶段的位于allUser文件夹下的html文件，应当以test为开头.

     

