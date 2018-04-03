#### 使用手册

> resource-service-config.yaml 文件配置

- target: 项目绝对地址
- items 每个模块的基础配置
   - pkg: 项目的包路径
   - domain: 模块名称
   - primaryKeyField: 主键ID
   - uriPath: web请求路径
   
> mybatis-config.properties 配置

- target_project_path： 项目的绝对地址
- base_package: 项目包路径，与items.pkg一致