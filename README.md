# 🌦 Weather Application Backend

A comprehensive, high-performance **Spring Boot REST API** designed to process, store, and analyze nearly **20 years of large-scale weather CSV data**.  

This backend system leverages an optimized MySQL relational schema, Spring Data JPA ORM mapping, and a fully interactive Swagger/OpenAPI dashboard for seamless API testing and validation.

The application is built with scalability, modularity, and performance in mind, ensuring efficient handling of chronological weather datasets and dynamic statistical computations.

---

# 📌 Project Overview

The Weather Application backend is responsible for:

- Ingesting multi-megabyte historical CSV weather files
- Persisting structured meteorological data into MySQL
- Providing fast lookup APIs across a 20-year dataset
- Dynamically computing statistical metrics such as minimum, maximum, and median temperatures
- Exposing clean, documented RESTful endpoints via Swagger

The system follows a layered architecture to ensure maintainability and separation of concerns.

---

# 🚀 Core Features

## 📥 1. Data Ingestion Engine  
**Endpoint:** `POST /api/v1/weather/upload`

- Streams large CSV files using OpenCSV
- Processes records in batches for optimized insertion
- Stores structured weather records into MySQL
- Designed to handle high-volume ingestion efficiently

---

## 📅 2. High-Performance Date Lookup  
**Endpoint:** `GET /api/v1/weather/by-date`

- Retrieves weather data for a specific date
- Optimized for querying large chronological datasets
- Supports 20+ years of historical weather data

**Parameter:**  
- `date` (Format: YYYY-MM-DD)

---

## 📆 3. Monthly Data Lookup  
**Endpoint:** `GET /api/v1/weather/by-month`

- Filters weather records by year and month
- Returns detailed meteorological information

**Parameters:**  
- `year`
- `month`

---

## 📊 4. Dynamic Statistical Analytics  
**Endpoint:** `GET /api/v1/weather/stats`

Computes advanced statistical temperature metrics:

- 🔻 Minimum temperature  
- 🔺 Maximum temperature  
- 📈 Median temperature (calculated via Java Streams)

All statistical calculations are dynamically computed at runtime based on the provided year.

**Parameter:**  
- `year`

---

## 📖 OpenAPI 3.0 Integration

Interactive Swagger documentation is available at:
# 🌦 Weather Application Backend

A comprehensive, high-performance **Spring Boot REST API** designed to process, store, and analyze nearly **20 years of large-scale weather CSV data**.  

This backend system leverages an optimized MySQL relational schema, Spring Data JPA ORM mapping, and a fully interactive Swagger/OpenAPI dashboard for seamless API testing and validation.

The application is built with scalability, modularity, and performance in mind, ensuring efficient handling of chronological weather datasets and dynamic statistical computations.

---

# 📌 Project Overview

The Weather Application backend is responsible for:

- Ingesting multi-megabyte historical CSV weather files
- Persisting structured meteorological data into MySQL
- Providing fast lookup APIs across a 20-year dataset
- Dynamically computing statistical metrics such as minimum, maximum, and median temperatures
- Exposing clean, documented RESTful endpoints via Swagger

The system follows a layered architecture to ensure maintainability and separation of concerns.

---

# 🚀 Core Features

## 📥 1. Data Ingestion Engine  
**Endpoint:** `POST /api/v1/weather/upload`

- Streams large CSV files using OpenCSV
- Processes records in batches for optimized insertion
- Stores structured weather records into MySQL
- Designed to handle high-volume ingestion efficiently

---

## 📅 2. High-Performance Date Lookup  
**Endpoint:** `GET /api/v1/weather/by-date`

- Retrieves weather data for a specific date
- Optimized for querying large chronological datasets
- Supports 20+ years of historical weather data

**Parameter:**  
- `date` (Format: YYYY-MM-DD)

---

## 📆 3. Monthly Data Lookup  
**Endpoint:** `GET /api/v1/weather/by-month`

- Filters weather records by year and month
- Returns detailed meteorological information

**Parameters:**  
- `year`
- `month`

---

## 📊 4. Dynamic Statistical Analytics  
**Endpoint:** `GET /api/v1/weather/stats`

Computes advanced statistical temperature metrics:

- 🔻 Minimum temperature  
- 🔺 Maximum temperature  
- 📈 Median temperature (calculated via Java Streams)

All statistical calculations are dynamically computed at runtime based on the provided year.

**Parameter:**  
- `year`

---

## 📖 OpenAPI 3.0 Integration

Interactive Swagger documentation is available at:
http://localhost:8081/swagger-ui/index.html


Features:
- Visual API execution
- Request/response inspection
- Contract validation
- Easy backend testing

---

# 🏗 System Architecture

The project follows a clean layered structure:
controller → service → repository → entity


### 🔹 Entity Layer
- Maps database tables to Java classes
- Uses JPA annotations for ORM mapping

### 🔹 Repository Layer
- Extends Spring Data JPA
- Handles CRUD and database queries

### 🔹 Service Layer
- Contains business logic
- Performs statistical calculations
- Handles data transformation

### 🔹 Controller Layer
- Exposes REST API endpoints
- Handles HTTP requests and responses

This modular design ensures scalability and maintainability.

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 21 | Latest LTS runtime |
| Spring Boot 4 | Application framework |
| Spring Web | REST API development |
| Spring Data JPA | ORM & persistence |
| MySQL 8.0 | Relational database |
| OpenCSV | CSV streaming parser |
| Lombok | Boilerplate reduction |
| Swagger (OpenAPI 3.0) | API documentation |

---

# ⚙️ Prerequisites

Ensure the following are installed:

- Java 21 JDK (configured in JAVA_HOME)
- Maven 3.x or later
- MySQL 8.x running locally on port 3306

Create database:

```sql
CREATE DATABASE weather_db;
