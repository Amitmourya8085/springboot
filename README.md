# Enterprise Spring Boot Backend Template

A robust implementation of a RESTful API utilizing Spring Boot, showcasing professional backend architecture, N-tier design patterns, and centralized exception handling.

---

## Technical Specifications

### Architecture & Design Patterns
The application implements a clean **N-tier architecture** to ensure scalability and maintainability:
* **Presentation Layer:** REST Controllers managing HTTP request/response lifecycles.
* **Business Logic Layer:** Service components encapsulating core application logic.
* **Data Access Layer:** Spring Data JPA Repositories for abstraction of database operations.
* **Data Transfer Objects (DTO):** Strict decoupling of persistence entities from API contracts using specialized Request/Response DTOs.
* **Cross-Cutting Concerns:** Global exception handling using `@ControllerAdvice`.

### Technology Stack
* **Framework:** Spring Boot
* **Persistence:** Spring Data JPA / Hibernate
* **Validation:** Implementation of standard DTO-based data validation
* **Build Tool:** Maven

---

## Project Structure

The source code follows the standard Maven directory layout:

```text
src/main/java/com/amit8085/testdb/
├── controller/      # API Endpoints and Routing
├── service/         # Business Logic implementation
├── repository/      # Data Access Layer (JPA)
├── entity/          # Persistence Models (Database Schema)
├── dto/             # Request/Response Data Contracts
├── exception/       # Centralized Global Error Handling
└── TestdbApplication.java (Entry Point)

