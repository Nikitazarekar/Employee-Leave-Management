# Employee-Leave-Management
# 📌 Employee Leave Approval System

A full-stack Employee Leave Management and Approval System that allows
employees to apply for leave and managers/admins to review, approve, or
reject leave requests.

------------------------------------------------------------------------

## 🚀 Features

### 👨‍💼 Employee

-   Apply for leave
-   View leave history
-   Check leave status (Pending / Approved / Rejected)

### 👨‍💻 Admin / Manager

-   View all leave requests
-   Approve or reject leave applications
-   Manage employee records

### 🔐 Authentication & Authorization

-   Role-based access (Employee / Admin)
-   Secure login system

------------------------------------------------------------------------

## 🛠️ Tech Stack

### Backend

-   Java
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   REST APIs

### Database

-   MySQL

### Tools

-   Maven
-   Postman
-   IntelliJ / Eclipse

------------------------------------------------------------------------

## 📂 Project Structure

    src/main/java
    │
    ├── controller
    ├── service
    ├── repository
    ├── model/entity
    ├── dto
    └── config

------------------------------------------------------------------------

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository

``` bash
git clone https://github.com/your-username/employee-leave-approval.git
cd employee-leave-approval
```

### 2️⃣ Configure Database

Update `application.properties`:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/leave_management
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run the Application

``` bash
mvn spring-boot:run
```

Application runs at:

    http://localhost:8080

------------------------------------------------------------------------

## 📡 API Endpoints

### Authentication

-   POST /api/auth/login
-   POST /api/auth/register

### Employee

-   POST /api/leaves/apply
-   GET /api/leaves/my-leaves

### Admin

-   GET /api/leaves/all
-   PUT /api/leaves/{id}/approve
-   PUT /api/leaves/{id}/reject

------------------------------------------------------------------------

## 🗄️ Database Tables

### Employee

-   id
-   name
-   email
-   password
-   role

### Leave

-   id
-   employee_id
-   leave_type
-   start_date
-   end_date
-   reason
-   status

------------------------------------------------------------------------

## 💡 Future Enhancements

-   Email notifications
-   Leave balance tracking
-   JWT authentication
-   Frontend integration (React/Angular)
-   Dashboard analytics

