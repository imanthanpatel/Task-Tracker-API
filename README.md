# ✅ Task-Tracker-API

A **Task Tracker REST API** built using **Java 17** and **Spring Boot**, designed to manage tasks efficiently with a clean layered architecture, proper exception handling, and secure backend practices.

This project focuses on building a **real-world backend application** following industry standards.

---

## 🚀 Features

- 📝 Task CRUD Operations
- 🧩 Layered Architecture
- 🔄 DTO & Mapper Pattern
- ⚠️ Global Exception Handling
- 🧠 Business Logic Separation
- 🗃️ Database Integration using JPA
- 🔐 Ready for Spring Security integration
- 📦 Clean & Maintainable Codebase

---

## 🛠️ Tech Stack

| Technology | Usage |
|----------|------|
| Java 17 | Core language |
| Spring Boot | Backend framework |
| Spring Data JPA | ORM & database interaction |
| Hibernate | JPA implementation |
| MySQL / H2 | Database |
| Maven | Build & dependency management |

---

## 🏗️ Project Architecture

```text
src/main/java
└── com.example.tasktracker
    ├── controller        # REST API controllers
    ├── Service           # Business logic layer
    ├── Repository        # Data access layer (JPA)
    ├── DTO               # Data Transfer Objects
    ├── Mapper            # DTO ↔ Model mapping
    ├── model             # JPA entity classes
    ├── exception         # Custom exceptions & global handler
    └── Configuration     # Application & bean configurations
