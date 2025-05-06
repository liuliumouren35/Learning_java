# demo1 Spring Boot 示例项目

这是一个简单的 Spring Boot Web 应用程序示例。

## 项目描述

该项目演示了如何使用 Spring Boot 构建一个基础的 Web 服务，包含 Controller 和 Service 层。

## 技术栈

*   Java 21
*   Spring Boot 3.4.4
*   Maven

## 主要功能

*   提供一个 `/listEmp` API 端点，用于获取员工列表数据。
*   数据处理逻辑封装在 `EmpService` 中。
*   使用 `EmpController` 处理 Web 请求。

## 如何运行

1.  确保你已安装 Java 21 和 Maven。
2.  在项目根目录 (`WebDay1/demo1`) 下运行 Maven 命令来构建和启动项目：
    ```bash
    ./mvnw spring-boot:run
    ```
    或者，如果你的系统上全局安装了 Maven：
    ```bash
    mvn spring-boot:run
    ```
3.  项目启动后，可以通过访问 `http://localhost:8080/listEmp` (默认端口为 8080) 来获取员工列表。

## 项目结构

```
demo1/
├── pom.xml             # Maven 项目配置文件
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── example/
│   │   │       └── demo1/
│   │   │           ├── Demo1Application.java  # Spring Boot 启动类
│   │   │           ├── Controller/
│   │   │           │   └── EmpController.java # 控制器，处理 /listEmp 请求
│   │   │           ├── service/
│   │   │           │   └── EmpService.java    # 服务层，处理业务逻辑 (需要你创建和实现)
│   │   │           └── pojo/
│   │   │               ├── Emp.java           # 员工数据对象
│   │   │               └── Result.java        # API 响应结果封装
│   │   └── resources/
│   │       ├── application.properties # Spring Boot 配置文件
│   │       └── emp.xml                # (如果 EmpService 仍使用) 员工数据文件
│   └── test/
│       └── java/
│           └── ...                    # 测试代码
├── .gitignore
├── mvnw                # Maven Wrapper (Linux/macOS)
├── mvnw.cmd            # Maven Wrapper (Windows)
└── README.md           # 本文件
```

*(请注意：`EmpService` 的具体实现和数据来源需要根据你的实际代码来确定)* 