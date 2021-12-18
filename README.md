# Getting your hands dirty on clean architecture


## Build

Written on Java 17.
Make sure that your JAVA_HOME points to a JDK 17 distribution.

```bash
> ./mvnw spring-boot:run
```

## Curl samples

### Create comment
```bash
> curl -X POST http://localhost:8080/comments -H 'Content-Type: application/json' -d '{"body": "hello"}'
```

### Get comment
```bash
> curl -X GET http://localhost:8080/comments/61be4bf82c932665b33febb9
```
