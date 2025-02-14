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

1. Clone the repository:
```bash
git clone https://github.com/moqimoqidea/moqi-ai-java-junit5-test.git
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

## Testing

To run the tests:
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

