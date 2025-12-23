# ChainUp Custody Java SDK - 项目文档

## 项目概述

**项目名称**: waas-sdk  
**版本**: 2.1.1  
**描述**: ChainUp WaaS (Wallet as a Service) 客户端 Java SDK  
**官网**: https://waas.chainup.com/  
**仓库**: https://github.com/HiCoinCom/java-sdk  
**许可证**: Apache License 2.0  

## 项目简介

ChainUp Custody Java SDK 是一个用于与 ChainUp 托管服务交互的 Java 客户端库。该 SDK 提供了两种主要的客户端类型：
1. **WaaS Client**: 传统托管钱包服务客户端
2. **MPC Client**: 多方计算（Multi-Party Computation）钱包服务客户端

---

## 核心功能

### WaaS 客户端功能
- **用户管理**: 注册用户、查询用户信息
- **账户管理**: 查询商户账户余额、用户账户余额、用户充值地址
- **充值提现**: 提现操作、同步充值/提现记录、批量查询记录
- **币种管理**: 获取支持的币种列表
- **转账功能**: 账户间转账、查询转账记录
- **异步通知**: 处理充值/提现通知、二次验证

### MPC 客户端功能
- **工作空间管理**: 管理 MPC 工作空间
- **钱包管理**: 创建钱包、创建钱包地址
- **充值管理**: 充值记录查询和同步
- **提现管理**: 发起提现、查询提现记录
- **Web3 功能**: Web3 交易支持
- **自动归集**: 自动归集资金
- **通知服务**: 处理各类异步通知
- **Tron 资源**: 购买 Tron 网络资源

---

## 技术栈

### 构建工具
- **Maven**: 项目构建和依赖管理
- **Java 版本**: JDK 11

### 核心依赖库
| 依赖 | 版本 | 用途 |
|------|------|------|
| slf4j-api | 2.0.16 | 日志门面 |
| commons-lang3 | 3.17.0 | 通用工具类 |
| httpclient5 | 5.4.1 | HTTP 客户端 |
| commons-codec | 1.8 | 编码解码工具 |
| fastjson | 2.0.53 | JSON 处理 |
| junit-jupiter-api | 5.11.3 | 单元测试 (测试环境) |
| junit | 4.12 | 单元测试 (测试环境) |

---

## 项目架构

### 整体架构设计

```
┌─────────────────────────────────────────────────────────────┐
│                      客户端应用层                              │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                   SDK 客户端入口层                             │
│  ┌──────────────────┐        ┌──────────────────┐           │
│  │  WaasClient      │        │   MpcClient      │           │
│  └──────────────────┘        └──────────────────┘           │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    工厂模式层                                  │
│                  WaasClientFactory                           │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    API 接口层                                 │
│  WaaS APIs          │         MPC APIs                      │
│  • IAccountApi      │         • IWorkSpaceApi               │
│  • IUserApi         │         • IWalletApi                  │
│  • IBillingApi      │         • IDepositApi                 │
│  • ICoinApi         │         • IWithdrawApi                │
│  • ITransferApi     │         • IWeb3Api                    │
│  • IAsyncNotifyApi  │         • IAutoSweepApi               │
│                     │         • INotifyApi                  │
│                     │         • ITronBuyResourceApi         │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    基础服务层                                  │
│  ┌──────────────────┐  ┌──────────────────┐                │
│  │  WaasApi         │  │  DataCrypto      │                │
│  │  (基础API调用)    │  │  (RSA加密解密)    │                │
│  └──────────────────┘  └──────────────────┘                │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    工具类层                                    │
│  • HttpClientUtil (HTTP通信)                                 │
│  • Md5Util (MD5签名)                                         │
│  • MpcSignUtil (MPC签名)                                     │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                  ChainUp API 服务端                           │
└─────────────────────────────────────────────────────────────┘
```

### 目录结构

