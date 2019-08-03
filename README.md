* 创建数据库的语句：
```$xslt
CREATE DATABASE IF NOT EXISTS test_service DEFAULT CHARACTER SET utf8mb4;
```
* 初始化数据，先要有表才能将execl放入执行初始化的语句
* 然后执行init-local-database.sh初始化数据库
* 我的数据库插入数据连的本地的数据库

* 查询iam服务的组织的curl:
curl 'http://localhost:8080/study-service/v1/organizations/1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer af0a18f3-faae-4ea1-8fef-5ac939f8cfbd"

* 本地提供的组织查询curl
curl 'http://localhost:8080/study-service/v1/local/organizations/1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer c9139551-e12c-4d7e-a667-ce12dd380c14"
* 后面的接口类似，由于error.permission.mismatch 后面接口没测完