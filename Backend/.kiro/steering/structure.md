# Project Structure

## Directory Layout

```
src/
├── Main/
│   └── Java/
│       ├── Controller/     # REST API endpoints
│       ├── Model/          # JPA entity classes
│       ├── Repository/     # Data access layer (Spring Data JPA)
│       ├── Service/        # Business logic layer
│       └── RedEyeApp.java  # Spring Boot application entry point
└── test/                   # Unit tests (service layer tests)
```

## Architecture Pattern

The project follows a **layered architecture**:

1. **Controller Layer** - Handles HTTP requests and responses
2. **Service Layer** - Contains business logic
3. **Repository Layer** - Data access using Spring Data JPA
4. **Model Layer** - JPA entities representing database tables

## Package Structure

- Base package: `com.example`
- Entity package: `com.example.entity` (used in Model classes)
- Service package: `com.example.service`
- Repository package: `repository` (no full package prefix in imports)
- Controller package: (follows com.example pattern)

## Naming Conventions

- **Models**: Singular nouns (e.g., `User`, `HoursLog`, `JournalEntry`)
- **Services**: `{Entity}Service` (e.g., `UserService`, `HoursLogService`)
- **Repositories**: `{Entity}Repository` (e.g., `UserRepository`)
- **Controllers**: `{Feature}Controller` (e.g., `RedEyeController`)
- **Tests**: `{Class}Test` (e.g., `UserServiceTest`)

## Code Conventions

- Use `@Autowired` constructor injection for dependencies
- Models include `equals()` and `toString()` overrides
- JPA annotations: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`
- Service classes annotated with `@Service`
- Repository interfaces extend Spring Data JPA repositories
- Test files located directly in `src/test/` (not mirroring package structure)
