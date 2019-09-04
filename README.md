### grizzlybeerbuilder 
#### 简介
- 一个代码生成器
#### 使用方法
- clone项目到本地，修改index页面的js的访问地址 --!
- maven打成war包丢进tomcat，访问本地端口8109/{finalName}即可
#### 使用技术
- springboot mvc freemarker druid
- 生成流程使用了责任链、工厂、策略模式
- 解析输入SQL建表语句
- 根据模板生成文件
- 打成zip压缩包
- 下载流下载
