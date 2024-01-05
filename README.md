# Quiz Application
Welcome to the Quiz Application project! This Spring Boot web application allows users to attend quizzes, create their own quizzes, and manage quiz content. Whether you're a quiz enthusiast or someone looking to create and share quizzes with others, this application provides a user-friendly platform to engage in interactive quizzes.

## Technologies Used
1. Java: The core programming language for the application.
2. Spring Boot: A powerful framework for building Java-based web applications, providing a robust and efficient development environment.
3. MySQL: The relational database management system used for storing and managing quiz data.
   
## Features

#### User Authentication:
Secure user authentication to ensure that only authorized users can create, delete, and attend quizzes.

#### Quiz Management:
1. Create quizzes with custom questions and answers.
2. Delete quizzes that are no longer needed.

#### Quiz Attendance:
1. Users can attend quizzes and receive instant feedback on their performance.

   
## Getting Started

#### Prerequisites
1. Java Development Kit (JDK) installed on your machine.
2. MySQL installed and configured.

#### Configure the database connection in application.properties
+ spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
+ spring.datasource.username=your-username
+ spring.datasource.password=your-password


#### Build and run the application:
+ ./mvnw spring-boot:run
  The application will be accessible at http://localhost:8080.

### Acknowledgments
Special thanks to the Spring Boot and MySQL communities for their excellent documentation and support.
Feel free to explore the application, create quizzes, and enhance its features! If you encounter any issues or have suggestions for improvements, please open an issue on this repository. Happy quizzing!
