Student CRUD REST API built with:
- Java 21
- Spring Boot: Web, Data JPA, Validation
- Hibernate (JPA provider)
- H2 Database (in-memory)
- Jakarta EE APIs: `jakarta.persistence`, `jakarta.validation`
- Swagger / OpenAPI via `springdoc-openapi`

## Run Backend
./mvnw spring-boot:run
Base URL: http://localhost:8080

## Swagger UI
Open: http://localhost:8080/swagger-ui/index.html
OpenAPI JSON: http://localhost:8080/v3/api-docs

## H2 Console (in-memory database)
Open: http://localhost:8080/h2-console/
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (empty)