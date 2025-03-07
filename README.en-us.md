English | [简体中文](./README.md)

<p align="center" >
    <a href="https://www.fizzgate.com"><img src="https://raw.githubusercontent.com/wiki/wehotel/fizz-gateway-community/img/icon-color.png" width="70%"></a>
</p>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-2.7.0-blue.svg?cacheSeconds=2592000" />
  <a href="http://www.fizzgate.com/fizz-gateway-community/" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: GPL--3.0" src="https://img.shields.io/badge/License-GPL--3.0-yellow.svg" />
  </a>
  <a href="https://github.com/wehotel/fizz-gateway-community/actions" target="_blank">
    <img alt="Java CI with Maven" src="https://github.com/wehotel/fizz-gateway-community/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master" />
  </a>
</p>

- **latest QQ group**: 512164278

## What 's Fizz Gateway？

An Aggregation API Gateway in Java . Fizz Gateway is a Java-based microservice gateway that can realize hot service aggregation, automatic authorization selection, online service script coding, online testing, high-performance routing, API audit management and other purposes. It has a powerful The custom plug-in system can be extended by youself, and provides a friendly graphical configuration interface, which can quickly help enterprises to manage API services, reduce middle layer glue code, reduce coding investment, and improve the stability and security of API services.


## Demo

http://demo.fizzgate.com/

account/password:`admin`/`Aa123!`

health checking url：http://demo.fizzgate.com/admin/health

API access：http://demo.fizzgate.com/proxy/[Service Name]/[API Path]

## Fizz's Design

<img width="500" src="https://user-images.githubusercontent.com/184315/97130741-33a90d80-177d-11eb-8680-f589a36e44b3.png" />

## Fizz's typical scene

<img width="90%" src="https://raw.githubusercontent.com/wiki/wehotel/fizz-gateway-community/img/scene.png" />

## Product Features

- Cluster management: Fizz gateway nodes are stateless with configuration information that is automatically synchronized, and horizontal expansion of nodes and multi-cluster deployment are supported.
- Service aggregation: supports hot http/dubbo/grpc service aggregation capabilities, support front-end and back-end coding, and update API anytime and anywhere;
- Load balancing: supports round-robin load balancing;
- Multiple Registration Center: supports discovery of back-end servers from the Eureka or Nacos registry;
- Configuration center: supports access to apollo configuration center;
- HTTP reverse proxy: hide the real back-end services and support Rest API reverse proxy;
- Access strategy: support different strategies to access different APIs, configure different authentication, etc;
- IP black and white list: support the configuration of IP black and white list;
- Custom plug-in: powerful plug-in mechanism supports free expansion;
- Extensible: the easy-to-use plug-in mechanism facilitates the expansion of functions;
- High performance: the performance is excellent among many gateways;
- Version control: support release and multiple rollbacks of operations;
- Management backend: configure the gateway cluster through the management backend interface;
- Callback Managerment：supports managerment、subscription、replay and logging of callback;
- Multistage traffic limit：supports multisate traffic limit of fine-grain parallelism, according to service、interface、APP_ID or ip; 
- Microservice document:open microservice document management of enterprise level, and more convenient system integration;
- Public network dedicated line：supports establishing a fully protected private connection channel in the public network;
- Policy fusing: multiple recovery policy fusing configurations are made according to the service or specific address.

## Benchmarks

We compare FIZZ with the major gateway products on the market, using the same environment and conditions, and the test objects are under single node. The Mock interface simulates a 20ms latency with a packet size of about 2K.

- Intel(R) Xeon(R) CPU E5-2650 v3 @ 2.30GHz * 4
- Linux version 3.10.0-957.21.3.el7.x86_64
- 8G RAM

|  Category  |  Product name  | QPS of <br/>600 connections | 90% Latency(ms) of <br/>600 connections | QPS of <br/>1000 connections | 90% Latency(ms) of <br/>1000 connections |
| :------------------ | :------------------ | :-------: | :-------: | :-------: | :-------: |
| Backend Service |    direct access    | 23540| 32.19 | 27325| 52.09 |
| Traffic Gateway | kong <br/>v2.4.1 | 15662 | 50.87 | 17152 | 84.3 |
| Application Gateway | fizz-gateway-community <br/>v2.0.0 | 12206 | 65.76 | 12766 | 100.34 |
| Application Gateway | spring-cloud-gateway <br/>v2.2.9 | 11323 | 68.57 | 10472 | 127.59 |
| Application Gateway | shenyu <br/>v2.3.0 | 9284 | 92.98 | 9939 | 148.61 |


