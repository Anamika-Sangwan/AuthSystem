📌 Role-Based Authentication System

A secure backend application built using Java Spring Boot that implements JWT-based authentication and role-based authorization. The project demonstrates real-world backend security practices and API protection.

🚀 Features

      User authentication using JWT

      Role-based access control (USER / ADMIN)

      Secure password encryption (BCrypt)

      Protected REST APIs

      Global exception handling

      Input validation

      Stateless session management

      API testing using Postman

🛠 Tech Stack

Java

      Spring Boot

      Spring Security

      Hibernate / JPA

      PostgreSQL

      Maven

      JWT

      Postman

🔐 API Endpoints
Auth
Method Endpoint Access
POST /api/auth/register Public
POST /api/auth/login Public
User
Method Endpoint Access
GET /api/user/profile USER, ADMIN
Admin
Method Endpoint Access
GET /api/admin/dashboard ADMIN
▶️ How to Run

Clone the repository
git clone https://github.com/your-username/role-based-auth-system.git

Configure PostgreSQL in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=postgres
spring.datasource.password=your_password

Run the application

mvn spring-boot:run

Test APIs using Postman

Authenticate to receive JWT

Pass token in header:

Authorization: Bearer <JWT_TOKEN>
