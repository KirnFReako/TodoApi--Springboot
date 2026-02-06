# 📝 Todo API - Spring Boot Core & AOP

A high-performance, robust RESTful API built with **Spring Boot** to manage Todo tasks. This project is a comprehensive showcase of modern Java development, featuring **Aspect-Oriented Programming (AOP)**, **Dependency Injection**, and **Custom Annotations**.

---

## 🚀 Key Features

- **RESTful Architecture**: Clean, semantic API endpoints for Todo management.
- **Advanced DI**: Demonstrates complex dependency injection using `@Qualifier` for strategy switches.
- **Performance Monitoring**: Custom-built AOP logic to track method execution time.
- **Clean Code & Type Safety**: Structured model-driven design with error handling.
- **Modular Services**: Decoupled business logic with multiple service implementations.

---

## 🛠️ Technology Stack

| Technology | Usage |
| :--- | :--- |
| **Java 17** | Modern language features and performance. |
| **Spring Boot 4.x** | Core framework for auto-configuration and web services. |
| **Spring AOP** | Decoupling cross-cutting concerns (logging, monitoring). |
| **Gradle** | Modern build automation and dependency management. |

---

## 📜 Annotation Deep Dive

Spring Boot relies heavily on annotations to reduce boilerplate code. Here is a breakdown of every annotation used in this project and why they are essential:

### 🏷️ Core Application Annotations
- **`@SpringBootApplication`**: The cornerstone of the app. It enables auto-configuration, component scanning, and allows for extra configuration on the class.
- **`@EnableAspectJAutoProxy`**: Vital for our performance monitoring. It tells Spring to look for `@Aspect` classes and generate proxies to wrap the target objects.

### 🌐 REST & Web Annotations
- **`@RestController`**: Marks the class as a web controller where every method returns a domain object instead of a view. It combines `@Controller` and `@ResponseBody`.
- **`@RequestMapping("/api/v1/todos")`**: Sets the base path for all endpoints in the controller, ensuring a clean and versioned API structure.
- **`@GetMapping` / `@PostMapping`**: Specifically maps HTTP GET and POST requests. These are modern, semantic alternatives to `@RequestMapping(method = RequestMethod.GET)`.
- **`@PathVariable`**: Used to extract the ID from the URL path (e.g., `/todos/{id}`).
- **`@RequestBody`**: Automatically deserializes the incoming JSON request body into a Java object (`Todo`).
- **`@RequestParam`**: Captures optional query parameters from the URL (e.g., `?isCompleted=true`).

### 🧩 Dependency Injection (DI)
- **`@Service`**: A specialized version of `@Component`. It tells Spring that the class contains business logic and should be managed as a Bean.
- **`@Component`**: The most generic stereotype. Any class marked with this is registered in the Spring Application Context.
- **`@Qualifier`**: Crucial when multiple implementations of an interface exist. It specifies *which* bean to inject (e.g., `FakeTodoService` vs `AnotherTodoService`).

### ⏱️ Custom Monitoring & AOP
- **`@Aspect`**: Marks a class (like `TimeMonitorAspect`) as a container for Advice and Pointcuts.
- **`@Around`**: The most powerful advice. It allows us to perform logic both *before* and *after* a method execution, which is perfect for timing.
- **`@TimeMonitor`**: Our custom annotation. By placing this on a method, we "mark" it to be intercepted by our AOP aspect.
- **`@Target` & `@Retention`**: Meta-annotations used to define `@TimeMonitor`. `@Target` limits where the annotation can be used (methods), and `@Retention` ensures it's available at runtime for Spring to see.

---

## 📡 API Reference

### Todo Resources

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/todos` | Fetch all todos. |
| `GET` | `/api/v1/todos/{id}` | Fetch a single todo by its unique ID. |
| `POST` | `/api/v1/todos` | Create a new todo entry. |

---

## 📂 Project Structure

```text
src/main/java/com/example/demo/
├── TodoController.java           # Entry point for HTTP requests
├── Todo.java                    # Model representing a Todo item
├── TodoService.java             # Interface for service abstractions
├── FakeTodoService.java         # Service implementation using mock logic
├── AnotherTodoService.java      # Alternative service implementation
├── TimeMonitor.java             # Custom annotation for AOP
├── TimeMonitorAspect.java       # Aspect logic for execution timing
└── TodoApiSpringApplication.java # Spring Boot startup class
```

---

## 🚦 Getting Started

### 1. Requirements
- **JDK 17+**
- **Git**

### 2. Run the Project
```bash
# Clone the repository
git clone https://github.com/KirnFReako/TodoApi--Springboot.git

# Enter directory
cd demo

# Start the application
./gradlew bootRun
```

---
*Built with ❤️ by [KirnFReako](https://github.com/KirnFReako)*
