# Student Management System

A simple CRUD application for managing student data, built with Spring Boot and Clean Architecture principles.

## What's This?

This is a student management system where you can:

- Add new students
- View all students
- Update student information
- Delete students

The backend uses Spring Boot with Clean Architecture, and there's a simple HTML/JavaScript frontend to interact with it.

## Tech Stack

**Backend:**

- Java 21
- Spring Boot 3.4.0
- H2 Database (in-memory)
- Maven

**Frontend:**

- HTML/CSS/JavaScript
- No frameworks, just vanilla JS

## Project Structure

```
src/main/java/com/example/demo/
├── domain/          # Business entities and interfaces
├── usecase/         # Business logic
├── adapter/         # External interfaces (web, database)
└── config/          # Spring configuration
```

The project follows Clean Architecture:

- Domain layer has no dependencies on frameworks
- Use cases contain business logic
- Adapters handle external concerns (REST API, database)

## How to Run

### Backend

1. Make sure you have Java 21 installed
2. Navigate to project directory
3. Run:

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`

### Frontend

Just open `index.html` in the browser. That's it.

The frontend will automatically connect to the backend API.

## Testing the API

You can test the REST API using:

**Get all students:**

```bash
curl http://localhost:8080/api/students
```

**Get one student:**

```bash
curl http://localhost:8080/api/students/A001
```

**Create student:**

```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "nim": "A004",
    "namaDepan": "John",
    "namaBelakang": "Doe",
    "tanggalLahir": "2000-05-15"
  }'
```

**Update student:**

```bash
curl -X PUT http://localhost:8080/api/students/A004 \
  -H "Content-Type: application/json" \
  -d '{
    "namaDepan": "Jane",
    "namaBelakang": "Doe",
    "tanggalLahir": "2000-05-15"
  }'
```

**Delete student:**

```bash
curl -X DELETE http://localhost:8080/api/students/A004
```

## API Endpoints

| Method | Path                  | Description        |
| ------ | --------------------- | ------------------ |
| GET    | `/api/students`       | Get all students   |
| GET    | `/api/students/{nim}` | Get student by NIM |
| POST   | `/api/students`       | Create new student |
| PUT    | `/api/students/{nim}` | Update student     |
| DELETE | `/api/students/{nim}` | Delete student     |

## Database

The app uses H2 in-memory database. You can access the console at:

```
http://localhost:8080/h2-console
```

Connection details:

- JDBC URL: `jdbc:h2:mem:studentdb`
- Username: `sa`
- Password: (leave empty)

## Sample Data

Three students are automatically created on startup:

- NIM: A001, Name: Vincent 1
- NIM: A002, Name: Vincent
- NIM: A003, Name: Vincent Ta

## Architecture Notes

This project implements Clean Architecture (Uncle Bob):

- **Domain layer** is pure Java, no framework dependencies
- **Use cases** contain business rules
- **Gateway pattern** separates domain from persistence
- **Dependency inversion** - domain defines interfaces, adapters implement them

The StudentGateway interface lives in the domain layer, but the implementation (using JPA) is in the adapter layer. This means we could swap out the database implementation without touching business logic.

## Future Improvements

Some things that could be added:

- Input validation on the frontend
- Pagination for large datasets
- Search/filter functionality
- Better error messages
- Unit tests

## Notes

- NIM (Nomor Induk Mahasiswa) is the unique student ID
- Age is calculated automatically from date of birth
- Full name combines first name and last name
