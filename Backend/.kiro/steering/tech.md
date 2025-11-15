# Technology Stack

## Build System
- **Maven** - Primary build tool and dependency management
- Java 11

## Frameworks & Libraries
- **Spring Boot 2.7.0** - Application framework
- **Spring Data JPA** - Data persistence layer
- **Spring Web** - REST API support
- **PostgreSQL** - Database (runtime dependency)

## Testing
- **JUnit 5** (5.9.0) - Testing framework
- **Mockito** (4.8.0) - Mocking framework
- **Spring Boot Test** - Integration testing support

## Common Commands

### Build & Run
```bash
# Compile the project
mvn compile

# Run the application
mvn spring-boot:run

# Package as JAR
mvn package
```

### Testing
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=UserServiceTest

# Run tests with detailed output
mvn test -X
```

### Clean & Install
```bash
# Clean build artifacts
mvn clean

# Clean and package
mvn clean package

# Install to local repository
mvn install
```
