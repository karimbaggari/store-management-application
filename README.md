NiceStore Application Documentation
Overview

The NiceStore application is a Spring Boot-based web application designed to provide inventory management functionality. It offers a RESTful API for adding products to inventory. The application's primary goal is to efficiently manage the inventory by allowing users to add products.
Features

    Inventory Management: The core feature of the application is to manage an inventory of products. Users can add new products to the inventory.

Project Structure

The project is organized as follows:

    Application: The application's main entry point is the NiceStoreApplication class, which is the Spring Boot application class.

    Controller: The SampleController class is responsible for handling HTTP requests related to product management. It exposes a single endpoint for adding products to the inventory.

    Service: The SupplyService class contains business logic for product management. It is used by the SampleController to process requests and manage the inventory.

    Testing: The application follows the Test-Driven Development (TDD) approach. Unit tests are implemented using JUnit to ensure the correctness of the application. Test cases are written before the actual functionality is implemented.

API Documentation

The project uses the springdoc-openapi-ui library to automatically generate API documentation for the exposed endpoints. The API documentation can be accessed through the Swagger UI, which is available at the following URL:

    Swagger UI: http://localhost:8081/swagger-ui/index.html

Getting Started

To run the NiceStore application, follow these steps:

    Clone the project repository from GitHub.

    Open the project in your favorite IDE or code editor.

    Build and run the project using Maven or Gradle.

    Access the Swagger UI to explore and interact with the API:

    http://localhost:8081/swagger-ui/index.html

Testing

The project follows Test-Driven Development (TDD) practices. Test cases are written before implementing the actual functionality. JUnit is used for writing unit tests to ensure the correctness of the application.
Dependencies

    Spring Boot: The project is built on the Spring Boot framework, which provides a robust foundation for building web applications.

    springdoc-openapi-ui: This library is used for generating API documentation and Swagger UI.

    JUnit: JUnit is used for writing unit tests to validate the application's functionality.

Conclusion

The NiceStore application is a simple yet efficient inventory management system built on Spring Boot. It follows best practices by generating API documentation and adheres to the principles of Test-Driven Development to ensure code quality.

Feel free to explore the code and test cases to understand how the application works and how it can be extended to meet your specific requirements.
