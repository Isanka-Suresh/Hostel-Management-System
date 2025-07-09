# Hostel Management System

A JavaFX application for managing hostel accommodations, including student registration, room management, and reservations.

## Overview

This hostel management system provides functionality for:

- Student registration and management
- Room type management with different categories (AC, Non-AC, with/without food)
- Room reservations and bookings
- User authentication and access control
- Payment status tracking

## Technologies Used

- Java 11
- JavaFX
- Hibernate ORM
- MySQL Database
- Maven
- JFoenix (Material Design)
- Lombok
- Jasper Reports

## Prerequisites

- JDK 11 or higher
- MySQL 8.0
- Maven

## Setup Instructions

### 1. Clone the Repository

```sh
git clone 
cd hostel-management-system
```

### 2. Create MySQL Database

Log into your MySQL server and run:

```sql
CREATE DATABASE hostel;
```

### 3. Configure Hibernate Properties

Edit the `hibernate.properties` file in the `resources` directory:

```properties
hibernate.connection.url = jdbc:mysql://localhost:3306/hostel
hibernate.connection.username = [your-username]
hibernate.connection.password = [your-password]
```

### 4. Build the Project

```sh
mvn clean install
```

### 5. Run the Application

```sh
mvn javafx:run
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── lk/ijse/
│   │       ├── bo/         # Business Objects
│   │       ├── controller/ # JavaFX Controllers
│   │       ├── dao/        # Data Access Objects
│   │       ├── dto/        # Data Transfer Objects
│   │       ├── entity/     # Hibernate Entities
│   │       ├── tm/         # Table Models
│   │       └── util/       # Utilities
│   └── resources/
│       ├── view/           # FXML Views
│       └── hibernate.properties
```

## Features

### Student Management

- Add, update, and delete student records
- View and search student details

### Room Management

- Define room types (AC/Non-AC, with/without food)
- Set key money amounts and rates
- Track availability and manage room quantities

### Reservation System

- Book rooms for students
- Track payment status and reservation dates
- View booking history

### User Management

- User registration and secure login system
- Role-based access control

### Login System

The system provides two types of access:

- Login form for existing users
- Registration form for new users

## Database Schema

Key entities:

- `Student`
- `Room`
- `Reservation`
- `User`

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Create a new Pull Request

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more information.