## Version comparison

- Fizz-gateway-community： Community Edition

- Fizz-manager-professional：Management backend professional version (backend)

- Fizz-admin-professional：Management backend professional version (frontend)

| Fizz-gateway-community | Fizz-manager-professional | Fizz-admin-professional |
| ---------------------- | ------------------------- | ----------------------- |
| v1.0.0                 | v1.0.0                    | v1.0.0                  |
| v1.1.0                 | v1.1.0                    | v1.1.0                  |
| v1.1.1                 | v1.1.1                    | v1.1.1                  |
| v1.2.0                 | v1.2.0                    | v1.2.0                  |

Starting from v1.3.0, the frontend and backend of the management backend are merged into one package

- Fizz-gateway-community： Community Edition

- Fizz-manager-professional：Management backend professional version

| Fizz-gateway-community | Fizz-manager-professional |
|------------------------|---------------------------|
| v1.3.0                 | v1.3.0                    |
| v1.4.0                 | v1.4.0                    |
| v1.4.1                 | v1.4.1                    |
| v1.5.0                 | v1.5.0                    |
| v1.5.1                 | v1.5.1                    |
| v2.0.0                 | v2.0.0                    |
| v2.1.0                 | v2.1.0                    |
| v2.2.0                 | v2.2.0                    |
| v2.2.1                 | v2.2.1                    |
| v2.2.3                 | v2.2.3                    |
| v2.3.0                 | v2.3.0                    |
| v2.3.2                 | v2.3.2                    |
| v2.3.3                 | v2.3.3                    |
| v2.4.0                 | v2.4.0                    |
| v2.4.1                 | v2.4.1                    |
| v2.5.0                 | v2.5.0                    |
| v2.5.1                 | v2.5.1                    |
| v2.5.2                 | v2.5.2                    |
| v2.6.0                 | v2.6.0                    |
| v2.6.1                 | v2.6.1                    |
| v2.6.2                 | v2.6.2                    |
| v2.6.3                 | v2.6.3                    |
| v2.6.4                 | v2.6.4                    |
| v2.6.5                 | v2.6.5                    |
| v2.6.6                 | v2.6.6                    |
| v2.7.0                 | v2.7.0                    |


Please download the corresponding management backend version according to the version of the community version

## Deployment instructions