```
src/main/java/com/github/hicoincom/
├── WaasClient.java              # WaaS客户端主类
├── MpcClient.java               # MPC客户端主类
├── WaasConfig.java              # WaaS配置类
├── MpcConfig.java               # MPC配置类 (继承WaasConfig)
├── WaasClientFactory.java       # 客户端工厂类
│
├── api/                         # API接口层
│   ├── WaasApi.java            # 基础API抽象类
│   │
│   ├── waas/                   # WaaS API接口
│   │   ├── IAccountApi.java   # 账户API接口
│   │   ├── IUserApi.java      # 用户API接口
│   │   ├── IBillingApi.java   # 充值提现API接口
│   │   ├── ICoinApi.java      # 币种API接口
│   │   ├── ITransferApi.java  # 转账API接口
│   │   ├── IAsyncNotifyApi.java # 异步通知API接口
│   │   └── impl/              # 实现类
│   │
│   ├── mpc/                    # MPC API接口
│   │   ├── IWorkSpaceApi.java  # 工作空间API接口
│   │   ├── IWalletApi.java     # 钱包API接口
│   │   ├── IDepositApi.java    # 充值API接口
│   │   ├── IWithdrawApi.java   # 提现API接口
│   │   ├── IWeb3Api.java       # Web3 API接口
│   │   ├── IAutoSweepApi.java  # 自动归集API接口
│   │   ├── INotifyApi.java     # 通知API接口
│   │   ├── ITronBuyResourceApi.java # Tron资源API接口
│   │   └── impl/               # 实现类
│   │
│   └── bean/                   # 数据模型
│       ├── waas/               # WaaS数据模型
│       └── mpc/                # MPC数据模型
│
├── crypto/                     # 加密解密模块
│   ├── IDataCrypto.java       # 加密接口
│   ├── DataCrypto.java        # 加密实现类
│   └── rsa/                   # RSA加密相关
│
├── enums/                      # 枚举类
│   ├── ApiUri.java            # WaaS API URI枚举
│   ├── MpcApiUri.java         # MPC API URI枚举
│   ├── AppShowStatus.java     # 应用显示状态
│   ├── AsyncNotifyType.java   # 异步通知类型
│   ├── DepositStatus.java     # 充值状态
│   ├── WithdrawStatus.java    # 提现状态
│   └── MinerFeeStatus.java    # 矿工费状态
│
├── exception/                  # 异常类
│   └── CryptoException.java   # 加密异常
│
└── util/                       # 工具类
    ├── HttpClientUtil.java    # HTTP客户端工具
    ├── Md5Util.java           # MD5工具
    └── MpcSignUtil.java       # MPC签名工具
```

---

## 设计模式

### 1. 工厂模式 (Factory Pattern)
**类**: `WaasClientFactory`

用于创建 WaasClient 和 MpcClient 实例，封装了复杂的对象创建逻辑。

```java
// 创建 WaaS 客户端
WaasClient client = WaasClientFactory.CreateClient(cfg);

// 创建 MPC 客户端
MpcClient mpcClient = WaasClientFactory.CreateMpcClient(mpcCfg);
```

### 2. 建造者模式 (Builder Pattern)
**类**: `WaasClient.WaasClientBuilder`, `MpcClient.MpcClientBuilder`

用于灵活地构建客户端对象，支持链式调用。

```java
WaasClient client = WaasClient.WaasClientBuilder.builder()
    .accountApi(new AccountApi(cfg, crypto))
    .userApi(new UserApi(cfg, crypto))
    .billingApi(new BillingApi(cfg, crypto))
    // ...
    .build();
```

### 3. 策略模式 (Strategy Pattern)
**接口**: `IDataCrypto`

通过接口定义加密策略，允许不同的加密实现。

### 4. 门面模式 (Facade Pattern)
**类**: `WaasClient`, `MpcClient`

提供统一的高层接口，简化子系统的使用。

---

## 核心类说明

### 配置类

#### WaasConfig
WaaS 服务的基础配置类

