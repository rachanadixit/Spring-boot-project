# Spring Boot CRUD API with MongoDB

This project provides a complete CRUD REST API for books using Spring Boot and MongoDB.

## Tech Stack
- Java 17+
- Spring Boot 3
- Spring Web
- Spring Data MongoDB
- Maven

## Configuration
The app is configured in `src/main/resources/application.properties`:
- Port: 8081
- MongoDB URI: mongodb://localhost:27017/spring_boot_project_db

## Build and Run
If Maven is installed globally:

mvn clean package
java -jar target/spring-boot-project-0.0.1-SNAPSHOT.jar

If Maven is not installed globally, this project already includes a portable Maven copy in `.tools` used during setup:

.\.tools\apache-maven-3.9.9\bin\mvn.cmd clean package
java -jar target/spring-boot-project-0.0.1-SNAPSHOT.jar

## REST Endpoints
Base URL: http://localhost:8081/api/books

1. Create book
POST /api/books

Example body:
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "price": 499
}

2. Get all books
GET /api/books

3. Get book by ID
GET /api/books/{id}

4. Update book
PUT /api/books/{id}

Example body:
{
  "title": "Clean Code (Updated)",
  "author": "Robert C. Martin",
  "price": 550
}

5. Delete book
DELETE /api/books/{id}

## Test
Run tests with:

mvn test

or

.\.tools\apache-maven-3.9.9\bin\mvn.cmd test