[Detailed deployment tutorial>>>](http://www.fizzgate.com/guide/installation/) 

### Installation dependencies

Install the following dependent software:

-Redis 2.8 or above
-MySQL 5.7 or above
-Apollo Configuration Center (optional)
-Nacos or Eureka Service Registry (optional)

Dependent installation can refer to detailed deployment tutorial

### Install Fizz

#### 一、Install management backend

Download the fizz-manager-professional installation package from github's releases (https://wj.qq.com/s2/8682608/8fe2/)

##### Management backend (fizz-manager-professional)

Description:

1. The `{version}` that appears in the following installation steps represents the version number of the management backend used, such as `1.3.0`.

installation method 1: binary package:

1. Unzip the `fizz-manager-professional-{version}.zip` installation package
2. For the first installation, execute the `fizz-manager-professional-{version}-mysql.sql` database script, upgrade from a low version to a high version, and choose to execute the corresponding upgrade script in the update directory
3. Modify the `application-prod.yml` file, and modify the relevant configuration to the configuration of the deployment environment
4. Linux startup Execute the `chmod +x boot.sh` command to increase the execution authority of `boot.sh`; execute the `./boot.sh start` command to start the service, support start/stop/restart/status commands
5. Windows startup Execute `.\boot.cmd start` command to start the service, support start/stop/restart/status command

Installation method 2: docker:

1. Download docker image：docker pull fizzgate/fizz-manager-professional:{version}
2. Modify Redis & database configuration by env parameters and run with below docker command
```sh
docker run --rm -d -p 8000:8000 \
-e "spring.redis.host={your redis host IP}" \
-e "spring.redis.port={your redis port}" \
-e "spring.redis.password={your redis password}" \
-e "spring.redis.database={your redis database}" \
-e "spring.datasource.url=jdbc:mysql://{your MySQL database host IP}:3306/fizz_manager?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true" \
-e "spring.datasource.username={your MySQL database username}" \
-e "spring.datasource.password={your MySQL database password}" \
fizzgate/fizz-manager-professional:{version}
```

or using external configuration file and output log to host server by mount volume, configuration file could be achieved from binary package, create fizz-manager-professional/config and fizz-manager-professional/logs directories in host server, place application-prod.yml configuration files to config folder, run with below docker command in fizz-manager-professional folder:

```sh
cd fizz-manager-professional
docker run --rm -d -p 8000:8000 \
-v $PWD/config:/opt/fizz-manager-professional/config \
-v $PWD/logs:/opt/fizz-manager-professional/logs fizzgate/fizz-manager-professional:{version}
```

After the service is started, visit http://{deployment machine IP address}:8000/#/login, and log in with the super administrator account `admin` password `Aa123!`

#### 二、Install fizz-gateway-community community edition

Description:

1. Support configuration center: apollo, nacos, support registration center: eureka, nacos.refer to application.yml file with more detailed configurations.
2. If you use the apollo configuration center, you can move the content of the application.yml file to the configuration center (the application name on apollo is: fizz-gateway); if you don't use apollo, you can remove the apollo parameter in the startup command below.
3. The `{version}` that appears in the following installation steps represents the version number of the gateway used, such as `1.3.0`.

Installation method 1: binary package:

1. Download the latest binary package of fizz-gateway-community and upzip to a directory, modify the configuration of the configuration center, registry, and redis in the application.yml configuration file (redis configuration needs to be consistent with the management backend).
2. Modify the apollo connection and JVM memory configuration of the boot.sh script
3. Linux startup Execute `./boot.sh start` command to start the service, support start/stop/restart/status command
4. Windows startup Execute `.\boot.cmd start` command to start the service, support start/stop/restart/status command

Installation method 2: source code:

1. The latest code on the local clone warehouse, modify the configuration of the configuration center, registry, and redis in the application.yml configuration file (redis configuration needs to be consistent with the management backend)
2. Execute the Maven command `mvn clean package install -DskipTests=true` package in the project root directory fizz-gateway-community
3. Execute the Maven command `mvn clean package -DskipTests=true` package in the project directory fizz-gateway-community/fizz-bootstrap
4. Enter fizz-gateway-community/fizz-bootstrap/target/fizz-gateway-community directory and Execute `./boot.sh start` command to start the service, support start/stop/restart/status command

Installation method 3: docker:

1. Download docker image：docker pull fizzgate/fizz-gateway-community:{version}
2. Modify Redis configuration by env parameters and run with below docker command
```sh
docker run --rm -d -p 8600:8600 \
-e "aggregate.redis.host={your redis host IP}" \
-e "aggregate.redis.port={your redis port}" \
-e "aggregate.redis.password={your redis password}" \
-e "aggregate.redis.database={your redis database}" \
fizzgate/fizz-gateway-community:{version}
```

or using external configuration file and output log to host server by mount volume, configuration file could be achieved from source code or binary package, create fizz-gateway-community/config and fizz-gateway-community/logs directories in host server, place application.yml and log4j2-spring.xml configuration files to config folder, run with below docker command in fizz-gateway-community folder:

```sh
cd fizz-gateway-community
docker run --rm -d -p 8600:8600 \
-v $PWD/config:/opt/fizz-gateway-community/config \
-v $PWD/logs:/opt/fizz-gateway-community/logs fizzgate/fizz-gateway-community:{version}
```

Finally visit the gateway, the address format is: http://127.0.0.1:8600/proxy/[Service name]/[API Path]

## Official technical exchange group

Fizz官方技术交流①群（已满）

Fizz官方技术交流②群（已满）

Fizz官方技术交流③群：512164278

<img width="250" src="https://user-images.githubusercontent.com/184315/97130743-3572d100-177d-11eb-97c8-7599a22c7c04.png" />

## Related acticles

[服务器减少50%，研发效率提高86%，我们的管理型网关Fizz自研之路](https://www.infoq.cn/article/9wdfiOILJ0CYsVyBQFpl)

[简单易用的微服务聚合网关首选：Fizz Gateway安装教程](https://my.oschina.net/linwaiwai/blog/4696224)

[大厂推荐使用的网关解密：Fizz Gateway管理后台使用教程](https://my.oschina.net/linwaiwai/blog/4696124)

[架构师效率快的终极原因：Fizz Gateway网关之服务编排](https://my.oschina.net/linwaiwai/blog/4696116)

[高阶架构师支招：Fizz Gateway的插件开发](https://my.oschina.net/linwaiwai/blog/4696131)

[高阶程序员必备技能：Fizz Gateway网关的二次开发](https://my.oschina.net/linwaiwai/blog/4696133)

[Fizz网关入门教程-安装](https://zhuanlan.zhihu.com/p/501305059)

[Fizz网关入门教程-路由初体验](https://zhuanlan.zhihu.com/p/501381970)

[Fizz网关入门教程-权限校验](https://zhuanlan.zhihu.com/p/501384396)

[Fizz网关入门教程-快速聚合多接口，提高页面数据的加载速度](https://zhuanlan.zhihu.com/p/501387154)

[Fizz网关入门教程-服务编排，祭出终结BFF层的大杀器](https://zhuanlan.zhihu.com/p/501389075)

[企业级微服务API网关Fizz-常用插件介绍](https://zhuanlan.zhihu.com/p/513656382)

[企业级微服务API网关Fizz-如何自定义插件](https://zhuanlan.zhihu.com/p/513662893)

[企业级微服务API网关Fizz-服务编排内置函数](https://zhuanlan.zhihu.com/p/513404417)

[Fizz企业级微服务API网关进阶系列教程-服务编排处理列表数据(上)-展开与合并](https://zhuanlan.zhihu.com/p/515056309)

[Fizz企业级微服务API网关进阶系列教程-服务编排处理列表数据(中)-数据提取与数据关联](https://zhuanlan.zhihu.com/p/515070075)

[Fizz企业级微服务API网关进阶系列教程-服务编排处理列表数据(下)-字段重命名&字段移除](https://zhuanlan.zhihu.com/p/515509832)

## Authorization instructions

1. The fizz-gateway-community community version of the gateway core project is opened in the form of GNU V3 and can be used free of charge in non-commercial projects following the GNU protocol.

2. Management backend projects (fizz-manager-professional) as commercial versions only open binary packages [free download](https://wj.qq.com/s2/8682608/8fe2/), and For commercial projects, please contact us (sale@fizzgate.com) for authorization.

## System screenshot

![homepage](https://user-images.githubusercontent.com/6129661/156333191-1b9901f5-e086-4514-84f0-4a74684fdf2d.png)

![aggr1](https://user-images.githubusercontent.com/6129661/156333163-e2aade71-081c-49f0-9c7b-deb19239be84.png)

![aggr2](https://user-images.githubusercontent.com/6129661/156333175-770ac66d-0295-43b1-948a-a91d9a1922dd.png)

![route](https://user-images.githubusercontent.com/6129661/156333194-9a4051a8-c59c-493f-8dd9-f004c364b8c4.png)

![plugin](https://user-images.githubusercontent.com/6129661/156333193-b0bdfae3-4660-42a0-93e3-118333c5b246.png)

![appid](https://user-images.githubusercontent.com/6129661/156333180-55d4167b-1eba-4fde-900d-6499f971b97f.png)

![breaker](https://user-images.githubusercontent.com/6129661/156333182-40986e36-0f80-46b7-aced-1c16406ba2ce.png)

![flowcontrol](https://user-images.githubusercontent.com/6129661/156333189-0b209c2b-5026-4a6e-9880-9fc08ee72077.png)

![doc](https://user-images.githubusercontent.com/6129661/156333188-6a2dae42-24b2-48c6-b401-1b6bbd9f6030.png)
