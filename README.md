# ⚡ Smart Village Energy Management Platform

A distributed energy management platform developed as a **university team project** to simulate a modern smart village. The system manages energy production, consumption, and storage across smart homes while integrating real-time weather and electricity tariff data using MQTT.

> **Tech Stack:** Java • Spring Boot • Angular • MySQL • Spring Data JPA • MQTT • Docker • Maven

---

## Overview

The platform is divided into three independent services:

- 🏠 **Smart Home System (SHS)** – Manages energy devices inside individual homes.
- ⚡ **Smart Grid System (SGS)** – Aggregates village-wide energy production and consumption.
- ☁️ **Weather Service** – Retrieves weather data from an external API and publishes it through MQTT.

The frontend is implemented with **Angular**, while the backend consists of multiple **Spring Boot** applications communicating through **REST APIs** and **MQTT**.

---

# Architecture

```text
                           Weather API
                                │
                                ▼
                      Weather Service
                                │
                             MQTT Broker
                                │
        ┌───────────────────────┴───────────────────────┐
        ▼                                               ▼
 Smart Home System (SHS)                     Smart Grid System (SGS)
        │                                               │
        └───────────────────────┬───────────────────────┘
                                │
                              MySQL
                                ▲
                                │
                         Angular Frontend
```

---

# Features

### Smart Home System (SHS)

- Manage smart homes
- Manage smart meters
- Solar panel simulation
- Wind turbine simulation
- Home battery management
- Energy producer management
- Energy consumer management
- RESTful APIs
- MQTT weather & tariff integration

### Smart Grid System (SGS)

- Village-wide energy aggregation
- Battery management
- Grid-level solar panels
- Grid-level wind turbines
- Smart Grid monitoring
- Tariff simulation

### Weather Service

- Retrieves weather data from an external API
- Publishes weather updates via MQTT
- Supports real-time energy calculations

---

# Technology Stack

## Backend

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Frontend

- Angular
- TypeScript
- HTML
- CSS

## Database

- MySQL

## Messaging

- MQTT
- Eclipse Paho MQTT Client

## Development

- Docker
- Git
- GitHub

---

# Project Structure

```text
Smart Village
│
├── SHS
│   ├── Controllers
│   ├── Services
│   ├── Repositories
│   ├── Entities
│   └── MQTT
│
├── SGS
│   ├── Controllers
│   ├── Services
│   ├── Repositories
│   ├── Entities
│   └── MQTT
│
├── mqtt-spring-broker-master
│   ├── Weather Service
│   ├── MQTT Publisher
│   └── MQTT Subscriber
│
└── shsfrontendla
    ├── Angular Components
    ├── Services
    └── Routing
```

---

# System Flow

### REST Communication

```text
Angular
    │
    ▼
REST Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
MySQL
```

---

### MQTT Communication

```text
Weather API
      │
      ▼
Weather Service
      │
      ▼
MQTT Broker
      │
      ▼
SHS MQTT Subscriber
      │
      ▼
Energy Calculation
```

---

# My Contributions

As part of this university team project, my contributions included:

- Developing REST APIs using Spring Boot
- Implementing persistence with Spring Data JPA and MySQL
- Integrating MQTT-based weather and tariff communication
- Connecting Angular frontend components with backend APIs
- Refactoring and improving code quality
- Debugging and maintaining backend functionality

---

# What I Learned

Through this project I gained hands-on experience with:

- Distributed backend architecture
- Layered software architecture
- Spring Boot
- Spring Data JPA
- RESTful API development
- MySQL
- MQTT messaging
- Angular
- Team collaboration using Git

---

# Future Improvements

- Authentication & Authorization
- Swagger / OpenAPI Documentation
- Unit & Integration Testing
- CI/CD Pipeline
- Docker Compose orchestration
- Kubernetes deployment
- Monitoring & Logging

---

# Getting Started

## Prerequisites

- Java 17+
- Maven
- Node.js
- Angular CLI
- MySQL
- Docker (optional)

## Start Backend

Run:

- SHS
- SGS
- Weather Service

using:

```bash
mvn spring-boot:run
```

---

## Start Frontend

```bash
npm install
ng serve
```

Open:

```
http://localhost:4200
```

---

# License

This project was developed as part of a university Software Engineering course and is intended for educational purposes.
