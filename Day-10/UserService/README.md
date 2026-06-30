# Microservices Project (Spring Boot + Kafka)

## 📌 Overview
This project demonstrates a microservices architecture using Spring Boot and Apache Kafka.

It consists of two services:
- User Service (Producer)
- Notification Service (Consumer)

---

## 🚀 Features
- User CRUD APIs
- Kafka event publishing (User Service)
- Kafka event consumption (Notification Service)
- External API integration
- Logging using SLF4J
- Global exception handling
- Unit testing

---

## 🧩 Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Apache Kafka
- MySQL
- Redis (Caching)
- REST APIs

---

## ⚙️ How to Run

### 1. Start Zookeeper
zookeeper-server-start.sh config/zookeeper.properties

### 2. Start Kafka
kafka-server-start.sh config/server.properties

### 3. Run Notification Service
- Run NotificationServiceApplication

### 4. Run User Service
- Run UserServiceApplication

---

## 📡 API Endpoints

### Create User
POST /users

### Get All Users
GET /users

### Update User
PUT /users/{id}

### Delete User
DELETE /users/{id}

---

## 🔄 Flow

User Request → User Service → Kafka → Notification Service → External API

---

## 🛠 Improvements (Day 10)
- Added structured logging
- Implemented global exception handling
- Added unit testing
- Improved code quality

---

## 🎯 Final Outcome
- End-to-end system working
- Clean and maintainable code
- Ready for basic production-level tasks