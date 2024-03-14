# 部署运行

## 基础环境

- JDK:17
- springboot:3.2.3


## 安装

### Docker
```shell
docker run -p 6379:6379 -d redislabs/redisearch:latest
```

### 验证
redis连接后
```shell
module list
```

