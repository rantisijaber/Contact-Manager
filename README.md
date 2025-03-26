# Contacts App

A Spring Boot-based Contacts App that allows users to manage their contacts securely using JWT authentication. The application exposes REST APIs to interact with the system, handles user authentication using JWT, and leverages AWS S3 buckets for storing contact-related files. Both contact and user data are stored in a MySQL database.

## Features:

- **REST APIs**: Exposes RESTful endpoints for managing contacts, uploading files, and user authentication.
- **User Authentication**: JWT authentication for secure user login and access control.
- **Contact Management**: Add, update, delete, and view contacts.
- **File Storage**: Upload and store contact-related files securely in AWS S3 buckets.
- **Role-Based Access**: Different roles (e.g., Admin, User) with restricted access to certain endpoints.

## Technologies Used:

- **Spring Boot**: For creating the application backend.
- **Spring Security**: For JWT-based authentication and authorization.
- **JWT (JSON Web Token)**: For stateless user authentication.
- **AWS S3**: For storing and managing contact-related files.
- **MySQL**: For storing both contact and user data.
- **JPA (Java Persistence API)**: For interacting with the MySQL database.
- **REST APIs**: To handle all interactions with the frontend and external systems.
