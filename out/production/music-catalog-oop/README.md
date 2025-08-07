# Music Album Catalog - Java

Project developed as the final assignment for the **Object-Oriented Programming (OOP)** course, taught by professor **Tiago Ravache**.

---

## Description

This system allows users to register, list, search, and remove music albums, organizing information such as:

- Title  
- Artist  
- Year  
- Genre  

---

## Technologies

- Java 17+

---

## Applied Concepts

- Object-Oriented Programming (OOP)  
- SOLID Principles  
- Use of interfaces and abstractions  

---

## Project Structure & SOLID Principles

This project was designed with a strong emphasis on **SOLID principles**, ensuring clean architecture, maintainability, and scalability. The package structure reflects this organization:

### `main`  
Entry point of the application, responsible for starting the program and handling user interaction.

### `model`  
Contains the domain classes, such as `Disco`, which encapsulate the main data attributes and behaviors of a music album.

- Applies **Single Responsibility Principle (SRP)**: each class has only one well-defined purpose.
  
### `repository`  
Responsible for data storage and retrieval. This layer abstracts how the data is persisted (in-memory, files, etc.).

- Applies **Interface Segregation Principle (ISP)** and **Dependency Inversion Principle (DIP)**: higher-level modules depend on abstractions, not concrete implementations.

### `service`  
Contains the business logic. This layer processes the data received from the repository and prepares it for use in the application.

- Applies **Open/Closed Principle (OCP)**: classes are open for extension but closed for modification.
- Applies **Liskov Substitution Principle (LSP)** when working with interfaces or abstract types.

---

This architecture facilitates the separation of concerns and future extension of the system, such as adding a graphical interface or connecting to a database, without needing to modify the existing core logic.
