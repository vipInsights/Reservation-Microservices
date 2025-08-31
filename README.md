# Spring Microservices Reservation System

A microservices-based reservation system built using **Spring Boot**, **MongoDB**, and **Docker**. The system is designed to demonstrate microservices architecture, service communication, and containerized deployment.

---

## 🚀 Features

* **Customer Service** – Manage customer information (CRUD operations)
* **Hotel Service** – Manage hotels and their details
* **Payment Service** – Manage payment and their details
* **Reservation Service** – Handle reservations between customers and hotels
* **Notification Service** – Send notifications asynchronously after reservations
* **MongoDB** – Database for persisting data
* **Docker & Docker Compose** – Containerized deployment of services

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot 3.x** (Web, Data, etc.)
* **MongoDB**
* **Docker & Docker Compose**
* **Maven**
* **(Optional)** Kafka / Zipkin for async communication & tracing

---

## 📂 Project Structure

```
│── docker-compose.yml          # Orchestration file for all services
│── customer-service/           # Microservice for customer management
│── hotel-service/              # Microservice for hotel management
│── payment-service/              # Microservice for payment management
│── reservation-service/        # Microservice for reservations
│── notification-service/       # Microservice for notifications
```

---

## ⚙️ Getting Started

### 1️⃣ Prerequisites

* [Docker](https://docs.docker.com/get-docker/)
* [Docker Compose](https://docs.docker.com/compose/)

### 2️⃣ Build & Run

```bash
# From project root
docker-compose up --build
```

This will start:

* All microservices
* MongoDB

### 3️⃣ Access Services

* **Customer Service** → [http://localhost:8081](http://localhost:8081)
* **Hotel Service** → [http://localhost:8084](http://localhost:8084)
* **Payment Service** → [http://localhost:8087](http://localhost:8087)
* **Reservation Service** → [http://localhost:8086](http://localhost:8086)
* **Notification Service** → [http://localhost:8052](http://localhost:8052)
* **MongoDB** → mongodb://localhost:27017

---

## 📬 API Endpoints

### Customer Service

* `POST /customers` – Create customer
* `GET /customers/{id}` – Get customer by ID
* `GET /customers` – List customers

### Hotel Service

* `POST /hotels` – Create hotel
* `GET /hotels/{id}` – Get hotel by ID
* `GET /hotels` – List hotels
  
### Payment Service
*  POST /payments – Create hotel
*  GET /payments/{id} – Get hotel by ID
*  GET /payments – List hotels

### Reservation Service

* `POST /reservations` – Create reservation
* `GET /reservations/{id}` – Get reservation by ID
* `GET /reservations` – List reservations

### Notification Service

* `POST /notifications` – Send notification
* `GET /notifications` – List notifications

---

## 📖 Testing with Postman

A Postman collection is provided under `postman/` directory (if available). Import into Postman and test endpoints.

---

## 🔮 Included Improvements

* Add **API Gateway** (Spring Cloud Gateway)
* Add **Service Discovery** (Eureka)
* Add **Centralized Logging & Monitoring** (Zipkin)
* Implement **SpringFlux WebClient** for communication between services

---

## 👨‍💻 Author

Developed by **Vipin Kumar** ✨
