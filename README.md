# Spring项目说明

## 简介
一个简单的SSM项目配置，简单的分层架构与统一返回类型。  

pom添加了相关Spring依赖与log4j依赖，配置了打包的规则，规定项目启动使用的环境配置文件。

```yaml
你可以直接下载后进行快速的整合为一个项目
```

## resource目录
dev：开发环境spring配置与jdbc配置  

test：测试环境spring配置与jdbc配置  

product：生产环境spring配置与jdbc配置  

mapper：放置了MybatisGenertor生成的xml

## pom配置
packaging：指定打成war包的形式  

build.finalName：指定打包生成的名字  

build.resources：指定使用maven启动时编译的resource配置文件目录，配合profiles.profile使用。  

plugins.plugin.tomcat7：指定了tomcat，使用maven启动时指定了服务的端口号，和项目的编码

## java目录介绍
common：常用工具类与通用代码        

component：一些组件，如log接口切面日志        

config：一些配置类     

controller： web接口层   

dao：与数据库交互层  

model：mysql表数据模型与查询example查询类  

service：逻辑处理层