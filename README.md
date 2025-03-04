# JavaFX Desktop Application - Gestion Cabinet

This is a JavaFX desktop application for managing patient consultations

## 📌 Features
- Add, update, and delete consultations
- Select patients from a dropdown list
- Store and retrieve data from a database (PostgreSQL)

## 🛠️ Setup & Installation

### 1️⃣ Prerequisites
Ensure you have the following installed:
- **Java JDK 11+** → [Download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **JavaFX SDK** → [Download](https://gluonhq.com/products/javafx/)
- **Maven/Gradle** (Optional for dependency management)
- **PostgreSQL** (For database storage)

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/RajaaKacemi/gestion_cabinet.git
```
## Configure Database
Open PostgeSQL Workbench (or any database client).

Create a database:

CREATE DATABASE Cabinet;

## Update DBConnection.java with your database credentials:

- private static final String URL = "jdbc:postgresql://localhost:5432/Cabinet";
- private static final String USER = "your-username";
- private static final String PASSWORD = "your-password";

##  Run the Application

## Using an IDE (IntelliJ, Eclipse)
- Open the project in your IDE
- Run Main.java

## Technologies Used

- JavaFX for UI
- JDBC for database connectivity
- MySQL/PostgreSQL for data storage
- Maven (if applicable)