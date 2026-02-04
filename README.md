# Todo API - Spring Boot

A modern, lightweight RESTful API built with Spring Boot to manage Todo tasks. This project demonstrates clean architecture, dependency injection (using `@Qualifier`), and RESTful design patterns.

## 🚀 Features

- **RESTful Endpoints**: Full CRUD-capable structure for managing Todo items.
- **Dependency Injection**: Utilizes Spring's `@Service` and `@Qualifier` for decoupled business logic.
- **Multiple Service Implementations**: Features multiple strategies (`FakeTodoService`, `AnotherTodoService`) to showcase flexible service orchestration.
- **In-Memory Data Management**: Rapid development and testing with specialized in-memory data Handling.
- **Error Handling**: Custom error responses with appropriate HTTP status codes and detailed messaging.

## 🛠️ Technology Stack

- **Framework**: Spring Boot 4.0.2
- **Language**: Java 17
- **Build Tool**: Gradle
- **Dependencies**: 
    - Spring Web (REST controllers)
    - Spring Boot DevTools (Hot reloading)
    - Spring Boot Starter Test (JUnit 5)

## 📡 API Endpoints

### Todos

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/todos` | Retrieve all todos (supports `isCompleted` query param) |
| `GET` | `/api/v1/todos/{todoId}` | Retrieve a specific todo by ID |
| `POST` | `/api/v1/todos` | Create a new todo item |

## 🏗️ Project Structure

```text
src/main/java/com/example/demo/
├── TodoController.java       # Handles REST requests and orchestration
├── Todo.java                # Core Data Model
├── TodoService.java         # Interface for business logic
├── FakeTodoService.java     # Implementation A
├── AnotherTodoService.java  # Implementation B
└── TodoApiSpringApplication.java # Entry Point
```

## 🚥 Getting Started

### Prerequisites
- JDK 17 or higher
- Gradle (optional, `gradlew` wrapper included)

### Running the App
1. Clone the repository:
   ```bash
   git clone https://github.com/KirnFReako/TodoApi--Springboot.git
   ```
2. Navigate to the `demo` directory:
   ```bash
   cd demo
   ```
3. Run using Gradle wrapper:
   ```bash
   ./gradlew bootRun
   ```

## 🧪 Testing
Run the test suite using:
```bash
./gradlew test
```

---
*Developed as a demonstration of Spring Boot best practices.*
