# moqi-ai-java-junit5-test

A Spring Boot project demonstrating JUnit 5 testing capabilities.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Technology Stack

- Spring Boot 3.4.2
- JUnit 5
- Lombok
- Maven

## Getting Started

* Clone the repository:

```bash
git clone https://github.com/moqimoqidea/moqi-ai-java-junit5-test.git
```

* Build the project:

```bash
mvn clean install
```

* Run the application:

```bash
mvn spring-boot:run
```

## Testing

* To run the tests:

```bash
mvn test
```

## API Documentation

### GET

```bash
curl -X GET http://localhost:8080/api/messages/hello
```

### POST

```bash
curl -X POST http://localhost:8080/api/messages \
  -H "Content-Type: application/json" \
  -d '{"content": "Hello, World!"}'
```

### DELETE

```bash
curl -X DELETE http://localhost:8080/api/messages/hello
```

### PUT

```bash
curl -X PUT http://localhost:8080/api/messages/hello \
  -H "Content-Type: application/json" \
  -d '{"content": "Hello, Updated World!"}'
```

### 学校测试

* 创建学校：

```bash
curl -X POST http://localhost:8080/api/schools \
  -H "Content-Type: application/json" \
  -d '{
    "name": "测试中学",
    "address": "北京市海淀区",
    "description": "一所中学"
  }'
```

* 查询学校：

```bash
curl -X POST http://localhost:8080/api/schools/query \
  -H "Content-Type: application/json" \
  -d '{}'
```

* 创建学生（假设学校ID为1）：

```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "张三",
    "age": 15,
    "grade": "高一",
    "schoolId": 1
  }'
```

* 查询学生：

```bash
curl -X POST http://localhost:8080/api/students/query \
  -H "Content-Type: application/json" \
  -d '{}'
```

* 创建学校代码（假设学校ID为1）：

```bash
curl -X POST http://localhost:8080/api/scodes \
  -H "Content-Type: application/json" \
  -d '{
    "code": "BJH001",
    "schoolId": 1,
    "description": "北京海淀一中代码"
  }'
```

* 查询学校代码：

```bash
curl -X POST http://localhost:8080/api/scodes/query \
  -H "Content-Type: application/json" \
  -d '{}'
```

* 更新学校信息：

```bash
curl -X PUT http://localhost:8080/api/schools/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "测试中学（更新）",
    "address": "北京市海淀区（更新）",
    "description": "一所中学（更新）"
  }'
```

* 更新学生信息：

```bash
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "张三（更新）",
    "age": 16,
    "grade": "高二",
    "schoolId": 1
  }'
```

* 删除学校代码：

```bash
curl -X DELETE http://localhost:8080/api/scodes/1
```

* 删除学生：

```bash
curl -X DELETE http://localhost:8080/api/students/1
```

* 删除学校：

```bash
curl -X DELETE http://localhost:8080/api/schools/1
```

