# 🧑‍💼 Employee Management System (Spring Boot + JWT + MySQL)

A secure and robust REST API for managing employee records, built with **Spring Boot 3**, **Spring Security (JWT)**, and **MySQL**. This project includes full CRUD functionality, role-based access control, and clean RESTful design patterns.

---

## 🚀 Features

- ✅ CRUD operations for Employees
- ✅ Department management (One-to-Many relation)
- ✅ User registration and JWT-based login
- ✅ Role-based access control (Admin/User)
- ✅ Pagination, sorting, and filtering
- ✅ Swagger API documentation
- ✅ MySQL database integration
- ✅ Docker-ready (optional)
- ✅ (Optional) React.js frontend

---

## 🛠️ Tech Stack

| Layer      | Technology                         |
| ---------- | ---------------------------------- |
| Language   | Java 17                            |
| Framework  | Spring Boot 3.x                    |
| Security   | Spring Security, JWT               |
| ORM        | Hibernate, Spring Data JPA         |
| Database   | MySQL                              |
| Build Tool | Maven                              |
| API Docs   | SpringDoc OpenAPI (Swagger UI)     |
| Dev Tools  | Lombok, Postman, Docker (optional) |

---

## 🗃️ Database Design

- `User` (id, username, password, roles)
- `Department` (id, name, description)
- `Employee` (id, name, email, salary, department_id)

---

## 🔐 Authentication & Authorization

- JWT is used for stateless authentication.
- Users can log in with `/auth/login` and receive a JWT token.
- Roles (`ADMIN`, `USER`) control access to various endpoints.

---

## 🧪 API Endpoints (Sample)

### Authentication

- `POST /auth/register` – Register new user
- `POST /auth/login` – Authenticate and get JWT

### Employees

- `GET /employees` – List all (ADMIN/USER)
- `POST /employees` – Create (ADMIN only)
- `PUT /employees/{id}` – Update (ADMIN only)
- `DELETE /employees/{id}` – Delete (ADMIN only)

### Departments

- `GET /departments` – List departments
- `POST /departments` – Add new department (ADMIN only)

---

## 🔄 Pagination & Filtering

- `GET /employees?page=0&size=10`
- `GET /employees?department=IT`
- `GET /employees?sort=salary,desc`

---

## 📦 Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/nikhilmahajan1122/projects/employee-management-system.git
cd employee-management-system
```
