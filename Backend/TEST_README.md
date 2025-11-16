# Running Tests for Sleep Tracker Backend

## Test Files Created
All test files are located in `Backend/src/test/`:
- `UserServiceTest.java` - Tests for UserService
- `NightQuizServiceTest.java` - Tests for NightQuizService  
- `MorningQuizServiceTest.java` - Tests for MorningQuizService
- `HoursLogServiceTest.java` - Tests for HoursLogService
- `JournalEntryServiceTest.java` - Tests for JournalEntryService

## How to Run Tests

### Option 1: Using Maven (Recommended)

**Run all tests:**
```bash
cd Backend
mvn test
```

**Run a specific test class:**
```bash
mvn test -Dtest=UserServiceTest
```

**Run tests with detailed output:**
```bash
mvn test -X
```

### Option 2: Using IDE (IntelliJ IDEA / Eclipse)

**IntelliJ IDEA:**
1. Right-click on the `test` folder
2. Select "Run 'All Tests'"
3. Or right-click on individual test files to run them separately

**Eclipse:**
1. Right-click on the `test` folder
2. Select "Run As" → "JUnit Test"

### Option 3: Using Gradle (if you prefer Gradle over Maven)

If you want to use Gradle instead, add this to `build.gradle`:
```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.0'
    testImplementation 'org.mockito:mockito-core:4.8.0'
    testImplementation 'org.mockito:mockito-junit-jupiter:4.8.0'
}

test {
    useJUnitPlatform()
}
```

Then run:
```bash
./gradlew test
```

## What the Tests Cover

Each service test includes:
- ✓ Testing all CRUD operations (Create, Read, Update, Delete)
- ✓ Testing retrieval by user ID
- ✓ Testing retrieval by date
- ✓ Testing retrieval by date range
- ✓ Testing edge cases (not found scenarios)
- ✓ Verifying repository method calls using Mockito

## Test Structure

All tests use:
- **JUnit 5** - Testing framework
- **Mockito** - For mocking repository dependencies
- **@Mock** - Creates mock repository objects
- **@InjectMocks** - Injects mocks into the service being tested
- **verify()** - Ensures repository methods are called correctly

## Expected Output

When tests pass, you'll see:
```
[INFO] Tests run: X, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

If tests fail, you'll see detailed error messages showing which assertions failed.
