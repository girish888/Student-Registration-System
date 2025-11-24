✍️ Student Management System (Spring Boot + MySQL)

A complete and fully functional backend + simple frontend system to manage students, built as a personal project to showcase strong backend development skills using Java, Spring Boot, MySQL, and a clean HTML/CSS/JS interface.

The system allows you to create, update, search, list, and delete students with proper validation, error handling, and a modern UI.

⭐ Key Features

🎓 Student Management

Add new students

Edit existing student details

Delete students

Search by name or roll number

Pagination + sorting support

Clean & responsive UI (Night Mode included)

🔐 Secure & Robust Backend

Built using Spring Boot 3+

Request validation using jakarta.validation

Global exception handling

No duplicate roll numbers or email

Strong layered architecture:

Controller

Service

Repository

DTOs

Custom Exceptions

💾 MySQL Database Integration

Stores all student data with:
✔ Roll number
✔ First & last name
✔ Email
✔ Gender
✔ Phone
✔ Date of birth
✔ CreatedAt & UpdatedAt timestamps

Uses Spring Data JPA + Hibernate.

🌐 Modern Frontend (Static HTML/CSS/JS)

Completely custom-designed frontend

Night-mode UI for eye comfort

Works directly with your backend (localhost:8080)

Instant list refresh

Popup-style user alerts

🛠️ Technologies Used
Frontend

HTML5

CSS (Custom Night Mode UI)

JavaScript (Fetch API)

Backend

Java 21

Spring Boot

Spring Web

Spring Data JPA

Validation API

Lombok

Database

MySQL 8+

Build Tool

Maven

🚀 How to Run the Project
1️⃣ Install Requirements

Java 21+

Maven

MySQL 8+

2️⃣ Create MySQL Database
CREATE DATABASE student_management_system;

3️⃣ Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management_system
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Build & Run
mvn clean package
mvn spring-boot:run


or:

java -jar target/student-management-0.0.1-SNAPSHOT.jar

5️⃣ Open the Frontend (Static Page)
http://localhost:8080/index.html

📱 Features for Users

✨ Student Operations

Add student

Update student

Delete student

Search instantly

Pagination control

🧪 Backend Reliability

Field validation

Duplicate roll validation

Global exception handling

JSON responses

🎨 UI Features

Modern dark theme

Responsive layout

Clean input forms

Real-time updates

❗ Troubleshooting

Issue	Cause	Fix

MySQL connection error	Wrong password	Update application.properties

404 on API	Wrong URL	Use /api/v1/students

Frontend not loading	File not in /static	Move index.html to /resources/static/

Port 8080 busy	Another service running	Change server.port=8081

📄 License

This project is licensed under the MIT License.
