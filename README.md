# Quiz App

## Overview

The **Quiz App** is a microservices-based application designed to manage and conduct quizzes. It is built using Java and Spring Boot, incorporating various technologies to ensure scalability, maintainability, and efficient service discovery.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Microservices Architecture](#microservices-architecture)
  - [1. Question Service](#1-question-service)
  - [2. Quiz Service](#2-quiz-service)
  - [3. Service Registry](#3-service-registry)
- [API Endpoints](#api-endpoints)
  - [Question Service API](#question-service-api)
  - [Quiz Service API](#quiz-service-api)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Building and Running](#building-and-running)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Microservices Architecture**: The application is divided into distinct services, each handling specific functionalities.
- **Service Discovery**: Utilizes Eureka for efficient service registration and discovery.
- **RESTful APIs**: Provides endpoints for managing questions and quizzes.
- **Database Integration**: Employs PostgreSQL for data persistence.
- **Simplified Codebase**: Uses Lombok to reduce boilerplate code.

## Technologies Used

- **Java 21**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **Spring Web**
- **PostgreSQL**
- **Lombok**
- **Eureka Client**
- **Maven**

## Microservices Architecture

### 1. Question Service

Handles all operations related to quiz questions.

- **Technologies**: Spring Boot, Spring Data JPA, PostgreSQL, Lombok, Eureka Client.

### 2. Quiz Service

Manages quizzes, including creating quizzes and retrieving quiz details.

- **Technologies**: Spring Boot, Spring Web, Eureka Client.

### 3. Service Registry

Acts as the Eureka Server for service registration and discovery.

- **Technologies**: Spring Boot, Spring Cloud Netflix Eureka Server.

## API Endpoints

### Question Service API

| Method  | Endpoint                          | Description |
|---------|----------------------------------|-------------|
| **GET**  | `/question/allQuestions`         | Fetch all questions. |
| **GET**  | `/question/category/{category}`  | Fetch questions by category. |
| **POST** | `/question/add`                  | Add a new question. |
| **PUT**  | `/question/update`               | Update an existing question. |
| **DELETE** | `/question/delete/{id}`        | Delete a question by ID. |
| **GET**  | `/question/generate`             | Generate random questions for quiz. |
| **POST** | `/question/getQuestions`         | Fetch questions by IDs. |
| **POST** | `/question/getScore`             | Calculate score for responses. |

### Quiz Service API

| Method  | Endpoint            | Description |
|---------|----------------------|-------------|
| **POST** | `/quiz/create`       | Create a new quiz. |
| **GET**  | `/quiz/get/{id}`     | Fetch quiz questions by quiz ID. |
| **POST** | `/quiz/submit/{id}`  | Submit quiz responses and get score. |

## Getting Started

### Prerequisites

- **Java 21** or later
- **Maven** (for building the project)
- **PostgreSQL** (for the Question Service database)

### Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Deeppati2005/quiz-app.git
   cd quiz-app
   ```

2. **Set Up PostgreSQL Database**:

   - Create a new database named `quizdb`.
   - Update the `application.properties` file in the Question Service with your PostgreSQL credentials.

3. **Build the Project**:

   ```bash
   mvn clean install
   ```

## Configuration

- **Question Service**: Configure the `application.properties` file with the PostgreSQL database URL, username, and password.
- **Eureka Client**: Ensure that the Eureka Server URL is correctly specified in the client services for proper registration.

## Building and Running

1. **Start the Service Registry**:

   Navigate to the `service-registry` directory and run:

   ```bash
   mvn spring-boot:run
   ```

2. **Start the Question Service**:

   Navigate to the `question-service` directory and run:

   ```bash
   mvn spring-boot:run
   ```

3. **Start the Quiz Service**:

   Navigate to the `quiz-service` directory and run:

   ```bash
   mvn spring-boot:run
   ```

The services should now be up and running, registered with the Eureka Server.

## Testing

- **API Testing**: Use tools like Postman or cURL to test the RESTful endpoints of the Question and Quiz Services.
- **Unit Testing**: Run the unit tests using Maven:

  ```bash
  mvn test
  ```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
