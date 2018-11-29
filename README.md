# IP查询插件

- 基于阿里云云市场开发的ip信息获取插件，适用于spring boot环境


- 使用说明
    - 用户需要在阿里云市场购买相应的产品
    - maven导入项目
        ```xml
        <dependency>
            <groupId>com.banhujiu.utils</groupId>
            <artifactId>ipinfo</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        ```
    - 使用配置
        ```properties
        ip.info.aliyun.app-code=[you self appcode]
        ip.info.aliyun.debug=false #是否打印日志，默认false
        ```
