# Project Structure

## Root Directory Layout

```
Kiroween/
├── Backend/              # Spring Boot backend API
├── Android_App/          # Android mobile application
├── red-eye/              # React Native frontend
└── .git/                 # Git repository
```

## Backend Directory Structure

```
Backend/
├── src/
│   ├── Main/Java/app/
│   │   ├── controller/        # REST API endpoints
│   │   ├── model/             # JPA entity classes
│   │   ├── repository/        # Data access layer (Spring Data JPA)
│   │   ├── service/           # Business logic layer
│   │   └── RedEyeApp.java     # Spring Boot application entry point
│   └── test/java/app/
│       └── service/           # Service layer unit tests
├── target/                    # Maven build output (gitignored)
├── pom.xml                    # Maven configuration
├── HOW_TO_WRITE_TESTS.txt    # Testing guide
└── TEST_README.md             # Test running instructions
```

## Architecture Pattern

The project follows a **layered architecture**:

1. **Controller Layer** - Handles HTTP requests and responses
2. **Service Layer** - Contains business logic
3. **Repository Layer** - Data access using Spring Data JPA
4. **Model Layer** - JPA entities representing database tables

## Package Structure

All packages use the `app.*` namespace:
- Base package: `app`
- Model package: `app.model`
- Service package: `app.service`
- Repository package: `app.repository`
- Controller package: `app.controller`

## Naming Conventions

- **Models**: Singular nouns (e.g., `User`, `HoursLog`, `JournalEntry`, `NightQuiz`, `MorningQuiz`)
- **Services**: `{Entity}Service` (e.g., `UserService`, `HoursLogService`)
- **Repositories**: `{Entity}Repository` (e.g., `UserRepository`, `NightQuizRepository`)
- **Controllers**: `{Feature}Controller` (e.g., `RedEyeController`)
- **Tests**: `{Class}Test` (e.g., `UserServiceTest`)

## Code Conventions

- Use `@Autowired` constructor injection for dependencies
- Models include `equals()` and `toString()` overrides
- JPA annotations: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`
- Service classes annotated with `@Service`
- Repository interfaces extend `JpaRepository<Entity, ID>`
- Test files mirror package structure in `src/test/java/`
- Package names are all lowercase (e.g., `app.service`, not `app.Service`)

## Maven Structure

- Source code: `src/Main/Java/` (note: should be `src/main/java/` per Maven convention)
- Test code: `src/test/java/`
- Compiled classes: `target/classes/`
- Test classes: `target/test-classes/`
