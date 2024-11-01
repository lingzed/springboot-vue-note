# 1 springboot配置项

下面记录的是yml配置文件中常用的配置项：

## 1.1 server配置项

```yml
server:
  servlet:
    context-path: /admin 	# 请求前缀
    session:
      timeout: PT60M		# session过期时间， 1h
  port: 8091				# 端口
```

## 1.2 错误页配置项

```yml
spring:
  mvc:
  	# 允许springboot在没有找到请求资源时不返回404，而是抛出异常NoHandlerFoundException
    throw-exception-if-no-handler-found: true
  web:
    resources:
      add-mappings: false 	# 关闭静态资源的自动映射
```

`spring.mvc.throw-exception-if-no-handler-found=true` 配置用于在没有找到请求的处理程序时抛出异常`NoHandlerFoundException`。默认情况下，如果请求路径没有对应的处理方法，sprongboot会返回 404 错误而不会抛出异常；通过启用此配置，可以让应用在没有处理程序时抛出异常，从而允许我们做进一步的异常处理。

`web.resources.add-mappings: false` 配置用于控制静态资源的自动映射。通常情况下，sprongboot会自动将 `classpath:/static`、`classpath:/public`、`classpath:/resources` 和 `classpath:/META-INF/resources` 下的文件映射到 `/` 路径，使这些资源能够被直接访问。

将此属性设置为 `false` 后，sprongboot将不会自动映射静态资源目录，即应用将不再直接提供静态资源的访问路径。前后端分离的项目可以考虑。

## 1.3 数据库配置项

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/database_name?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver
    hikari:
      pool-name: HikariCPDatasource
      minimum-idle: 5
      idle-timeout: 180000
      maximum-pool-size: 10
      auto-commit: true
      max-lifetime: 1800000
      connection-timeout: 30000
      connection-test-query: SELECT 1
```

使用时将database_name替换为实际的数据库名。

下面解释hikari连接池的配置项：

- `pool-name`：指定连接池的名称，在日志和监控中显示为 `HikariCPDatasource`，方便识别和管理。

- `minimum-idle`：最小空闲连接数。HikariCP 在不高于此数量时会维持一些空闲连接，确保在突然高负载时能快速响应。在这里设置为 5。

- `idle-timeout`：空闲连接的超时时间（单位：毫秒）。当连接超过此空闲时间（180 秒）且数量超过 `minimum-idle` 时，连接将会被释放。

- `maximum-pool-size`：连接池的最大连接数，设置为 10，决定了同时能处理的最大数据库连接数。

- `auto-commit`：是否开启自动提交，通常在简单查询中设置为 `true`，便于自动提交事务。

- `max-lifetime`：连接的最大生命周期（单位：毫秒）。设置为 1800 秒（30 分钟），在此时间后，连接将被关闭并替换，避免数据库长连接可能带来的问题。

- `connection-timeout`：获取连接的超时时间（单位：毫秒）。设置为 30 秒，超过此时间仍未获取到连接，将抛出异常，避免请求无限等待。

- `connection-test-query`：连接测试查询。这里设置为 `SELECT 1`，用于在应用重用连接之前测试其有效性。

以饭店来举例，饭店就是连接池：

- 最小空闲连接数：最多能招多少临时工。
- 空闲连接的超时时间：如果当临时工在指定时间内没有客户给他接待，那么饭店就解雇这个临时工(连接池释放空闲连接资源)。
- 最大连接数：整个饭店最多容纳的员工(临时工 + 正式工)。
- 连接的最大生命周期：如果一个员工在工作时花费的时间超过了指定的时间，饭店就会重新招人替换掉这个员工。

## 1.4 邮件配置项

```yml
spring:
  mail:
    host: smtp.qq.com                   			# SMTP 服务器地址
    port: 465                           			# 邮件服务器端口(465或587)
    default-encoding: UTF-8              			# 默认编码
    properties:
      mail:
        smtp:
          socketFactory:
            class: javax.net.ssl.SSLSocketFactory  	# 使用 SSL 连接
        debug: true                       			# 开启调试模式，可以查看邮件发送的详细日志
    username: test@qq.com
    password: 123									# 非密码，而是邮箱官网申请的授权码
```

## 1.5 管理员配置项

自定义配置。

```yml
# 管理员账户和密码
admin:
  account: admin
  password: 123456
```

## 1.6 日志配置项

```yml
log:
  root:
    level: debug # 日志级别
project:
    folder: d:/your/folder/path
```

自定义配置，这个配置项是针对于logback的xml文件的。springboot对logback的xml文件有专门的扩展，允许其在内部直接引入配置项的值，但是文件必须是logback-spring.xml，且只能在`<springProperty>`的`source`属性中使用，随便创建的xml文件没有这个功能。

下面是一个实例：

```xml
<!-- 引入 Spring Boot 配置文件中的log.root.level属性和project.folder属性 -->
<springProperty name="LOG_LEVEL" source="log.root.level"/>
<springProperty name="LOG_FOLDER" source="project.folder"/>
<!-- 其他标签则通过${}表达式，间接引入log.root.level和project.folder -->
<fileName>${LOG_FOLDER}</fileName>
<root level="${LOG_LEVEL}">
    <appender-ref ref="CONSOLE"/>
</root>
```

`project.folder`可以作为系统产生文件、用户上传文件等的统一存储目录。**需要提前建好。**

## 1.7 开发环境配置项

```yml
isDev: true # 是否开发环境
```



# 2 配置项完整版

```yml
server:
  servlet:
    context-path: /admin              # 请求前缀
    session:
      timeout: PT60M                  # session 过期时间，1小时
  port: 8091                          # 端口号

spring:
  mvc:
    # 未找到请求资源时不返回404，抛出 NoHandlerFoundException 异常
    throw-exception-if-no-handler-found: true
  web:
    resources:
      add-mappings: false             # 关闭静态资源自动映射

  datasource:
    url: jdbc:mysql://localhost:3306/database_name?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver
    hikari:
      pool-name: HikariCPDatasource
      minimum-idle: 5
      idle-timeout: 180000
      maximum-pool-size: 10
      auto-commit: true
      max-lifetime: 1800000
      connection-timeout: 30000
      connection-test-query: SELECT 1

  mail:
    host: smtp.qq.com                           # SMTP 服务器地址
    port: 465                                   # 邮件服务器端口 (465 或 587)
    default-encoding: UTF-8                     # 默认编码
    properties:
      mail:
        smtp:
          socketFactory:
            class: javax.net.ssl.SSLSocketFactory   # 使用 SSL 连接
        debug: true                               # 开启调试模式，查看邮件发送的详细日志
    username: test@qq.com
    password: 123                                 # 使用邮箱官网申请的授权码

# 管理员账户和密码
admin:
  account: admin
  password: 123456

# 日志配置
log:
  root:
    level: debug                                 # 日志级别

# 项目路径配置
project:
  folder: d:/your/folder/path                    # 项目文件路径

# 开发环境标识
isDev: true
```

