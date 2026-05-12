# 🚌 Bus Ticket Booking System

A fully functional **REST API** built with **Spring Boot** for managing bus ticket bookings.
This project follows industry-standard layered architecture and best practices.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot 3.4.5 | Backend Framework |
| Spring Data JPA | Database ORM |
| MySQL | Relational Database |
| Lombok | Reduce Boilerplate Code |
| Bean Validation | Input Validation |
| Swagger UI | API Documentation & Testing |
| Maven | Build Tool |

---

## 📁 Project Structure

src/main/java/com/demo/bus/
├── entity/         → Database table classes
├── dto/            → API request & response classes
├── mapper/         → Converts Entity ↔ DTO
├── repository/     → Database query interfaces
├── service/        → Business logic interfaces
│   └── impl/       → Business logic implementations
├── controller/     → REST API endpoints
└── exception/      → Custom exceptions & global handler

---

## 🗃️ Database Design

Bus ──────────► Route ──────────► Booking ◄──────────── Passenger
(1)            (Many)            (Many)                    (1)

- One Bus can have many Routes
- One Route can have many Bookings
- One Passenger can have many Bookings

---

## 🚀 Features

- ✅ Add and manage Buses (AC / Non-AC / Sleeper)
- ✅ Define Routes with fare, distance and timings
- ✅ Register Passengers with validation
- ✅ Book Tickets with automatic fare assignment
- ✅ Cancel Bookings (status → CANCELLED)
- ✅ Search Routes by Source and Destination
- ✅ Pagination for all list APIs
- ✅ Input Validation with meaningful error messages
- ✅ Global Exception Handling
- ✅ API Documentation with Swagger UI

---

## 📌 API Endpoints

### 🚌 Bus APIs
| Method | URL | Description |
|--------|-----|-------------|
| POST | /bus | Add a new bus |
| GET | /bus | Get all buses (paginated) |
| GET | /bus/{id} | Get bus by ID |
| PUT | /bus/{id} | Update bus details |
| DELETE | /bus/{id} | Delete a bus |
| GET | /bus/type/{type} | Get buses by type |

### 🗺️ Route APIs
| Method | URL | Description |
|--------|-----|-------------|
| POST | /route | Add a new route |
| GET | /route | Get all routes (paginated) |
| GET | /route/{id} | Get route by ID |
| PUT | /route/{id} | Update route details |
| DELETE | /route/{id} | Delete a route |
| GET | /route/bus/{busId} | Get all routes by bus |
| GET | /route/search?source=X&destination=Y | Search routes |

### 👤 Passenger APIs
| Method | URL | Description |
|--------|-----|-------------|
| POST | /passenger | Register a new passenger |
| GET | /passenger | Get all passengers (paginated) |
| GET | /passenger/{id} | Get passenger by ID |
| PUT | /passenger/{id} | Update passenger details |
| DELETE | /passenger/{id} | Delete a passenger |

### 🎫 Booking APIs
| Method | URL | Description |
|--------|-----|-------------|
| POST | /booking | Book a ticket |
| GET | /booking | Get all bookings (paginated) |
| GET | /booking/{id} | Get booking by ID |
| DELETE | /booking/{id} | Cancel a booking |
| GET | /booking/passenger/{id} | Get bookings by passenger |
| GET | /booking/route/{id} | Get bookings by route |

---

## ⚙️ How to Run Locally

### Prerequisites
- Java 17
- MySQL
- Maven
- IntelliJ IDEA

### Steps

1. Clone the repository
git clone https://github.com/SeranManivel/bus-ticket-booking.git
cd bus-ticket-booking

2. Create MySQL database
CREATE DATABASE bus_booking_db;

3. Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/bus_booking_db
spring.datasource.username=root
spring.datasource.password=your_password

4. Run the application
./mvnw spring-boot:run

5. Open Swagger UI
http://localhost:8080/swagger-ui.html

---

## 📝 Sample API Request

Book a Ticket — POST /booking

Request:
{
  "seatNumber": 5,
  "travelDate": "2026-06-15",
  "passengerId": 1,
  "routeId": 1
}

Response:
{
  "id": 1,
  "seatNumber": 5,
  "travelDate": "2026-06-15",
  "status": "CONFIRMED",
  "totalFare": 550.0,
  "passengerId": 1,
  "routeId": 1
}

---

## 👨‍💻 Author

Seran Manivel
Java Full Stack Developer
Qspiders — Chennai
