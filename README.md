# Quiz Microservice Project

## Overview
This project is a quiz application built using a microservices architecture. The application has two main microservices:  
- **Quiz Service**: Handles quiz creation, submissions, and participant interactions.  
- **Question Service**: Manages quiz questions.  

## Tech Stack
- **Spring Boot** - for building the microservices  
- **Java** - the programming language used  
- **REST API** - for communication between services  
- **Docker** - for containerization (if applicable)  
- **MySQL/PostgreSQL** - for database management  

## Features
- Create quizzes  
- Get questions from the Question Service  
- Submit answers  
- Calculate scores  

## Getting Started  

### Prerequisites  
- Java JDK 11 or higher  
- Maven (or Gradle, depending on your setup)  
- MySQL/PostgreSQL  
- Docker (optional, for containerization)  

### Installation  

1. Clone the repository:  
   ```bash
   git clone https://github.com/yourusername/quiz-microservice.git
   cd quiz-microservice
   ```
2. Set up the database:  
   - Update your database configurations in `application.properties` or `application.yml`.  
   - Run the provided SQL script to set up the database schema.  

3. Build the project:  
   ```bash
   mvn clean install
   ```  

4. Run the application:  
   ```bash
   mvn spring-boot:run
   ```  

## API Endpoints  

### **Quiz Service**  
#### **Create Quiz**  
- **POST** `/quizzes`  
  - **Request Body**: Quiz details  

#### **Submit Answers**  
- **POST** `/quizzes/{quizId}/submit`  
  - **Request Body**: Answers to the quiz  

#### **Get Quiz Questions**  
- **GET** `/quizzes/{quizId}/questions`  
  - **Response**: List of questions for the quiz  

### **Question Service**  
#### **Add Question**  
- **POST** `/questions`  
  - **Request Body**: Question details  

#### **Get Question List**  
- **GET** `/questions`  
  - **Response**: List of all questions  

## Contributing  
Contributions are welcome! Please open an issue or submit a pull request.  

## License  
This project is licensed under the MIT License - see the `LICENSE` file for details.  

## Contact  
For questions or feedback, please reach out via GitHub issues.