**核心属性**:
- `appId`: 应用ID
- `userPrivateKey`: 商户 RSA 私钥
- `waasPublickKey`: ChainUp 提供的 RSA 公钥
- `domain`: API 域名 (默认: https://openapi.chainup.com/api/v2)
- `version`: API 版本 (默认: v2)
- `charset`: 字符编码 (默认: utf-8)
- `enableLog`: 是否启用日志

#### MpcConfig
MPC 服务配置类，继承自 WaasConfig

**额外属性**:
- `signPrivateKey`: 用于提现或创建 Web3 交易时加密参数的 RSA 私钥
- `domain`: API 域名 (默认: https://openapi.chainup.com)

### 客户端类

#### WaasClient
WaaS 服务的主客户端

**核心 API**:
- `accountApi`: 账户操作 API
- `userApi`: 用户操作 API
- `billingApi`: 充值提现 API
- `coinApi`: 币种操作 API
- `transferApi`: 转账操作 API
- `asyncNotifyApi`: 异步通知处理 API

#### MpcClient
MPC 服务的主客户端

**核心 API**:
- `workSpaceApi`: 工作空间管理 API
- `walletApi`: 钱包管理 API
- `depositApi`: 充值管理 API
- `withdrawApi`: 提现管理 API
- `web3Api`: Web3 交易 API
- `autoSweepApi`: 自动归集 API
- `notifyApi`: 通知处理 API
- `tronBuyResourceApi`: Tron 资源购买 API

---

## 安全机制

### 1. RSA 加密
- 使用 RSA 公私钥对进行数据加密和签名
- 商户使用私钥签名请求
- ChainUp 使用公钥验证签名
- ChainUp 使用公钥加密响应
- 商户使用私钥解密响应

### 2. 签名验证
- 所有 API 请求都需要签名
- 使用 MD5 或 RSA 签名机制
- 防止数据篡改和重放攻击

### 3. HTTPS 传输
- 所有通信使用 HTTPS 协议
- 保证数据传输安全

---

## API 分类

### WaaS API

#### 1. 用户管理 API (IUserApi)
- 注册邮箱用户
- 查询用户信息
- 用户绑定地址

#### 2. 账户管理 API (IAccountApi)
- 查询用户账户余额
- 查询用户充值地址
- 查询商户收款账户余额
- 查询地址信息

#### 3. 充值提现 API (IBillingApi)
- 发起提现
- 批量查询提现记录
- 同步提现记录
- 批量查询充值记录
- 同步充值记录
- 查询矿工费记录

#### 4. 币种管理 API (ICoinApi)
- 获取币种列表
- 查询币种信息

#### 5. 转账管理 API (ITransferApi)
- 账户转账
- 查询转账记录
- 同步转账记录

#### 6. 异步通知 API (IAsyncNotifyApi)
- 解密充值提现通知参数
- 解密二次验证参数
- 加密二次验证响应数据

### MPC API

#### 1. 工作空间 API (IWorkSpaceApi)
- 工作空间管理操作

#### 2. 钱包管理 API (IWalletApi)
- 创建钱包
- 创建钱包地址
- 查询钱包信息
- 查询钱包地址

#### 3. 充值管理 API (IDepositApi)
- 查询充值记录
- 同步充值记录

#### 4. 提现管理 API (IWithdrawApi)
- 发起提现
- 查询提现记录
- 同步提现记录

#### 5. Web3 API (IWeb3Api)
- 创建 Web3 交易
- 查询 Web3 交易
- 加速 Web3 交易

#### 6. 自动归集 API (IAutoSweepApi)
- 配置自动归集规则
- 查询归集记录

#### 7. 通知 API (INotifyApi)
- 处理各类异步通知回调

#### 8. Tron 资源 API (ITronBuyResourceApi)
- 购买 Tron 网络能量
- 购买 Tron 网络带宽

---

## 使用流程

### WaaS 客户端使用流程

```java
// 1. 配置初始化
WaasConfig cfg = new WaasConfig();
cfg.setAppId("your-app-id");
cfg.setUserPrivateKey("your-private-key");
cfg.setWaasPublickKey("waas-public-key");

// 2. 创建客户端
WaasClient client = WaasClientFactory.CreateClient(cfg);

// 3. 调用 API
// 注册用户
client.getUserApi().RegisterEmailUser("user@example.com");

// 查询余额
client.getAccountApi().GetUserAccount(userId, "ETH");

// 发起提现
WithdrawArgs args = new WithdrawArgs();
args.setAmount(BigDecimal.ONE);
args.setSymbol("USDT");
args.setFromUid(userId);
args.setRequestId("unique-request-id");
args.setToAddress("target-address");
client.getBillingApi().Withdraw(args);
```

### MPC 客户端使用流程

```java
// 1. 配置初始化
MpcConfig cfg = new MpcConfig();
cfg.setAppId("your-app-id");
cfg.setUserPrivateKey("your-private-key");
cfg.setWaasPublickKey("waas-public-key");
cfg.setSignPrivateKey("sign-private-key");

// 2. 创建客户端
MpcClient client = WaasClientFactory.CreateMpcClient(cfg);

// 3. 调用 API
// 创建钱包
client.getWalletApi().createWallet("My Wallet", AppShowStatus.SHOW);

// 创建钱包地址
client.getWalletApi().createWalletAddress(walletId, "ETH");

// 发起提现
// ... (调用相应 API)
```

---

## 数据流程

### 请求流程

```
客户端应用
    │
    ├─> 1. 创建请求参数 (Args)
    │
    ├─> 2. 调用 Client API 方法
    │        │
    │        ├─> 3. API 实现类处理
    │        │        │
    │        │        ├─> 4. WaasApi.invoke()
    │        │        │        │
    │        │        │        ├─> 5. 数据加密 (DataCrypto)
    │        │        │        │
    │        │        │        ├─> 6. 签名生成
    │        │        │        │
    │        │        │        ├─> 7. HTTP 请求 (HttpClientUtil)
    │        │        │        │
    │        │        │        └─> 8. 发送到 ChainUp API
    │        │        │
    │        │        └─> 9. 接收响应
    │        │                 │
    │        │                 ├─> 10. 验证签名
    │        │                 │
    │        │                 ├─> 11. 解密响应 (DataCrypto)
    │        │                 │
    │        │                 └─> 12. 反序列化为结果对象
    │        │
    │        └─> 13. 返回结果对象 (Result)
    │
    └─> 14. 处理结果
```

---

## 错误处理

### 异常类型
- `CryptoException`: 加密解密相关异常
- 其他业务异常通过返回结果中的状态码和消息体现

### 错误处理建议
1. 检查 API 返回结果的状态码
2. 捕获并处理 `CryptoException`
3. 记录详细的错误日志
4. 实现重试机制（针对网络错误）

---

## 日志配置

SDK 使用 SLF4J 作为日志门面，支持以下配置：

```java
// 启用日志
cfg.setEnableLog(true);

// 禁用日志
cfg.setEnableLog(false);
```

建议在生产环境配置 Logback 或 Log4j2 作为日志实现。

---

## Maven 集成

### 添加依赖

```xml
<dependency>
    <groupId>com.github.hicoincom</groupId>
    <artifactId>waas-sdk</artifactId>
    <version>2.1.1</version>
</dependency>
```

### 本地构建

```bash
mvn clean install -DskipTests=true
```

### 生成文档

```bash
mvn javadoc:javadoc
```

---

## 最佳实践

### 1. 配置管理
- 使用配置文件或环境变量管理敏感信息（私钥、AppId）
- 不要将私钥硬编码在代码中
- 不同环境使用不同的配置

### 2. 客户端重用
- 创建单例或线程池管理客户端实例
- 避免频繁创建和销毁客户端

### 3. 异常处理
- 捕获所有可能的异常
- 记录详细的错误信息
- 实现友好的错误提示

### 4. 幂等性
- 使用唯一的 `requestId` 确保操作幂等性
- 实现重试机制时注意幂等性

### 5. 安全性
- 定期轮换密钥
- 使用 HTTPS 传输
- 验证所有回调通知的签名

### 6. 性能优化
- 复用 HTTP 连接
- 批量查询代替单个查询
- 合理使用异步通知

---

## 版本历史

- **2.1.1**: 当前版本
- **2.0.2**: 之前版本（README 中提及）

---

## 支持与联系

- **官方网站**: https://waas.chainup.com/
- **API 文档**: https://custodydocs-en.chainup.com/
- **GitHub**: https://github.com/HiCoinCom/java-sdk
- **邮箱**: admin@chainup.com

---

## 附录

### 支持的币种
详见项目根目录下的 `coin-list.csv` 文件

### API 端点
- **WaaS API**: https://openapi.chainup.com/api/v2
- **MPC API**: https://openapi.chainup.com

### 编码规范
- Java 11 标准
- UTF-8 编码
- 遵循 Google Java Style Guide

---

## 许可证

Apache License 2.0

Copyright © ChainUp Custody

